package com.example.demo.service.customer;

import com.example.demo.domain.Account;
import com.example.demo.domain.Customer;

public interface CustomerService {

  Customer create(String firstName, String lastName, Account account);

  Customer update(Long id, String firstName, String lastName, Account account);

  Customer findOne(Long id);

  void delete(Long id);
}
