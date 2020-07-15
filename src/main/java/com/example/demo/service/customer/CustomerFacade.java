package com.example.demo.service.customer;

import com.example.demo.api.dto.CustomerDto;
import com.example.demo.domain.Account;

public interface CustomerFacade {

  CustomerDto create(String firstName, String lastName, Account account);

  CustomerDto update(Long id, String firstName, String lastName, Account account);

  CustomerDto findOne(Long id);

  void delete(Long id);
}
