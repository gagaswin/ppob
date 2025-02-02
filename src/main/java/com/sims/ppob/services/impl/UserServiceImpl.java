package com.sims.ppob.services.impl;

import com.sims.ppob.exceptions.ResourceNotFoundException;
import com.sims.ppob.models.entity.User;
import com.sims.ppob.services.UserService;
import com.sims.ppob.services.data.UserDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserDataService userDataService;

  @Override
  public User getUserAuth(Authentication authentication) {
    return this.userDataService.findByEmail(authentication.getName())
        .orElseThrow(() -> new ResourceNotFoundException(String.format("User dengan email %s tidak ditemukan", authentication.getName())));
  }
}
