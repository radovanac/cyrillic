package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "farm")
@Getter
@Setter(AccessLevel.PRIVATE)
@ToString
public class Farm extends AbstractJpa {

  @NotNull
  @Column(name = "name")
  private String name;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "account_id")
  private Account account;

  public static Farm of(String name) {
    Farm farm = new Farm();
    farm.setName(name);
    return farm;
  }

  public void edit(String name) {
    this.setName(name);
  }

}
