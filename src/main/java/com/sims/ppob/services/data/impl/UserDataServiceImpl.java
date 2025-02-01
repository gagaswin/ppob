package com.sims.ppob.services.data.impl;

import com.sims.ppob.models.entity.User;
import com.sims.ppob.repository.UserRepository;
import com.sims.ppob.services.data.UserDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDataServiceImpl implements UserDataService {
  private final UserRepository userRepository;

  @Override
  public Optional<User> findByEmail(String email) {
    return this.userRepository.findByEmail(email);
  }

  @Override
  public void saveUser(User user) {
    this.userRepository.save(user);
  }
}
