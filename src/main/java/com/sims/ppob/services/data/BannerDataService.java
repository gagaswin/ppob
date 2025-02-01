package com.sims.ppob.services.data;

import com.sims.ppob.models.entity.Banner;

import java.util.List;
import java.util.Optional;

public interface BannerDataService {
  Optional<List<Banner>> findAll();
}
