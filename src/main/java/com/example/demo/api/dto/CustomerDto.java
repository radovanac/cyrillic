package com.example.demo.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerDto {

  private Long id;
  private String firstName;
  private String lastName;
  private AccountDto account;

  public static CustomerDto of(Long id,String firstName, String lastName) {
    return CustomerDto
        .builder()
        .id(id)
        .firstName(firstName)
        .lastName(lastName)
        .build();
  }
}
