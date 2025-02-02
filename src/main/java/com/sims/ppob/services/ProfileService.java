package com.sims.ppob.services;

import com.sims.ppob.models.dtos.profile.ProfileResponseDto;
import com.sims.ppob.models.dtos.profile.UpdateProfileRequestDto;
import org.springframework.security.core.Authentication;

public interface ProfileService {
  ProfileResponseDto get(Authentication authentication);

  ProfileResponseDto update(Authentication authentication, UpdateProfileRequestDto updateProfileRequestDto);
}
