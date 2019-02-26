package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class HomeController {

  @GetMapping("/")
  public String hello(){
    return "index";
  }



}
