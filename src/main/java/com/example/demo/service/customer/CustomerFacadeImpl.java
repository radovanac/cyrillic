package com.example.demo.service.customer;

import com.example.demo.api.dto.CustomerDto;
import com.example.demo.domain.Account;
import com.example.demo.domain.Customer;
import com.example.demo.mapper.CustomerMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CustomerFacadeImpl implements CustomerFacade {

  private final CustomerService customerService;
  private final CustomerMapper customerMapper;

  @Override
  public CustomerDto create(String firstName, String lastName, Account account) {
    Customer customer = customerService.create(firstName, lastName, account);
    return customerMapper.mapDto(customer);
  }

  @Override
  public CustomerDto update(Long id, String firstName, String lastName, Account account) {
    Customer customer = customerService.update(id, firstName, lastName, account);
    return customerMapper.mapDto(customer);
  }

  @Override
  public CustomerDto findOne(Long id) {
    Customer customer = customerService.findOne(id);
    return customerMapper.mapDto(customer);
  }

  @Override
  public void delete(Long id) {
    customerService.delete(id);
  }
}
