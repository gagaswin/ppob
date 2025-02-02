package com.sims.ppob.services.data;

import com.sims.ppob.models.entity.User;

import java.util.Optional;

public interface UserDataService {
  Optional<User> findByEmail(String email);

  void save(User user);
}
