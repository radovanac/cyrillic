package com.example.demo.api.dto;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasicAccountDto {

  private Long id;
  private String userName;
  private String password;
  private BasicFarmDto farm;

  public static BasicAccountDto of(Long id, String userName, String password, BasicFarmDto farm) {
    return BasicAccountDto
        .builder()
        .id(id)
        .userName(userName)
        .password(password)
        .farm(farm)
        .build();
  }
}
