package com.sims.ppob.services.data;

import com.sims.ppob.models.entity.Transaction;
import com.sims.ppob.models.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TransactionDataService {
  Page<Transaction> findByUser(User user, Pageable pageable);

  Transaction save(Transaction transaction);

  long countByInvoiceStartingWith(String prefix);

  List<Transaction> findAllByUserOrderByCreatedAtDesc(User user);
}
