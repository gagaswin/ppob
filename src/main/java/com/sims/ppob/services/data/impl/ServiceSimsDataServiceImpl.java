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
  public List<ServiceSims> findAll() {
    return this.serviceSimsRepository.findAll();
  }

  @Override
  public Optional<ServiceSims> findByCode(String serviceCode) {
    return this.serviceSimsRepository.findByCode(serviceCode);
  }

  @Override
  public Optional<ServiceSims> findById(String id) {
    return this.serviceSimsRepository.findById(id);
  }
}
