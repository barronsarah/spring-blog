package com.codeup.blog.Post;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
  @GeneratedValue
  @Id
  private long id;

  @Column(nullable = false, length = 125)
  private String title;

  @Column(nullable = false, length = 1000)
  private String body;


  @Column(nullable = true, length = 1000)
  private String image;

  public Post(){ }

  public Post(long id, String title, String body) {
    this.id = id;
    this.title = title;
    this.body = body;
  }

  public Post(long id, String title, String body, String image) {
    this.id = id;
    this.title = title;
    this.body = body;
    this.image = image;
  }

  public Post(String title, String body) {
    this.title = title;
    this.body = body;
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
}
