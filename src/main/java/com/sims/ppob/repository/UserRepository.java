package com.sims.ppob.repository;

import com.sims.ppob.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
  @Query(value =
      "SELECT * " +
      "FROM users " +
      "WHERE email = :email",
      nativeQuery = true)
  Optional<User> findByEmail(@Param("email") String email);
}
