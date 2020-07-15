package com.example.demo.api;

import com.example.demo.api.dto.FarmDto;
import com.example.demo.domain.Account;
import com.example.demo.domain.User;
import com.example.demo.service.farm.FarmFacade;
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
@RequestMapping("/farms")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class FarmController {

  private final FarmFacade farmFacade;

  @PostMapping
  public ResponseEntity<FarmDto> createFarm(String name) {
    FarmDto created = farmFacade.create(name);
    URI uri = URI.create("/farms/" + created.getId());
    return ResponseEntity.created(uri).body(created);
  }

  @GetMapping("/{farmId}")
  public ResponseEntity<FarmDto> findOne(@PathVariable("farmId") Long farmId) {
    FarmDto found = farmFacade.findOne(farmId);
    return ResponseEntity.ok(found);
  }

  @PutMapping("/{farmId}")
  public ResponseEntity<FarmDto> update(@PathVariable("farmId") Long farmId,
      String name, Account account, User user) {
    FarmDto updated = farmFacade.update(farmId, name, account, user);
    return ResponseEntity.ok(updated);
  }

  @DeleteMapping("/{farmId}")
  public ResponseEntity<Void> delete(@PathVariable("farmId") Long farmId) {
    farmFacade.delete(farmId);
    return ResponseEntity.noContent().build();
  }
}
