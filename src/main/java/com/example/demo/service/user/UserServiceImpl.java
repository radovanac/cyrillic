package com.example.demo.service.user;

import com.example.demo.domain.Account;
import com.example.demo.domain.User;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  @Transactional
  public User create(String firstName, String lastName, List<Account> accounts) {
    User user = User.of(firstName,lastName,accounts);
    return userRepository.save(user);
  }

  @Override
  public User findOne(Long userId) {
    return userRepository.findOneByIdFetchFarms(userId)
        .orElseThrow(() -> new NotFoundException("User not found"));
  }

  @Override
  @Transactional
  public User update(Long userId, String firstName, String lastName, List<Account> accounts) {
    User found = userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException("User not found"));
    found.edit(firstName, lastName, accounts);
    return userRepository.save(found);
  }

  @Override
  @Transactional
  public void delete(Long userId) {
    User user = userRepository.findById(userId)
        .orElseThrow(() -> new NotFoundException("User not found"));
    userRepository.delete(user);
  }

  @Override
  public User findAllFetchAccountById(Long id) {
    return userRepository.findOneByIdFetchFarms(id)
        .orElseThrow(() -> new NotFoundException("User not found"));
  }
}
