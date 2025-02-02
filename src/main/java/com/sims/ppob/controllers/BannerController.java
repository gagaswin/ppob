package com.sims.ppob.controllers;

import com.sims.ppob.models.dtos.CommonResponseDto;
import com.sims.ppob.models.dtos.banner.BannerResponseDto;
import com.sims.ppob.services.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BannerController {
  private final BannerService bannerService;

  @GetMapping("/banner")
  public ResponseEntity<CommonResponseDto<List<BannerResponseDto>>> getAll() {
    List<BannerResponseDto> bannersResponse = this.bannerService.getAll();

    CommonResponseDto<List<BannerResponseDto>> response = CommonResponseDto.<List<BannerResponseDto>>builder()
        .status(HttpStatus.OK.value())
        .message("Sukses")
        .data(bannersResponse)
        .build();
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
}