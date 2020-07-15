package com.example.demo.api;

import com.example.demo.api.dto.CustomerDto;
import com.example.demo.domain.Account;
import com.example.demo.service.customer.CustomerFacade;
import java.net.URI;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CustomerController {

  private final CustomerFacade customerFacade;

  @PostMapping
  public ResponseEntity<CustomerDto> create(String firstName, String lastName, Account account) {
    CustomerDto created = customerFacade.create(firstName, lastName, account);
    URI uri = URI.create("/customers/" + created.getId());
    return ResponseEntity.created(uri).body(created);
  }

  @GetMapping("/{customerId}")
  public ResponseEntity<CustomerDto> findOne(@PathVariable("customerId") Long customerId) {
    CustomerDto found = customerFacade.findOne(customerId);
    return ResponseEntity.ok(found);
  }

  @PutMapping("/{customerId}")
  public ResponseEntity<CustomerDto> update(@PathVariable("customerId") Long customerId,
      String firstName, String lastName, Account account) {
    CustomerDto updated = customerFacade.update(customerId, firstName, lastName, account);
    return ResponseEntity.ok(updated);
  }

  @DeleteMapping("/{customerId}")
  public ResponseEntity<Void> delete(@PathVariable("customerId") Long customerId) {
    customerFacade.delete(customerId);
    return ResponseEntity.noContent().build();
  }
}
