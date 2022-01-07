package com.example.onlinequiz.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String getHomePage(){
        return "redirect:"+"/onlinequiz";
    }

    @GetMapping("/onlinequiz")
    public String getIndexView(){
        return "index";
    }


}
