package com.sims.ppob.services.impl;

import com.sims.ppob.enums.ETransactionType;
import com.sims.ppob.exceptions.BalanceException;
import com.sims.ppob.exceptions.ResourceNotFoundException;
import com.sims.ppob.models.dtos.transaction.CreateTransactionRequestDto;
import com.sims.ppob.models.dtos.transaction.GetTransactionResponseDto;
import com.sims.ppob.models.dtos.transaction.HistoryResponseDto;
import com.sims.ppob.models.dtos.transaction.TransactionResponseDto;
import com.sims.ppob.models.entity.ServiceSims;
import com.sims.ppob.models.entity.Transaction;
import com.sims.ppob.models.entity.User;
import com.sims.ppob.services.ServiceSimsService;
import com.sims.ppob.services.TransactionService;
import com.sims.ppob.services.UserService;
import com.sims.ppob.services.data.ServiceSimsDataService;
import com.sims.ppob.services.data.TransactionDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
  private final TransactionDataService transactionDataService;
  private final ServiceSimsService serviceSimsService;
  private final ServiceSimsDataService serviceSimsDataService;
  private final UserService userService;

  @Override
  public List<Transaction> findByUserWithPagination(User user, Integer offset, Integer limit) {
    Pageable pageable = PageRequest.of(offset, limit);
    Page<Transaction> transactionPage = this.transactionDataService.findByUser(user, pageable);

    return transactionPage.getContent();
  }

  @Override
  public TransactionResponseDto createTransaction(Authentication authentication, CreateTransactionRequestDto createTransactionRequestDto) {
    User currentUser = this.userService.getUserAuth(authentication);

    ServiceSims currentService = this.serviceSimsDataService.findByCode(createTransactionRequestDto.getService_code())
        .orElseThrow(() -> new ResourceNotFoundException("Service ataus Layanan tidak ditemukan"));

    if (currentUser.getBalance().getCurrentBalance() < currentService.getPrice()) {
      throw new BalanceException("Saldo tidak cukup");
    }

    String invoiceNumber = generateInvoiceNumber();

    Transaction createTransaction = Transaction.builder()
        .invoice(invoiceNumber)
        .amount(currentService.getPrice())
        .type(ETransactionType.PAYMENT)
        .createdAt(LocalDateTime.now())
        .user(currentUser)
        .serviceSims(currentService)
        .build();

    Transaction saveTransaction = this.transactionDataService.save(createTransaction);

    return TransactionResponseDto.builder()
        .invoice_number(saveTransaction.getInvoice())
        .service_code(saveTransaction.getServiceSims().getCode())
        .service_name(saveTransaction.getServiceSims().getName())
        .transaction_type(saveTransaction.getType().toString())
        .total_amount(saveTransaction.getAmount())
        .created_on(saveTransaction.getCreatedAt())
        .build();
  }

  @Override
  public GetTransactionResponseDto<HistoryResponseDto> getHistory(Authentication authentication, Integer offset, Integer limit) {
    User currentUser = userService.getUserAuth(authentication);

    List<Transaction> transactions;
    if (limit == null) {
      transactions = transactionDataService.findAllByUserOrderByCreatedAtDesc(currentUser);
    } else {
      transactions = this.findByUserWithPagination(currentUser, offset, limit);
    }

    List<HistoryResponseDto> transactionDtos = transactions.stream()
        .map(transaction -> HistoryResponseDto.builder()
                .invoice_number(transaction.getInvoice())
                .transaction_type(transaction.getType().toString())
                .description(serviceSimsService.getServiceNameById(transaction.getServiceSims().getId()))
                .total_amount(transaction.getAmount())
                .created_on(transaction.getCreatedAt())
                .build()
        ).collect(Collectors.toList());

    return GetTransactionResponseDto.<HistoryResponseDto>builder()
        .offset(offset)
        .limit(limit)
        .records(transactionDtos)
        .build();
  }

  private String generateInvoiceNumber() {
    String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy"));
    long invoiceCountToday = transactionDataService.countByInvoiceStartingWith("INV" + currentDate);

    return String.format("INV%s-%03d", currentDate, invoiceCountToday + 1);
  }
}
