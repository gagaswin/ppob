package com.sims.ppob.repository;

import com.sims.ppob.models.entity.ServiceSims;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceSimsRepository extends JpaRepository<ServiceSims, String> {
  Optional<ServiceSims> findByCode(String serviceCode);
}
