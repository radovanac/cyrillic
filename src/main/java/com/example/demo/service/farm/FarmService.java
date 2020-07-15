package com.example.demo.service.farm;

import com.example.demo.domain.Account;
import com.example.demo.domain.Farm;
import com.example.demo.domain.User;

public interface FarmService {

  Farm create(String name);

  Farm update(Long farmId,String name, Account account, User user);

  Farm findOne(Long farmId);

  void delete(Long farmId) ;
}
