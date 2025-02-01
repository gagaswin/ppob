package com.sims.ppob.services;

import com.sims.ppob.models.dtos.balance.BalanceResponseDto;
import com.sims.ppob.models.dtos.topup.CreateTopUpRequestDto;
import org.springframework.security.core.Authentication;

public interface TopUpService {
  BalanceResponseDto createTopUp(Authentication authentication, CreateTopUpRequestDto createTopUpRequestDto);
}
