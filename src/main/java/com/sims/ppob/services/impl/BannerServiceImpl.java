package com.sims.ppob.services.impl;

import com.sims.ppob.models.dtos.banner.BannerResponseDto;
import com.sims.ppob.models.entity.Banner;
import com.sims.ppob.services.BannerService;
import com.sims.ppob.services.data.BannerDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {
  private final BannerDataService bannerDataService;

  @Override
  public List<BannerResponseDto> getAll() {
    Optional<List<Banner>> banners = bannerDataService.findAll();

    return banners.map(list -> list.stream()
            .map(banner -> BannerResponseDto.builder()
                .banner_name(banner.getTitle())
                .banner_image(banner.getImageUrl())
                .description(banner.getDescription())
                .build())
            .collect(Collectors.toList()))
        .orElseGet(List::of);
  }
}
