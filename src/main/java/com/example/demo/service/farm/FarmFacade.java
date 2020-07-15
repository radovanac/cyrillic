package com.example.demo.service.farm;

import com.example.demo.api.dto.FarmDto;
import com.example.demo.domain.Account;
import com.example.demo.domain.User;

public interface FarmFacade {

  FarmDto create(String name);

  FarmDto update(Long farmId, String name, Account account, User user);

  FarmDto findOne(Long farmId);

  void delete(Long farmId);
}
