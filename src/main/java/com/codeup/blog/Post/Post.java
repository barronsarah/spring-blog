package com.codeup.blog.Post;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
  @GeneratedValue
  private Integer id;
  @Column(nullable = false, length = 125)
  private String title;
  @Column(nullable = false, length = 225)
  private String body;

  public Post(Integer id, String title, String body) {
    this.id = id;
    this.title = title;
    this.body = body;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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
}
