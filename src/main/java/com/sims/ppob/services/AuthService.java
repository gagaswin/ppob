package com.sims.ppob.services;

import com.sims.ppob.models.dtos.auth.LoginUserRequestDto;
import com.sims.ppob.models.dtos.auth.LoginUserResponseDto;
import com.sims.ppob.models.dtos.auth.RegisterUserRequestDto;

public interface AuthService {
  void register(RegisterUserRequestDto registerUserRequestDto);

  LoginUserResponseDto login(LoginUserRequestDto loginUserRequestDto);
}
