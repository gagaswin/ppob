package com.sims.ppob.repository;

import com.sims.ppob.models.entity.Transaction;
import com.sims.ppob.models.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
  long countByInvoiceStartingWith(String prefix);

  Page<Transaction> findByUser(User user, Pageable pageable);

  List<Transaction> findAllByUserOrderByCreatedAtDesc(User user);
}
