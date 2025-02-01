package com.sims.ppob.services.data.impl;

import com.sims.ppob.models.entity.ServiceSims;
import com.sims.ppob.repository.ServiceSimsRepository;
import com.sims.ppob.services.data.ServiceSimsDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServiceSimsDataServiceImpl implements ServiceSimsDataService {
  private final ServiceSimsRepository serviceSimsRepository;

  @Override
  public Optional<List<ServiceSims>> findAll() {
    List<ServiceSims> serviceSims = this.serviceSimsRepository.findAll();
    return serviceSims.isEmpty() ? Optional.empty() : Optional.of(serviceSims);
  }

  @Override
  public Optional<ServiceSims> findByCode(String serviceCode) {
    return serviceSimsRepository.findByCode(serviceCode);
  }

  @Override
  public Optional<ServiceSims> findById(String id) {
    return this.serviceSimsRepository.findById(id);
  }
}
