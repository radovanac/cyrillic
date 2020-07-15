package com.example.demo.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasicFarmDto {

  private Long id;
  private String name;

  public static BasicFarmDto of(Long id, String name) {
    return BasicFarmDto.builder()
        .id(id)
        .name(name)
        .build();
  }
}
