package com.codeup.blog.controllers;

import com.codeup.blog.Post.Post;
import com.codeup.blog.Post.PostRepository;
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


  @GetMapping("/")
  public String homeMessage(Model model){
    String message = "I'm Sarah. Get to know me!";
    model.addAttribute("homeMessage", message);
    return "posts/index";
  }

  @GetMapping("/posts")
  public String getAllPosts(Model model){
    Iterable<Post> posts = postDao.findAll();
    model.addAttribute("posts", posts);
    return "posts/posts";
  }


  @GetMapping("posts/{id}")
  public String getPost(@PathVariable long id, Model model){
    Post post = postDao.findOne(id);
    model.addAttribute("post", post);
    return "posts/show";
  }

  @PostMapping("posts/delete")
  public String deletePost(@RequestParam(name="id") long id){
     postDao.delete(id);
    System.out.println("We deleted post " + id);
    return "redirect:/posts";
  }


  @GetMapping("posts/edit/{id}")
  public String editForm(@PathVariable long id, Model model){
    Post post = postDao.findOne(id);
    model.addAttribute("post", post);
    return "posts/edit";
  }

  @PostMapping("posts/edit/{id}")
  public String sendEdit(@PathVariable long id,
              @RequestParam(name="title") String title,
              @RequestParam(name="body") String body){
        Post post = postDao.findOne(id);
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts/" + id;
  }


  @GetMapping("posts/create")
  public String createForm(){
    return "posts/create";
  }

  @PostMapping("posts/create")
  public String sendPost(@RequestParam(name="title") String title,
                         @RequestParam(name="body") String body){
    Post post = new Post(title, body);
    postDao.save(post);
    return "redirect:/posts";
  }



}
