package com.codeup.blog.controllers;

import com.codeup.blog.Post.Post;
import com.codeup.blog.Post.PostsList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

  @GetMapping("/posts")
  public String postsIndex(Model model){
    List<Post> posts = PostsList.all();
    model.addAttribute("posts", posts);
    return "posts/index";
  }

  @GetMapping("posts/{id}")
  @ResponseBody
  public String getPostId(@PathVariable Integer id){
    return "Here is the post for " + id;
  }

//  @GetMapping("/posts/{id}")
//  public String getPostId(@PathVariable Integer id, Model model){
//    Quote quote = QuotesList.findOne(id);  <--need to create a function that gets that one post
//    model.addAttribute("quote", quote);
//    return "posts/show";
//  }



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
