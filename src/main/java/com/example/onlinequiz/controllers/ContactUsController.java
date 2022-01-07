package com.example.onlinequiz.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/onlinequiz")
public class ContactUsController {

    @GetMapping("/contactus")
    public String getContactForm(){
        return "contactForm";
    }

    @PostMapping("/thankyou")
    public String getThankYou(){
        return "thankyou";
    }
}
