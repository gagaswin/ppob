package com.sims.ppob.controllers;

import com.sims.ppob.models.dtos.CommonResponseDto;
import com.sims.ppob.models.dtos.profile.ProfileResponseDto;
import com.sims.ppob.models.dtos.profile.UpdateProfileRequestDto;
import com.sims.ppob.services.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
  private final ProfileService profileService;

  @GetMapping
  public ResponseEntity<CommonResponseDto<ProfileResponseDto>> get(Authentication authentication) {
    ProfileResponseDto profileResponse = this.profileService.get(authentication);

    CommonResponseDto<ProfileResponseDto> response = CommonResponseDto.<ProfileResponseDto>builder()
        .status(HttpStatus.OK.value())
        .message("Sukses")
        .data(profileResponse)
        .build();
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @PutMapping("/update")
  public ResponseEntity<CommonResponseDto<ProfileResponseDto>> update(Authentication authentication,
                                                                      @RequestBody UpdateProfileRequestDto updateProfileRequestDto) {
    ProfileResponseDto updateResponse = this.profileService.update(authentication, updateProfileRequestDto);

    CommonResponseDto<ProfileResponseDto> response = CommonResponseDto.<ProfileResponseDto>builder()
        .status(HttpStatus.OK.value())
        .message("Update Pofile berhasil")
        .data(updateResponse)
        .build();
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
