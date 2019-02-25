package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
class HomeController {

  @GetMapping("/")
  @ResponseBody
  public String hello(){
    return "This is the landing page!";
  }

//  @GetMapping("/hello")
//  @ResponseBody
//  public String hello(){
//    return "Hello from Spring";
//  }

//  @GetMapping("/{name}")
//  @ResponseBody
//  public String hello(@PathVariable String name){
//    return "This is the landing page, " + name +"!";
//  }
//
//  @PostMapping("/hello")
//  @ResponseBody
//  public String getPassword(@RequestParam(name = "password") String password){
//    return "1234" + password + "ituqyzlka";
//  }
//
//  @GetMapping("/test.json")
//  @ResponseBody
//  public List<String> getList(){
//    List<String> names = new ArrayList<>();
//    names.add("Sarah");
//    names.add("Dorian");
//    names.add("Justin");
//    return names;
//  }

  @Controller
  public static class MathController {

  //@PostMapping("")

  }
}
