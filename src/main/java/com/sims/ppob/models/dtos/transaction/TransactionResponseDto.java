package com.sims.ppob.models.dtos.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionResponseDto {
  private String invoice_number;
  private String service_code;
  private String service_name;
  private String transaction_type;
  private Long total_amount;
  private LocalDateTime created_on;
}
