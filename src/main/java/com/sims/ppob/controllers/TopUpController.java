package com.sims.ppob.controllers;

import com.sims.ppob.models.dtos.CommonResponseDto;
import com.sims.ppob.models.dtos.balance.BalanceResponseDto;
import com.sims.ppob.models.dtos.topup.CreateTopUpRequestDto;
import com.sims.ppob.services.TopUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TopUpController {
  private final TopUpService topUpService;

  @PostMapping("/topup")
  public ResponseEntity<CommonResponseDto<BalanceResponseDto>> createTopUp(Authentication authentication,
                                                                     @RequestBody CreateTopUpRequestDto createTopUpRequestDto) {
    BalanceResponseDto balanceResponse = this.topUpService.createTopUp(authentication, createTopUpRequestDto);

    CommonResponseDto<BalanceResponseDto> response = CommonResponseDto.<BalanceResponseDto>builder()
        .status(HttpStatus.OK.value())
        .message("Top Up Balance berhasil")
        .data(balanceResponse)
        .build();
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
