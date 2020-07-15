package com.example.demo.service.account;

import com.example.demo.api.dto.AccountDto;
import com.example.demo.domain.Account;
import com.example.demo.domain.Customer;
import com.example.demo.domain.Farm;
import com.example.demo.domain.User;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.service.customer.CustomerService;
import com.example.demo.service.farm.FarmService;
import com.example.demo.service.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountFacadeImpl implements AccountFacade {

  private final AccountService accountService;
  private final UserService userService;
  private final FarmService farmService;
  private final CustomerService customerService;
  private final AccountMapper accountMapper;

  @Override
  public AccountDto create(AccountDto accountDto) {
    User user = userService.findOne(accountDto.getUser().getId());
    Farm farm = farmService.findOne(accountDto.getFarm().getId());
    Customer customer = customerService.findOne(accountDto.getCustomer().getId());
    Account account = accountService
        .create(accountDto.getUserName(), accountDto.getPassword(), farm, customer, user);
    return accountMapper.mapDto(account);
  }
}
