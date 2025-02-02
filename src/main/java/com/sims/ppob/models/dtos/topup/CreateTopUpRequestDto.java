package com.sims.ppob.models.dtos.topup;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTopUpRequestDto {
  private Long top_up_amount;
}
