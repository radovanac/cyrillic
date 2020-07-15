package com.example.demo.service.user;

import com.example.demo.api.dto.FarmOverviewDto;
import com.example.demo.api.dto.UserDto;
import java.util.List;

public interface UserFacade {

  UserDto create(UserDto userDto);

  UserDto findOne(Long userId);

  UserDto update(Long userId, UserDto userDto);

  void delete(Long userId);

  UserDto farmOverview(Long id);
}
