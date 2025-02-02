package com.sims.ppob.services.impl;

import com.sims.ppob.models.dtos.profile.ProfileResponseDto;
import com.sims.ppob.models.dtos.profile.UpdateProfileRequestDto;
import com.sims.ppob.models.entity.Profile;
import com.sims.ppob.models.entity.User;
import com.sims.ppob.services.ProfileService;
import com.sims.ppob.services.UserService;
import com.sims.ppob.services.data.ProfileDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
  private final ProfileDataService profileDataService;
  private final UserService userService;

  @Override
  public ProfileResponseDto get(Authentication authentication) {
    User currentUser = this.userService.getUserAuth(authentication);

    return ProfileResponseDto.builder()
        .email(currentUser.getEmail())
        .first_name(currentUser.getProfile().getFirstName())
        .last_name(currentUser.getProfile().getLastName())
        .profile_image(currentUser.getProfile().getProfileImage())
        .build();
  }

  @Override
  public ProfileResponseDto update(Authentication authentication, UpdateProfileRequestDto updateProfileRequestDto) {
    User currentUser = this.userService.getUserAuth(authentication);

    Profile currentProfile = currentUser.getProfile();
    currentProfile.setFirstName(updateProfileRequestDto.getFirst_name());
    currentProfile.setLastName(updateProfileRequestDto.getLast_name());
    currentProfile.setUpdatedAt(LocalDateTime.now());

    Profile updatedProfile = this.profileDataService.save(currentProfile);

    return ProfileResponseDto.builder()
        .email(currentUser.getEmail())
        .first_name(updatedProfile.getFirstName())
        .last_name(updatedProfile.getLastName())
        .profile_image(currentUser.getProfile().getProfileImage())
        .build();
  }
}
