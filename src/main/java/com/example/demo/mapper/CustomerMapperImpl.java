package com.example.demo.mapper;

import com.example.demo.api.dto.CustomerDto;
import com.example.demo.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements CustomerMapper {

  @Override
  public CustomerDto mapDto(Customer customer) {
    return CustomerDto.of(customer.getId(), customer.getFirstName(), customer.getLastName());
  }
}
