package com.sims.ppob.services.data;

import com.sims.ppob.models.entity.ServiceSims;

import java.util.List;
import java.util.Optional;

public interface ServiceSimsDataService {
  Optional<List<ServiceSims>> findAll();
}
