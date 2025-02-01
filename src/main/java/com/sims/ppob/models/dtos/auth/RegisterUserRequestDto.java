package com.sims.ppob.models.dtos.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserRequestDto {
  private String email;
  private String firstName;
  private String lastName;
  private String password;
}
