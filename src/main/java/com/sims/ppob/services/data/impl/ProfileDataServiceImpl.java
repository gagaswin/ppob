package com.sims.ppob.services.data.impl;

import com.sims.ppob.models.entity.Profile;
import com.sims.ppob.repository.ProfileRepository;
import com.sims.ppob.services.data.ProfileDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileDataServiceImpl implements ProfileDataService {
  private final ProfileRepository profileRepository;

  @Override
  public Profile save(Profile profile) {
    return this.profileRepository.save(profile);
  }
}
