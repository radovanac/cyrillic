package com.example.demo.service.account;

import com.example.demo.domain.Account;
import com.example.demo.domain.Customer;
import com.example.demo.domain.Farm;
import com.example.demo.domain.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.AccountRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

  private final AccountRepository accountRepository;

  @Override
  public Account create(String userName, String password, Farm farm, Customer customer, User user) {
    Account account = Account.of(userName,password,farm,customer,user);
    return accountRepository.save(account);
  }

  @Override
  public List<Account> findAllByIds(List<Long> ids) {
    return ids
        .stream()
        .map(id -> accountRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Account not found")))
        .collect(Collectors.toList());
  }
}
