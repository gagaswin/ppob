package com.sims.ppob.repository;

import com.sims.ppob.models.entity.ServiceSims;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceSimsRepository extends JpaRepository<ServiceSims, String> {
  @Query(value =
      "SELECT * " +
      "FROM service_sims " +
      "WHERE code = :serviceCode", nativeQuery = true)
  Optional<ServiceSims> findByCode(@Param("serviceCode") String serviceCode);
}
