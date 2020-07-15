package com.example.demo.api.dto;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Farm;
import com.example.demo.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Setter(AccessLevel.PRIVATE)
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

  private Long id;
  private String userName;
  private String password;
  private FarmDto farm;
  private CustomerDto customer;
  private UserDto user;

  public static AccountDto of(Long id, String userName, String password, Farm farm,
      Customer customer, User user) {
    return AccountDto
        .builder()
        .id(id)
        .userName(userName)
        .password(password)
        .farm(convertFarm(farm))
        .customer(convertCustomer(customer))
        .user(convertUser(user))
        .build();
  }

  private static FarmDto convertFarm(Farm farm) {
    return FarmDto.of(farm.getId(), farm.getName());
  }

  private static UserDto convertUser(User user) {
    return UserDto.of(user.getId(), user.getFirstName(), user.getLastName(), user.getAccounts());
  }

  private static CustomerDto convertCustomer(Customer customer) {
    return CustomerDto.of(customer.getId(), customer.getFirstName(), customer.getLastName());
  }
}
