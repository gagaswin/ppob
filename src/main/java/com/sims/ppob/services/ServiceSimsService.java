package com.sims.ppob.services;

import com.sims.ppob.models.dtos.service.ServiceSimsResponseDto;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface ServiceSimsService {
  String getServiceNameById(String serviceId);

  List<ServiceSimsResponseDto> getAll(Authentication authentication);
}
