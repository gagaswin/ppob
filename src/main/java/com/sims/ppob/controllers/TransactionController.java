package com.sims.ppob.controllers;

import com.sims.ppob.models.dtos.CommonResponseDto;
import com.sims.ppob.models.dtos.transaction.CreateTransactionRequestDto;
import com.sims.ppob.models.dtos.transaction.GetTransactionResponseDto;
import com.sims.ppob.models.dtos.transaction.HistoryResponseDto;
import com.sims.ppob.models.dtos.transaction.TransactionResponseDto;
import com.sims.ppob.services.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {
  private final TransactionService transactionService;

  @PostMapping
  public ResponseEntity<CommonResponseDto<TransactionResponseDto>> create(Authentication authentication,
                                                                          @RequestBody CreateTransactionRequestDto createTransactionRequestDto) {
    TransactionResponseDto transactionResponse = this.transactionService.createTransaction(authentication, createTransactionRequestDto);

    CommonResponseDto<TransactionResponseDto> response = CommonResponseDto.<TransactionResponseDto>builder()
        .status(HttpStatus.OK.value())
        .message("Transaksi berhasil")
        .data(transactionResponse)
        .build();

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @GetMapping("/history")
  public ResponseEntity<CommonResponseDto<GetTransactionResponseDto<HistoryResponseDto>>> getHistory(
      Authentication authentication,
      @RequestParam(value = "offset", defaultValue = "0") Integer offset,
      @RequestParam(value = "limit", required = false) Integer limit) {

    GetTransactionResponseDto<HistoryResponseDto> getHistory = this.transactionService.getHistory(authentication, offset, limit);

    CommonResponseDto<GetTransactionResponseDto<HistoryResponseDto>> response = CommonResponseDto.<GetTransactionResponseDto<HistoryResponseDto>>builder()
        .status(HttpStatus.OK.value())
        .message("Get History Berhasil")
        .data(getHistory)
        .build();

    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
