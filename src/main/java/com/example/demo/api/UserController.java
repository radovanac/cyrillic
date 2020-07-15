package com.example.demo.api;

import com.example.demo.api.dto.FarmOverviewDto;
import com.example.demo.api.dto.UserDto;
import com.example.demo.domain.Account;
import com.example.demo.domain.Farm;
import com.example.demo.service.user.UserFacade;
import java.net.URI;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

  private final UserFacade userFacade;

  @PostMapping
  public ResponseEntity<UserDto> create(@RequestBody UserDto userDto) {
    UserDto created = userFacade.create(userDto);
    URI uri = URI.create("/users/" + created.getId());
    return ResponseEntity.created(uri).body(created);
  }

  @GetMapping("/{userId}")
  public ResponseEntity<UserDto> findOne(@PathVariable("userId") Long userId) {
    UserDto found = userFacade.findOne(userId);
    return ResponseEntity.ok(found);
  }

  @PutMapping("/{userId}")
  public ResponseEntity<UserDto> update(@PathVariable("userId") Long userId,
      @RequestBody UserDto userDto) {
    UserDto updated = userFacade.update(userId, userDto);
    return ResponseEntity.ok(updated);
  }

  @DeleteMapping("/{userId}")
  public ResponseEntity<Void> delete(@PathVariable("userId") Long userId) {
    userFacade.delete(userId);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/{userId}/farmsOverview")
  public ResponseEntity<UserDto> farmOverview(@PathVariable("userId") Long userId) {
    UserDto result = userFacade.farmOverview(userId);
    return ResponseEntity.ok(result);
  }
}
