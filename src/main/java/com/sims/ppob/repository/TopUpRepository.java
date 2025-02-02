package com.sims.ppob.repository;

import com.sims.ppob.models.entity.TopUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopUpRepository extends JpaRepository<TopUp, String> {
}
