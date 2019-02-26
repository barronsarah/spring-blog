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

//  @GetMapping("/dice/{guess}")
//  public String guess(@PathVariable Integer guess) {
//    return "dice";
//  }

  @GetMapping("/roll-dice/{n}")
  public String diceRoll(@PathVariable Integer n, Model model) {
    Random rand = new Random();
    Integer roll = rand.nextInt(7);
    String answer =  guessRight(n, roll);
    model.addAttribute("guess", n);
    model.addAttribute("dice", roll);
    model.addAttribute("right-wrong", answer);
    return "dice";
  }

  public String guessRight(Integer n, Integer roll){
    if(n != roll) {
      return "wrong";
    }
    return "right";
  }



}


