package com.sims.ppob.services.impl;

import com.sims.ppob.models.dtos.balance.BalanceResponseDto;
import com.sims.ppob.models.dtos.topup.CreateTopUpRequestDto;
import com.sims.ppob.models.entity.Balance;
import com.sims.ppob.models.entity.TopUp;
import com.sims.ppob.models.entity.User;
import com.sims.ppob.services.TopUpService;
import com.sims.ppob.services.UserService;
import com.sims.ppob.services.data.BalanceDataService;
import com.sims.ppob.services.data.TopUpDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TopUpServiceImpl implements TopUpService {
  private final TopUpDataService topUpDataService;
  private final BalanceDataService balanceDataService;
  private final UserService userService;

  @Override
  @Transactional
  public BalanceResponseDto createTopUp(Authentication authentication, CreateTopUpRequestDto createTopUpRequestDto) {
    User currentUser = this.userService.getUserAuth(authentication);

    TopUp createTopUp = TopUp.builder()
        .amount(createTopUpRequestDto.getTop_up_amount())
        .createdAt(LocalDateTime.now())
        .user(currentUser)
        .build();

    Balance existingBalance = balanceDataService.findByUser(currentUser)
        .orElseThrow(() -> new RuntimeException("Saldo tidak ditemukan untuk user ini"));

    existingBalance.setCurrentBalance(existingBalance.getCurrentBalance() + createTopUpRequestDto.getTop_up_amount());
    existingBalance.setUpdatedAt(LocalDateTime.now());

    topUpDataService.save(createTopUp);
    Balance updatedBalance = balanceDataService.save(existingBalance);

    return BalanceResponseDto.builder()
        .balance(updatedBalance.getCurrentBalance())
        .build();
  }
}
