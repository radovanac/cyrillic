package com.example.demo.mapper;

import com.example.demo.api.dto.AccountDto;
import com.example.demo.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapperImpl implements AccountMapper {

  @Override
  public AccountDto mapDto(Account account) {
    return AccountDto
        .of(account.getId(), account.getUserName(), account.getPassword(), account.getFarm(),
            account.getCustomer(), account.getUser());
  }
}
