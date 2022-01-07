package com.example.onlinequiz.controllers;

import com.example.onlinequiz.entity.Submission;
import com.example.onlinequiz.services.LoginService;
import com.example.onlinequiz.services.QuizService;
import com.example.onlinequiz.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

@Controller
@RequestMapping("/onlinequiz")
@SessionAttributes({"userNameSess","userPasswordSess"})
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private QuizService quizService;

    @Autowired
    private ResultService resultService;

    @GetMapping("/login")
    public String getLoginForm(){
        return "loginForm";
    }

    @PostMapping("/login")
    public String processLogin(Model model, HttpServletRequest req, @RequestParam String userName, @RequestParam String userPassword){
        if (userName != null && userPassword != null && loginService.validateLogin(userName, userPassword)){
            HttpSession oldSession = req.getSession(false);
            if (oldSession != null){
                oldSession.invalidate();
            }

            HttpSession newSession = req.getSession(true);
            newSession.setAttribute("userNameSess", userName);
            //newSession.setAttribute("userPasswordSess", userPassword);

            model.addAttribute("userName", userName);
            model.addAttribute("userPassword", userPassword);

            // setting session to expire in 10 minutes
            newSession.setMaxInactiveInterval(10*60);
            return "redirect:/onlinequiz/user";
        } else {
            model.addAttribute("errorMsg", "Wrong user name or password!");
            return "loginForm";
        }
    }

    @GetMapping("/user")
    public String profile(HttpServletRequest req,Model model){
        HttpSession oldSession = req.getSession(true);
        System.out.println("Current user from /user:" + oldSession.getAttribute("userNameSess"));
        oldSession.setAttribute("quizTopics", quizService.getAllQuizTopic());
        if (oldSession == null) {
            model.addAttribute("errorMsg", "No Authorization! Please log in");
            return "loginForm";
        } else if (oldSession.getAttribute("userNameSess") == null) {
            model.addAttribute("errorMsg", "No Authorization! Please log in");
            return "loginForm";
        } else {
            String userName = oldSession.getAttribute("userNameSess").toString();
            Long userId = loginService.getUserByUserName(userName).getId();
            List<Submission> submissionList = resultService.getSubmissionByUserId(userId);
            model.addAttribute("historySubmission", submissionList);
            model.addAttribute("user",oldSession.getAttribute("userNameSess"));
            model.addAttribute("quizTopics",oldSession.getAttribute("quizTopics"));
            return "userHome";
        }
    }


}
