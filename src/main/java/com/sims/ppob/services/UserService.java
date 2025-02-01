package com.sims.ppob.services;

import com.sims.ppob.models.entity.User;
import org.springframework.security.core.Authentication;

public interface UserService {
  User getUserAuth(Authentication authentication);
}
