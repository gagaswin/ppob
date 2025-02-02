package com.sims.ppob.controllers;

import com.sims.ppob.models.dtos.CommonResponseDto;
import com.sims.ppob.models.dtos.balance.BalanceResponseDto;
import com.sims.ppob.services.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BalanceController {
  private final BalanceService balanceService;

  @GetMapping("/balance")
  public ResponseEntity<CommonResponseDto<BalanceResponseDto>> get(Authentication authentication) {
    BalanceResponseDto balanceResponseDto = this.balanceService.get(authentication);

    CommonResponseDto<BalanceResponseDto> response = CommonResponseDto.<BalanceResponseDto>builder()
        .status(HttpStatus.OK.value())
        .message("Get Balance Berhasil")
        .data(balanceResponseDto)
        .build();
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
