package com.sims.ppob.services.data.impl;

import com.sims.ppob.models.entity.Banner;
import com.sims.ppob.repository.BannerRepository;
import com.sims.ppob.services.data.BannerDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BannerDataServiceImpl implements BannerDataService {
  private final BannerRepository bannerRepository;

  @Override
  public List<Banner> findAll() {
    return this.bannerRepository.findAll();
  }
}
