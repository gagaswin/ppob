package com.sims.ppob.services;

import com.sims.ppob.models.dtos.balance.BalanceResponseDto;
import org.springframework.security.core.Authentication;

public interface BalanceService {
  BalanceResponseDto get(Authentication authentication);
}
