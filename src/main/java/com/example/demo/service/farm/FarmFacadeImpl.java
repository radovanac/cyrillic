package com.example.demo.service.farm;

import com.example.demo.api.dto.FarmDto;
import com.example.demo.domain.Account;
import com.example.demo.domain.Farm;
import com.example.demo.domain.User;
import com.example.demo.mapper.FarmMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class FarmFacadeImpl implements FarmFacade {

  private final FarmService farmService;
  private final FarmMapper farmMapper;

  @Override
  public FarmDto create(String name) {
    Farm farm = farmService.create(name);
    return farmMapper.mapDto(farm);
  }

  @Override
  public FarmDto update(Long farmId, String name, Account account, User user) {
    Farm farm = farmService.update(farmId,name,account,user);
    return farmMapper.mapDto(farm);
  }

  @Override
  public FarmDto findOne(Long farmId) {
    Farm farm = farmService.findOne(farmId);
    return farmMapper.mapDto(farm);
  }

  @Override
  public void delete(Long farmId) {
    Farm farm = farmService.findOne(farmId);
    farmService.delete(farm.getId());
  }
}
