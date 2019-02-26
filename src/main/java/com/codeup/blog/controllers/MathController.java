//package com.codeup.blog.controllers;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class MathController {
//
//  @GetMapping("/add/{num1}/and/{num2}")
//  @ResponseBody
//  public String add(@PathVariable Integer num1, @PathVariable Integer num2){
//    Integer sum = num1 + num2;
//    return "The sum of " + num1 + " and " + num2 + " is: " + sum;
//  }
//
//// walkthrough- parsing the int to a string - may be possible to chang return type as Int to display sum in html
////  @GetMapping("/add/{num1}/and/{num2}")
////  @ResponseBody
////  public String add(@PathVariable Integer num1, @PathVariable Integer num2){
////    Integer sum = num1 + num2;
////    return String.valueOf(sum);
////  }
//
//  @GetMapping("/subtract/{num1}/from/{num2}")
//  @ResponseBody
//  public String subtract(@PathVariable Integer num1, @PathVariable Integer num2){
//    Integer answer = num2 - num1;
//    return "If you subtract " + num1 + " from " + num2 + " you get: " + answer;
//  }
//
//  @GetMapping("/multiply/{num1}/and/{num2}")
//  @ResponseBody
//  public String multiply(@PathVariable Integer num1, @PathVariable Integer num2){
//    Integer answer = num2 * num1;
//    return "If you multiply " + num1 + " by " + num2 + " you get: " + answer;
//  }
//
//  @GetMapping("/divide/{num1}/by/{num2}")
//  @ResponseBody
//  public String divide(@PathVariable Integer num1, @PathVariable Integer num2){
//    Integer answer = num1/num2;
//    return "If you divide " + num1 + " by " + num2 + " you get: " + answer;
//  }
//
////  WALKTHROUGH TO DISPLAY DECIMAL PLACES
//  @GetMapping("/divide/{num1}/by/{num2}")
//  @ResponseBody
//  public double divide(@PathVariable double num1, @PathVariable double num2){
//    return (num1/num2);
//  }
//
//}
