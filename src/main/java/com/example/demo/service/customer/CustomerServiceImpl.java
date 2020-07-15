package com.example.demo.service.customer;

import com.example.demo.domain.Account;
import com.example.demo.domain.Customer;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;

  @Override
  public Customer create(String firstName, String lastName, Account account) {
    Customer customer = Customer.of(firstName, lastName, account);
    return customerRepository.save(customer);
  }

  @Override
  public Customer update(Long id, String firstName, String lastName, Account account) {
    Customer customer = customerRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Customer not found"));
    customer.edit(firstName, lastName, account);
    return customerRepository.save(customer);
  }

  @Override
  public Customer findOne(Long id) {
    return customerRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Customer not found"));
  }

  @Override
  public void delete(Long id) {
    Customer customer = customerRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Customer not found"));
    customerRepository.delete(customer);
  }
}
