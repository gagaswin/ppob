package com.sims.ppob.controllers;

import com.sims.ppob.models.dtos.CommonResponseDto;
import com.sims.ppob.models.dtos.service.ServiceSimsResponseDto;
import com.sims.ppob.services.ServiceSimsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ServiceSimsController {
  private final ServiceSimsService serviceSimsService;

  @GetMapping("/services")
  public ResponseEntity<CommonResponseDto<List<ServiceSimsResponseDto>>> getAll(Authentication authentication) {
    List<ServiceSimsResponseDto> getServices = serviceSimsService.getAll(authentication);

    CommonResponseDto<List<ServiceSimsResponseDto>> response = CommonResponseDto.<List<ServiceSimsResponseDto>>builder()
        .status(HttpStatus.OK.value())
        .message("Sukses")
        .data(getServices)
        .build();
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}
