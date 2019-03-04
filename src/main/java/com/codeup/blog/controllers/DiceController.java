package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Random;

@Controller
public class DiceController {

  @GetMapping("/dice")
  public String welcome() {
    return "dice";
  }


  @GetMapping("/roll-dice/{n}")
  public String diceRoll(@PathVariable Integer n, Model model) {
    Random rand = new Random();
    Integer roll = rand.nextInt(7);
    Boolean rightAnswer = (n == roll);
    model.addAttribute("guess", n);
    model.addAttribute("dice", roll);
    model.addAttribute("right-answer", rightAnswer);
    return "dice";
  }




}


