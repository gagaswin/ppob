package com.sims.ppob.services.impl;

import com.sims.ppob.models.dtos.balance.BalanceResponseDto;
import com.sims.ppob.models.entity.User;
import com.sims.ppob.services.BalanceService;
import com.sims.ppob.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {
  private final UserService userService;

  @Override
  public BalanceResponseDto get(Authentication authentication) {
    User currentUser = this.userService.getUserAuth(authentication);

    return BalanceResponseDto.builder()
        .balance(currentUser.getBalance().getCurrentBalance())
        .build();
  }
}
