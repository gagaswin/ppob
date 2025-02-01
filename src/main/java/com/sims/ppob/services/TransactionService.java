package com.sims.ppob.services;

import com.sims.ppob.models.dtos.transaction.CreateTransactionRequestDto;
import com.sims.ppob.models.dtos.transaction.GetTransactionResponseDto;
import com.sims.ppob.models.dtos.transaction.HistoryResponseDto;
import com.sims.ppob.models.dtos.transaction.TransactionResponseDto;
import com.sims.ppob.models.entity.Transaction;
import com.sims.ppob.models.entity.User;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface TransactionService {
  List<Transaction> findByUserWithPagination(User user, Integer offset, Integer limit);

  TransactionResponseDto createTransaction(Authentication authentication, CreateTransactionRequestDto createTransactionRequestDto);

  GetTransactionResponseDto<HistoryResponseDto> getHistory(Authentication authentication, Integer offset, Integer limit);
}
