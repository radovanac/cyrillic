package com.example.demo.serviceTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import com.example.demo.domain.Farm;
import com.example.demo.repository.FarmRepository;
import com.example.demo.service.farm.FarmService;
import com.example.demo.service.farm.FarmServiceImpl;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FarmServiceTest {

  private FarmService farmService;
  private FarmRepository farmRepository;

  @BeforeEach
  void setUp() {
    this.farmRepository = mock(FarmRepository.class);
    this.farmService = new FarmServiceImpl(farmRepository);
  }

  @Test
  void create() {
    Farm farm = Farm.of("farm");

    when(farmRepository.save(any())).thenReturn(farm);

    Farm result = farmService.create("farm");

    assertEquals("farm", result.getName());

    verify(farmRepository, times(1)).save(any());
    verifyNoMoreInteractions(farmRepository);
  }

  @Test
  void findOne() {
    Farm farm = Farm.of("farm");
    farm.setId(1L);
    when(farmRepository.findById(anyLong())).thenReturn(Optional.of(farm));

    Farm result = farmService.findOne(1L);

    assertEquals(1L, result.getId());

    verify(farmRepository, times(1)).findById(anyLong());
    verifyNoMoreInteractions(farmRepository);
  }

  @Test
  void delete() {
    Farm farm = Farm.of("farm");

    when(farmRepository.findById(anyLong())).thenReturn(Optional.of(farm));

    farmService.delete(1L);

    verify(farmRepository, times(1)).findById(any());
    verify(farmRepository, times(1)).delete(any());
    verifyNoMoreInteractions(farmRepository);
  }
}
