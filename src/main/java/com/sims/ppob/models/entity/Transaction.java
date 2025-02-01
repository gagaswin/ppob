package com.sims.ppob.models.entity;

import com.sims.ppob.enums.ETransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name = "transaction")
public class Transaction {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private String id;

  @Column(name = "invoice", unique = true, nullable = false)
  private String invoice;

  @Column(name = "amount", nullable = false)
  private BigInteger amount;

  @Enumerated(EnumType.STRING)
  @Column(name = "type", nullable = false)
  private ETransactionType type;

  @Column(name = "created_at", nullable = false)
  private LocalDateTime createdAt = LocalDateTime.now();

  // RELATION
  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "service_id", nullable = false)
  private Service service;
}
