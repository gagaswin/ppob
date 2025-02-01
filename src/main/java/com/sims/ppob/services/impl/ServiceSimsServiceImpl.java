package com.sims.ppob.services.impl;

import com.sims.ppob.models.dtos.banner.BannerResponseDto;
import com.sims.ppob.models.dtos.service.ServiceSimsResponseDto;
import com.sims.ppob.models.entity.ServiceSims;
import com.sims.ppob.models.entity.User;
import com.sims.ppob.services.ServiceSimsService;
import com.sims.ppob.services.UserService;
import com.sims.ppob.services.data.ServiceSimsDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServiceSimsServiceImpl implements ServiceSimsService {
  private final ServiceSimsDataService serviceSimsDataService;
  private final UserService userService;

  @Override
  public List<ServiceSimsResponseDto> getAll(Authentication authentication) {
    this.userService.getUserAuth(authentication);
    Optional<List<ServiceSims>> listServiceSims = this.serviceSimsDataService.findAll();

    return listServiceSims.map(list -> list.stream()
            .map(serviceSims -> ServiceSimsResponseDto.builder()
                .service_code(serviceSims.getCode())
                .service_name(serviceSims.getName())
                .service_icon(serviceSims.getIcon())
                .service_tarif(serviceSims.getPrice())
                .build())
            .collect(Collectors.toList()))
        .orElseGet(List::of);
  }
}
