package com.codeup.blog.controllers;

import com.codeup.blog.posts.Post;
import com.codeup.blog.posts.PostRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Controller
public class PostController {

  @Value("${file-upload-path}")
  private String uploadPath;

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
                          @RequestParam(name="body") String body,
                          @RequestParam(name = "file") MultipartFile uploadedFile,
                          Model model){

        Post post = postDao.findOne(id);

    String filename = uploadedFile.getOriginalFilename();
    String filepath = Paths.get(uploadPath, filename).toString();
    File destinationFile = new File(filepath);

    try {
      uploadedFile.transferTo(destinationFile);
      model.addAttribute("message", "File successfully uploaded!");
    } catch (IOException e) {
      e.printStackTrace();
      model.addAttribute("message", "Oops! Something went wrong! " + e);
    }

        post.setImage(filename);
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts/" + id;
  }



    @GetMapping("/posts/create")
  public String createForm(Model model){
    model.addAttribute("post", new Post());
    return "/posts/create";
  }

  @PostMapping("posts/create")
  public String sendPost(@Valid Post post, Errors validation,
                         @RequestParam(name="file") MultipartFile uploadedFile,
                         Model model ){
//    posts post = new posts(title, body);

    String filename = uploadedFile.getOriginalFilename();
    String filepath = Paths.get(uploadPath, filename).toString();
    File destinationFile = new File(filepath);

    try {
      uploadedFile.transferTo(destinationFile);
      model.addAttribute("message", "File successfully uploaded!");
    } catch (IOException e) {
      e.printStackTrace();
      model.addAttribute("message", "Oops! Something went wrong! " + e);

    }
    if(validation.hasErrors()) {
      model.addAttribute("errors", validation);
      model.addAttribute("post", post);
      return "posts/create";
    }
    post.setImage(filename);
    postDao.save(post);
    return "redirect:/posts";

  }



}
