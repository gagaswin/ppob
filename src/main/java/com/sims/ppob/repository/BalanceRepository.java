package com.sims.ppob.repository;

import com.sims.ppob.models.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, String> {
  @Query(value =
      "SELECT * " +
      "FROM balance " +
      "WHERE user_id = :userId", nativeQuery = true)
  Optional<Balance> findByUser(@Param("userId") String userId);
}
