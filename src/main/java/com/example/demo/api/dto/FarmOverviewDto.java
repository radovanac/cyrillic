package com.example.demo.api.dto;

import com.example.demo.domain.Account;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FarmOverviewDto {

  private Long id;
  private String name;

  public static FarmOverviewDto of(Long id, String name) {
    return FarmOverviewDto
        .builder()
        .id(id)
        .name(name)
        .build();
  }
}
