package com.sims.ppob.models.entity;

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
@Table(name = "top_up")
public class TopUp {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id")
  private String id;

  @Column(name = "amount")
  private BigInteger amount;

  @Column(name = "created_at")
  private LocalDateTime createdAt = LocalDateTime.now();

  // Relation
  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;
}
