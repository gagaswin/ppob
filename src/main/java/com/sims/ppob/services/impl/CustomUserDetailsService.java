package com.sims.ppob.services.impl;

import com.sims.ppob.models.entity.AppUser;
import com.sims.ppob.models.entity.User;
import com.sims.ppob.services.data.UserDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
  private final UserDataService userDataService;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = this.userDataService.findByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    return AppUser.builder()
        .id(user.getId())
        .email(user.getEmail())
        .password(user.getPassword())
        .build();
  }
}
