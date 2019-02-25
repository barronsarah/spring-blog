package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Controller
public class PostController {

  @GetMapping("/posts")
  @ResponseBody
  public String postsIndex(){
    return "Here are all the posts.";
  }

  @GetMapping("posts/{id}")
  @ResponseBody
  public String getPostId(@PathVariable Integer id){
    return "Here is the post for " + id;
  }

  @GetMapping("posts/create")
  @ResponseBody
  public String createPost(){
    return "Here is the page to create a post";
  }

  @PostMapping("posts/create")
  @ResponseBody
  public String sendPost(){
    return "Post is created!";
  }

}
