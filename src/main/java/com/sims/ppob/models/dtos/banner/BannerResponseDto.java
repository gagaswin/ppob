package com.sims.ppob.models.dtos.banner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BannerResponseDto {
  private String banner_name;
  private String banner_image;
  private String description;
}
