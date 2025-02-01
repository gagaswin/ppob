package com.sims.ppob.services.data.impl;

import com.sims.ppob.models.entity.Banner;
import com.sims.ppob.repository.BannerRepository;
import com.sims.ppob.services.data.BannerDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BannerDataServiceImpl implements BannerDataService {
  private final BannerRepository bannerRepository;

  @Override
  public Optional<List<Banner>> findAll() {
    List<Banner> banners = this.bannerRepository.findAll();
    return banners.isEmpty() ? Optional.empty() : Optional.of(banners);
  }
}
