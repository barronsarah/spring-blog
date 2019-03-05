package com.codeup.blog.models;

import com.codeup.blog.models.User;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {

  @ManyToOne @JoinColumn (name = "user_id")
  private User user;

  @GeneratedValue
  @Id
  private long id;

  @Column(nullable = false, length = 125)
  @NotBlank(message = "Please enter a title")
  private String title;

  @Column(nullable = false, length = 1000)
  @NotBlank(message = "Can not post with no text!")
  private String body;

  @Column(nullable = true, length = 1000)
  private String image;


  public Post(){ }

  public Post(long id, String title, String body, String image, User user) {
    this.id = id;
    this.title = title;
    this.body = body;
    this.image = image;
    this.user= user;
  }

  public Post(String title, String body, String image, User user) {
    this.title = title;
    this.body = body;
    this.image = image;
    this.user = user;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public User getUser() {
    return user;
  }
  public void setUser(User user) {
    this.user = user;
  }
}
