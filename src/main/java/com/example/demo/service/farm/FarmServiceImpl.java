package com.example.demo.service.farm;

import com.example.demo.domain.Account;
import com.example.demo.domain.Farm;
import com.example.demo.domain.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.FarmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FarmServiceImpl implements FarmService {

  private final FarmRepository farmRepository;

  @Override
  public Farm create(String name) {
    Farm farm = Farm.of(name);
    return farmRepository.save(farm);
  }

  @Override
  public Farm update(Long farmId, String name, Account account, User user) {
    Farm farm = farmRepository.findById(farmId)
        .orElseThrow(() -> new NotFoundException("Farm not found"));
    farm.edit(name);
    return farmRepository.save(farm);
  }

  @Override
  public Farm findOne(Long farmId) {
    return farmRepository.findById(farmId)
        .orElseThrow(() -> new NotFoundException("Farm not found"));
  }

  @Override
  public void delete(Long farmId) {
    Farm farm = farmRepository.findById(farmId)
        .orElseThrow(() -> new NotFoundException("Farm not found"));
    farmRepository.delete(farm);
  }
}
