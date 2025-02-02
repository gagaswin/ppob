package com.sims.ppob.models.dtos.transaction;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetTransactionResponseDto<T> {
  private Integer offset;
  private Integer limit;
  private List<T> records;
}
