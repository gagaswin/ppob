package com.sims.ppob.services.data.impl;

import com.sims.ppob.models.entity.Balance;
import com.sims.ppob.models.entity.User;
import com.sims.ppob.repository.BalanceRepository;
import com.sims.ppob.services.data.BalanceDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BalanceDataServiceImpl implements BalanceDataService {
  private final BalanceRepository balanceRepository;

  @Override
  public Optional<Balance> findByUser(User user) {
    return balanceRepository.findByUser(user);
  }

  @Override
  public Balance save(Balance balance) {
    return this.balanceRepository.save(balance);
  }
}
