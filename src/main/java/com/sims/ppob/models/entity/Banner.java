package com.sims.ppob.models.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Table(name = "banner")
public class Banner {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private String id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "image_url")
  private String imageUrl;

  @Column(name = "description")
  private String description;
}
