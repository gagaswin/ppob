package com.sims.ppob.repository;

import com.sims.ppob.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
  @Query(value =
      "SELECT * " +
      "FROM users " +
      "WHERE email = :email",
      nativeQuery = true)
  Optional<User> findByEmail(@Param("email") String email);

//  @Transactional
//  @Modifying(clearAutomatically = true)
//  @Query(value =
//      "INSERT INTO users (id, email, first_name, last_name, password, created_at) " +
//      "VALUES (:#{#user.id}, :#{#user.email}, :#{#user.profile.firstName}, :#{#user.profile.lastName}, :#{#user.password}, :#{#user.createdAt})",
//      nativeQuery = true)
//  void saveUser(@Param("user") User user);
}
