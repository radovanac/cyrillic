package com.example.demo.mapper;

import com.example.demo.api.dto.UserDto;
import com.example.demo.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapperImpl implements UserMapper {

  @Override
  public UserDto mapDto(User user) {
    return UserDto.of(user.getId(), user.getFirstName(), user.getLastName(), user.getAccounts());
  }
}
