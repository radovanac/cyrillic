package com.example.demo.controllerTests;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.example.demo.api.FarmController;
import com.example.demo.api.dto.FarmDto;
import com.example.demo.domain.Account;
import com.example.demo.service.farm.FarmFacade;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class FarmControllerTest {

  private FarmController farmController;
  private ObjectMapper objectMapper;
  private FarmFacade farmFacade;
  private MockMvc mockMvc;

  @BeforeEach
  void setUp() {
    this.farmFacade = mock(FarmFacade.class);
    this.objectMapper = new ObjectMapper();
    this.farmController = new FarmController(farmFacade);
    this.mockMvc = MockMvcBuilders.standaloneSetup(farmController).build();
  }

  @Test
  void create() throws Exception {
    String name = "farm";

    FarmDto farmDto = FarmDto.builder()
        .id(1L)
        .name(name)
        .build();

    when(farmFacade.create(anyString())).thenReturn(farmDto);

    mockMvc.perform(post("/farms")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(farmDto)))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id").value(1L));
  }
}
