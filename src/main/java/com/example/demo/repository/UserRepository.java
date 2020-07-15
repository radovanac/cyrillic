package com.example.demo.repository;

import com.example.demo.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @Query("select u from User u join fetch u.accounts a join fetch a.farm f where u.id=:id")
  Optional<User> findOneByIdFetchFarms(Long id);
}
