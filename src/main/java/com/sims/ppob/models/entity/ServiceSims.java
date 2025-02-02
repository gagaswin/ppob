package com.sims.ppob.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name = "service_sims")
public class ServiceSims {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private String id;

  @Column(name = "code", unique = true, nullable = false)
  private String code;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "icon", nullable = false)
  private String icon;

  @Column(name = "price", nullable = false)
  private Long price;

  // RELATION
  @OneToMany(mappedBy = "serviceSims")
  private List<Transaction> transactions = new ArrayList<>();
}
