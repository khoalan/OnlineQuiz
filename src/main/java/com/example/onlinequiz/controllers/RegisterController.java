package com.example.onlinequiz.controllers;

import com.example.onlinequiz.entity.User;
import com.example.onlinequiz.repository.UserRepository;
import com.example.onlinequiz.services.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/onlinequiz")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("/register")
    public String getRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "signupForm";
    }

    @PostMapping("/process_register")
    public String processRegister(User user, Model model){
        if (!registerService.validUserName(user.getUserName())) {
            model.addAttribute("errorMsgName", "Invalid user name!");
            return "signupForm";
        } else if (!registerService.validEmail(user.getEmail())) {
            model.addAttribute("errorMsgEmail", "Invalid email!");
            return "signupForm";
        } else{
            registerService.saveNewUser(user);
            return "signupDone";
        }
    }
}
