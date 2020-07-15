package com.example.demo.api.dto;

import com.example.demo.domain.Account;
import com.example.demo.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FarmDto {

  private Long id;
  private String name;

  public static FarmDto of(Long id, String name) {
    return FarmDto
        .builder()
        .id(id)
        .name(name)
        .build();
  }

  private static AccountDto convertAccount(Account account) {
    return AccountDto
        .of(account.getId(), account.getUserName(), account.getPassword(), account.getFarm(),
            account.getCustomer(), account.getUser());
  }

  private static UserDto convertUser(User user) {
    return UserDto.of(user.getId(), user.getFirstName(),user.getLastName(),user.getAccounts());
  }
}
