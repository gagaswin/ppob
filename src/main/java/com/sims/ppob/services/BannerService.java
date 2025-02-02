package com.sims.ppob.services;

import com.sims.ppob.models.dtos.banner.BannerResponseDto;

import java.util.List;

public interface BannerService {
  List<BannerResponseDto> getAll();
}
