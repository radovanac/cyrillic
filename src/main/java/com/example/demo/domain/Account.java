package com.example.demo.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "account")
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class Account extends AbstractJpa {

  @NotNull
  @Column(name = "username")
  private String userName;

  @NotNull
  @Column(name = "password")
  private String password;

  @OneToOne(mappedBy = "account", cascade = CascadeType.ALL,
      fetch = FetchType.LAZY, optional = false)
  private Farm farm;

  @OneToOne(mappedBy = "account", cascade = CascadeType.ALL,
      fetch = FetchType.LAZY, optional = false)
  private Customer customer;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  public static Account of(@NotNull String userName, @NotNull String password, Farm farm, Customer customer, User user) {
    Account account = new Account();
    account.setUserName(userName);
    account.setPassword(password);
    account.setFarm(farm);
    account.setUser(user);
    account.setCustomer(customer);
    return account;
  }

  public void updateUser(User user) {
    this.setUser(user);
  }
}
