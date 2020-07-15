package com.example.demo.api.dto;

import com.example.demo.domain.Account;
import com.example.demo.domain.Farm;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter(AccessLevel.MODULE)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class UserDto {

  private Long id;
  private String firstName;
  private String lastName;
  private List<BasicAccountDto> accounts;

  public static UserDto of(Long id, String firstName, String lastName, List<Account> accounts) {
    return UserDto
        .builder()
        .id(id)
        .firstName(firstName)
        .lastName(lastName)
        .accounts(convertAccounts(accounts))
        .build();
  }

  private static List<BasicAccountDto> convertAccounts(List<Account> accounts) {
    return accounts
        .stream()
        .map(account ->
            BasicAccountDto.of(account.getId(), account.getUserName(), account.getPassword(),
                convertFarm(account.getFarm())))
        .collect(Collectors.toList());
  }

  private static BasicFarmDto convertFarm(Farm farm) {
    if (Objects.nonNull(farm)) {
      return BasicFarmDto.of(farm.getId(), farm.getName());
    }
    return null;
  }
}
