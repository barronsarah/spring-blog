package com.codeup.blog.controllers;

import com.codeup.blog.Post.Post;
import com.codeup.blog.Post.PostRepository;
import com.codeup.blog.Post.PostsList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

  private final PostRepository postDao;

  public PostController(PostRepository postDao) {
    this.postDao = postDao;
  }


  @GetMapping("/posts")
  public String postsIndex(Model model){
//    List<Post> posts = new ArrayList<>();
//    posts.add(new Post(1,"Life Before Tech", "Hear about my journey that led me into tech!"));
//    posts.add((new Post(2, "A Student Again", "The experience of going to a Full Stack Bootcamp")));
//    model.addAttribute("posts", posts);
    return "posts/index";
  }

  @GetMapping("posts/{id}")
  public String getPostId(@PathVariable Integer id, Model model){
    Post post = new Post(id                                , "Hello World", "Here is a single post");
    model.addAttribute("post", post);

    return "posts/show";
  }

//  @GetMapping("/posts/{id}")
//  public String getPostId(@PathVariable Integer id, Model model){
//    Quote quote = QuotesList.findOne(id);  <--need to create a function that gets that one post
//    model.addAttribute("quote", quote);
//    return "posts/show";
//  }



  @GetMapping("posts/create")
  public String createPost(){
    return "posts/create";
  }

  @PostMapping("posts/create")
  @ResponseBody
  public String sendPost(){
    return "Post is created!";
  }

}
