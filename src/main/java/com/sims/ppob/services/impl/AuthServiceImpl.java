package com.sims.ppob.services.impl;

import com.sims.ppob.exceptions.UserAlreadyExistsException;
import com.sims.ppob.models.dtos.auth.LoginUserRequestDto;
import com.sims.ppob.models.dtos.auth.LoginUserResponseDto;
import com.sims.ppob.models.dtos.auth.RegisterUserRequestDto;
import com.sims.ppob.models.entity.AppUser;
import com.sims.ppob.models.entity.Profile;
import com.sims.ppob.models.entity.User;
import com.sims.ppob.services.AuthService;
import com.sims.ppob.services.data.UserDataService;
import com.sims.ppob.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
  private final UserDataService userDataService;
  private final JwtUtil jwtUtil;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;

  @Override
  public void register(RegisterUserRequestDto registerUserRequestDto) {
    if (userDataService.findByEmail(registerUserRequestDto.getEmail()).isPresent()) {
      throw new UserAlreadyExistsException("Email sudah terdaftar");
    }

    LocalDateTime now = LocalDateTime.now();

    Profile profile = Profile.builder()
        .firstName(registerUserRequestDto.getFirst_name())
        .lastName(registerUserRequestDto.getLast_name())
        .updatedAt(now)
        .build();

    User user = User.builder()
        .email(registerUserRequestDto.getEmail())
        .password(passwordEncoder.encode(registerUserRequestDto.getPassword()))
        .createdAt(now)
        .profile(profile)
        .build();

    profile.setUser(user);

    userDataService.save(user);
  }

  @Override
  public LoginUserResponseDto login(LoginUserRequestDto loginUserRequestDto) {
    Authentication authentication = this.authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            loginUserRequestDto.getEmail(),
            loginUserRequestDto.getPassword()
        )
    );
    SecurityContextHolder.getContext().setAuthentication(authentication);

    AppUser appUser = (AppUser) authentication.getPrincipal();

    String accessToken = jwtUtil.generateToken(appUser);

    return LoginUserResponseDto.builder()
        .token(accessToken)
        .build();
  }
}
