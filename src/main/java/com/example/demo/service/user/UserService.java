package com.example.demo.service.user;

import com.example.demo.api.dto.FarmOverviewDto;
import com.example.demo.api.dto.UserDto;
import com.example.demo.domain.Account;
import com.example.demo.domain.User;
import java.util.List;

public interface UserService {

  User create(String firstName, String lastName, List<Account> accounts);

  User findOne(Long userId) ;

  User update(Long userId, String firstName, String lastName, List<Account> accounts);

  void delete(Long userId);

  User findAllFetchAccountById(Long id);
}
