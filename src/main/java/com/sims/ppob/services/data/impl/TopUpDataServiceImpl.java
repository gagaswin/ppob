package com.sims.ppob.services.data.impl;

import com.sims.ppob.models.entity.TopUp;
import com.sims.ppob.repository.TopUpRepository;
import com.sims.ppob.services.data.TopUpDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopUpDataServiceImpl implements TopUpDataService {
  private final TopUpRepository topUpRepository;

  @Override
  public void save(TopUp topUp) {
    this.topUpRepository.save(topUp);
  }
}
