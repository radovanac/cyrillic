package com.example.demo.mapper;

import com.example.demo.api.dto.FarmDto;
import com.example.demo.domain.Farm;
import org.springframework.stereotype.Component;

@Component
public class FarmMapperImpl implements FarmMapper {

  @Override
  public FarmDto mapDto(Farm farm) {
    return FarmDto.of(farm.getId(), farm.getName());
  }
}
