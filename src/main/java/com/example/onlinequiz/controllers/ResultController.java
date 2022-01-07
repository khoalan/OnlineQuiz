package com.example.onlinequiz.controllers;

import com.example.onlinequiz.entity.*;
import com.example.onlinequiz.services.LoginService;
import com.example.onlinequiz.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/onlinequiz")
@SessionAttributes({"questionList","choiceList","resultList"})
public class ResultController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private ResultService resultService;

    @GetMapping("/result")
    public String getResult(HttpServletRequest req, Model model){
        HttpSession oldSession = req.getSession(true);
        List<Result> resultList = (List<Result>) oldSession.getAttribute("resultListSess");
        List<Question> questionList = (List<Question>) oldSession.getAttribute("questionListSess");
        List<Choice> choiceList = (List<Choice>) oldSession.getAttribute("choiceListSess");

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date endTime = new Date();

        String startTimeFrame = oldSession.getAttribute("startTime").toString();
        String endTimeFrame = formatter.format(endTime);
        Long userId = loginService.getUserByUserName(oldSession.getAttribute("userNameSess").toString()).getId();
        Long topicId = resultList.get(0).getQuestion().getQuizTopic().getTopicId();

        Long submissionId = resultService.updateSubmission(startTimeFrame, endTimeFrame, resultList, topicId, userId);
        Submission submission = resultService.getSubmissionById(submissionId);
        Integer correctNum = resultService.getCorrectResult(resultList);
        resultService.updateHistoryResult(resultList, submissionId);

        model.addAttribute("questionList",questionList);
        model.addAttribute("choiceList", choiceList);
        model.addAttribute("resultList", resultList);
        model.addAttribute("submission", submission);
        model.addAttribute("correctNum", correctNum);
        return "resultPage";
    }
}
