package com.example.onlinequiz.controllers;

import com.example.onlinequiz.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/onlinequiz")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/feedback")
    public String getFeedback(Model model, HttpServletRequest req){
        HttpSession oldSession = req.getSession(true);
        System.out.println("Current user from /user:" + oldSession.getAttribute("userNameSess"));
        if (oldSession == null) {
            model.addAttribute("errorMsg", "No Authorization! Please log in");
            return "loginForm";
        } else if (oldSession.getAttribute("userNameSess") == null) {
            model.addAttribute("errorMsg", "No Authorization! Please log in");
            return "loginForm";
        } else {
            model.addAttribute("user",oldSession.getAttribute("userNameSess"));
            model.addAttribute("quizTopics",oldSession.getAttribute("quizTopics"));
            return "feedbackForm";
        }
    }

    @PostMapping("/feedback")
    public String getFeedbackSubmit(@RequestParam (name = "topicId") Long topicId,
                                    @RequestParam (name = "rating1") Integer rating,
                                    @RequestParam (name = "comment") String comment){
        feedbackService.insertNewFeedback(topicId, rating, comment);
        return "thankyou";
    }
}
