package com.sims.ppob.controllers;

import com.sims.ppob.models.dtos.CommonResponseDto;
import com.sims.ppob.models.dtos.auth.LoginUserRequestDto;
import com.sims.ppob.models.dtos.auth.LoginUserResponseDto;
import com.sims.ppob.models.dtos.auth.RegisterUserRequestDto;
import com.sims.ppob.services.AuthService;
import com.sims.ppob.utils.CookieUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
  private final AuthService authService;
  private final CookieUtil cookieUtil;

  @PostMapping("/registration")
  public ResponseEntity<CommonResponseDto<Void>> register(@RequestBody RegisterUserRequestDto registerUserRequestDto) {
    authService.register(registerUserRequestDto);

    CommonResponseDto<Void> response = CommonResponseDto.<Void>builder()
        .status(HttpStatus.OK.value())
        .message("Registrasi berhasil silahkan login")
        .data(null)
        .build();
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @PostMapping("/login")
  public ResponseEntity<CommonResponseDto<LoginUserResponseDto>> login(HttpServletResponse servletResponse,
                                                                       @RequestBody LoginUserRequestDto loginUserRequestDto) {
    LoginUserResponseDto loginResponse = authService.login(loginUserRequestDto);

    cookieUtil.addCookieToResponse(servletResponse,
        cookieUtil.createCookie("token", loginResponse.getToken()));

    CommonResponseDto<LoginUserResponseDto> response = CommonResponseDto.<LoginUserResponseDto>builder()
        .status(HttpStatus.OK.value())
        .message("Login Sukses")
        .data(loginResponse)
        .build();
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
