//package com.codeup.blog.users;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="users")
//public class User {
//
//  @GeneratedValue
//  @Id
//  private long id;
//
//  @Column(nullable = false, length = 255, unique = true)
//  private String email;
//
//  @Column(nullable = false, length = 255, unique = true)
//  private String username;
//
//  @Column(nullable = false)
//  private String password;
//
//  public User(){}
//
//  public User(String username, String email, String password){
//    this.username = username;
//    this.email = email;
//    this.password = password;
//  }
//
//  public User(User copy) {
//    id = copy.id; // This line is SUPER important! Many things won't work if it's absent
//    email = copy.email;
//    username = copy.username;
//    password = copy.password;
//  }
//
//  public long getId() {
//    return id;
//  }
//
//  public void setId(long id) {
//    this.id = id;
//  }
//
//  public String getEmail() {
//    return email;
//  }
//
//  public void setEmail(String email) {
//    this.email = email;
//  }
//
//  public String getUsername() {
//    return username;
//  }
//
//  public void setUsername(String username) {
//    this.username = username;
//  }
//
//  public String getPassword() {
//    return password;
//  }
//
//  public void setPassword(String password) {
//    this.password = password;
//  }
//}
