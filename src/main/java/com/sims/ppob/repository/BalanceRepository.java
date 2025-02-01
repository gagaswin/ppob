package com.sims.ppob.repository;

import com.sims.ppob.models.entity.Balance;
import com.sims.ppob.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, String> {
  Optional<Balance> findByUser(User user);
}
