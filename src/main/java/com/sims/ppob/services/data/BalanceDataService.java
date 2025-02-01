package com.sims.ppob.services.data;

import com.sims.ppob.models.entity.Balance;
import com.sims.ppob.models.entity.User;

import java.util.Optional;

public interface BalanceDataService {
  Optional<Balance> findByUser(User user);

  Balance save(Balance balance);
}
