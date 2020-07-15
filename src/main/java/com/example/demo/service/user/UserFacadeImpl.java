package com.example.demo.service.user;

import com.example.demo.api.dto.AccountDto;
import com.example.demo.api.dto.BasicAccountDto;
import com.example.demo.api.dto.FarmOverviewDto;
import com.example.demo.api.dto.UserDto;
import com.example.demo.domain.Account;
import com.example.demo.domain.Farm;
import com.example.demo.domain.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.account.AccountService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {

  private final UserService userService;
  private final AccountService accountService;
  private final UserMapper userMapper;

  @Override
  public UserDto create(UserDto userDto) {
    List<Account> accounts = accountService.findAllByIds(userDto.getAccounts()
        .stream()
        .map(BasicAccountDto::getId)
        .collect(Collectors.toList()));
    User user = userService.create(userDto.getFirstName(), userDto.getLastName(), accounts);
    return userMapper.mapDto(user);
  }

  @Override
  public UserDto findOne(Long userId) {
    User user = userService.findOne(userId);
    return userMapper.mapDto(user);
  }

  @Override
  public UserDto update(Long id, UserDto userDto) {
    List<Account> accounts = accountService.findAllByIds(userDto.getAccounts()
        .stream()
        .map(BasicAccountDto::getId)
        .collect(Collectors.toList()));
    User user = userService
        .update(id, userDto.getFirstName(), userDto.getLastName(), accounts);
    return userMapper.mapDto(user);
  }

  @Override
  public void delete(Long userId) {
    User user = userService.findOne(userId);
    userService.delete(user.getId());
  }

  @Override
  @Transactional
  public UserDto farmOverview(Long id) {
    User user = userService.findAllFetchAccountById(id);
    return userMapper.mapDto(user);
  }
}
