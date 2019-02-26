package com.codeup.blog.Post;

public class Post {
  private Integer id;
  private String title;
  private String textBody;

  public Post(Integer id, String title, String textBody) {
    this.id = id;
    this.title = title;
    this.textBody = textBody;
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

  public String getTextBody() {
    return textBody;
  }

  public void setTextBody(String textBody) {
    this.textBody = textBody;
  }
}
