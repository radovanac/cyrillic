package com.example.demo.api;

import com.example.demo.api.dto.AccountDto;
import com.example.demo.api.dto.CustomerDto;
import com.example.demo.domain.Account;
import com.example.demo.service.account.AccountFacade;
import java.net.URI;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class AccountController {

  private final AccountFacade accountFacade;

  @PostMapping
  public ResponseEntity<AccountDto> create(@RequestBody AccountDto accountDto) {
    AccountDto created = accountFacade.create(accountDto);
    URI uri = URI.create("/accounts/" + created.getId());
    return ResponseEntity.created(uri).body(created);
  }
}
