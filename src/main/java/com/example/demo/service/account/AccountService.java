package com.example.demo.service.account;

import com.example.demo.domain.Account;
import com.example.demo.domain.Customer;
import com.example.demo.domain.Farm;
import com.example.demo.domain.User;
import java.util.List;

public interface AccountService {

  Account create(String userName, String password, Farm farm, Customer customer, User user);

  List<Account> findAllByIds (List<Long> ids);
}
