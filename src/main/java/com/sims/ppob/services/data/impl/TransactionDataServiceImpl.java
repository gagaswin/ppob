package com.sims.ppob.services.data.impl;

import com.sims.ppob.models.entity.Transaction;
import com.sims.ppob.models.entity.User;
import com.sims.ppob.repository.TransactionRepository;
import com.sims.ppob.services.data.TransactionDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionDataServiceImpl implements TransactionDataService {
  private final TransactionRepository transactionRepository;

  @Override
  public Page<Transaction> findByUser(User user, Pageable pageable) {
    return this.transactionRepository.findByUser(user, pageable);
  }

  @Override
  public Transaction save(Transaction transaction) {
    return this.transactionRepository.save(transaction);
  }

  @Override
  public long countByInvoiceStartingWith(String prefix) {
    return this.transactionRepository.countByInvoiceStartingWith(prefix);
  }

  @Override
  public List<Transaction> findAllByUserOrderByCreatedAtDesc(User user) {
    return this.transactionRepository.findAllByUserOrderByCreatedAtDesc(user);
  }
}
