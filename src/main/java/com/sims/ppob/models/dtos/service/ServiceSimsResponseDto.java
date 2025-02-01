package com.sims.ppob.models.dtos.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceSimsResponseDto {
  private String service_code;
  private String service_name;
  private String service_icon;
  private Long service_tarif;
}
