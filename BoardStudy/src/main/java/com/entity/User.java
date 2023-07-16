package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "user_table")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long seq;
  private String id;
  private String name;
  private String password;

  public User() {

  }

  public User(String id, String name, String password) {
    super();
    this.id = id;
    this.name = name;
    this.password = password;
  }

  public Long getSeq() {
    return seq;
  }

  public void setSeq(Long seq) {
    this.seq = seq;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
