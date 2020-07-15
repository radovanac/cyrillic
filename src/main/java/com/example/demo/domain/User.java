package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class User extends AbstractJpa {

  @NotNull
  @Column(name = "first_name")
  private String firstName;

  @NotNull
  @Column(name = "last_name")
  private String lastName;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Account> accounts = new ArrayList<>(0);

  public static User of(@NotNull String firstName, @NotNull String lastName, List<Account> accounts) {
    User user = new User();
    user.setFirstName(firstName);
    user.setLastName(lastName);
    accounts.forEach(user::addAccount);
    return user;
  }

  public void edit(@NotNull String firstName, @NotNull String lastName, List<Account> accounts) {
    this.setFirstName(firstName);
    this.setLastName(lastName);
    this.getAccounts().clear();
    accounts.forEach(this::addAccount);
  }

  public void addAccount(Account account) {
    accounts.add(account);
    account.updateUser(this);
  }

  public void removeAccount(Account account) {
    accounts.remove(account);
    account.updateUser(null);
  }
}
