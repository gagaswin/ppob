package com.sims.ppob.repository;

import com.sims.ppob.models.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
  @Query(value =
      "SELECT COUNT(*) " +
      "FROM transaction " +
      "WHERE invoice LIKE CONCAT(:prefix, '%')", nativeQuery = true)
  long countByInvoiceStartingWith(@Param("prefix") String prefix);

  @Query(value =
      "SELECT * " +
      "FROM transaction " +
      "WHERE user_id = :userId "+
      "ORDER BY created_at DESC",
      countQuery =
      "SELECT COUNT(*) " +
      "FROM transaction " +
      "WHERE user_id = :userId",
      nativeQuery = true)
  Page<Transaction> findByUser(@Param("userId") String userId, Pageable pageable);

  @Query(value =
      "SELECT * " +
      "FROM transaction " +
      "WHERE user_id = :userId " +
      "ORDER BY created_at DESC", nativeQuery = true)
  List<Transaction> findAllByUserOrderByCreatedAtDesc(@Param("userId") String userId);
}
