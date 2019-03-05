package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.repositories.PostRepository;
import com.codeup.blog.services.EmailService;
import com.codeup.blog.models.User;
import com.codeup.blog.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
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

  private final PostRepository postDao;

  @Value("${file-upload-path}")
  private String uploadPath;

  public PostController(PostRepository postDao){
    this.postDao = postDao;
  }

  @Autowired
  private EmailService emailService;

  @Autowired
  private UserRepository userRepo;


  @GetMapping("/")
  public String homeMessage(){
    return "posts/index";
  }

//  @GetMapping("/")
//  public String homeMessage(Model model){
//    String message = "I'm Sarah. Get to know me!";
//    model.addAttribute("homeMessage", message);
//    return "posts/index";
//  }

  @GetMapping("/resume")
  public String showResume(){
    return "posts/resume";
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
    model.addAttribute("user", post.getUser());
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
                         @RequestParam(name = "file") MultipartFile uploadedFile, Model model){

    Post post = postDao.findOne(id);

    User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User userDB = userRepo.findOne(sessionUser.getId());

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
    post.setUser(userDB);
    postDao.save(post);
    return "redirect:/posts/" + id;
  }

  @GetMapping("posts/cancel")
  public String actionCancel(){
    return "redirect:/posts";
  }


    @GetMapping("/posts/create")
  public String createForm(Model model){
    model.addAttribute("post", new Post());
    return "/posts/create";
  }

  @PostMapping("posts/create")
  public String sendPost(@Valid Post post, Errors validation, @RequestParam(name="file") MultipartFile uploadedFile, Model model){


    String filename = uploadedFile.getOriginalFilename();
    String filepath = Paths.get(uploadPath, filename).toString();
    File destinationFile = new File(filepath);

    User sessionUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    User userDB = userRepo.findOne(sessionUser.getId());


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
    post.setUser(userDB);
    postDao.save(post);

    emailService.prepareAndSend(post, "posts successfully created!", "You just posted a new blog entry. Go to your profile to view your whole collection. - Admin Team");

    return "redirect:/posts";
  }



}
