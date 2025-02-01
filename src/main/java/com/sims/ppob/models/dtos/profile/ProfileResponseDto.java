package com.sims.ppob.models.dtos.profile;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileResponseDto {
  private String email;
  private String first_name;
  private String last_name;
  private String profile_image;
}
