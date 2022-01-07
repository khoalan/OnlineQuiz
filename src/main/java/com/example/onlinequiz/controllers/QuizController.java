package com.example.onlinequiz.controllers;

import com.example.onlinequiz.entity.Choice;
import com.example.onlinequiz.entity.Question;
import com.example.onlinequiz.entity.Result;
import com.example.onlinequiz.services.QuizService;
import com.example.onlinequiz.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/onlinequiz")
@SessionAttributes({"questionList","choiceList","resultList"})
public class QuizController {

    @Autowired
    private QuizService quizService;

    @Autowired
    private ResultService resultService;

    @GetMapping("/quiz/{id}")
    public String getQuizQuestion(@PathVariable(required = false) Long id, HttpServletRequest req, Model model){
        HttpSession oldSession = req.getSession(true);

        if (oldSession == null) {
            model.addAttribute("errorMsg", "No Authorization! Please log in");
            return "loginForm";
        } else if (oldSession.getAttribute("userNameSess") == null) {
            model.addAttribute("errorMsg", "No Authorization! Please log in");
            return "loginForm";
        }

        List<Question> questionList = quizService.getQuestionListByTopicId(id);
        List<Choice> choiceList = quizService.getChoiceListByQuestionList(questionList);
        resultService.clearResultList();
        List<Result> resultList = resultService.getResultList(choiceList);

        System.out.println("My result list inside /quiz/: " + resultList);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date startTime = new Date();

        oldSession.setAttribute("questionListSess", questionList);
        oldSession.setAttribute("choiceListSess", choiceList);
        oldSession.setAttribute("resultListSess", resultList);
        oldSession.setAttribute("startTime", formatter.format(startTime));

//        model.addAttribute("questionList", questionList.subList(0,1));
//        model.addAttribute("choiceList", choiceList.subList(0,4));
//        model.addAttribute("resultList", resultList.subList(0,1));
//        model.addAttribute("index", 0);
//        model.addAttribute("questionLeft", 10);
        return "redirect:/onlinequiz/question?index=0";
    }

    @GetMapping("/question")
    public String getQuestionScreen(HttpServletRequest req, Model model,
                                    @RequestParam(name = "input", required = false) String input,
                                    @RequestParam(name = "action", required = false) String action,
                                    @RequestParam Integer index){
        System.out.println("You are in /onlinequiz/quesion!");
        HttpSession oldSession = req.getSession(true);

        List<Question> questionList = (List<Question>) oldSession.getAttribute("questionListSess");
        List<Choice> choiceList = (List<Choice>) oldSession.getAttribute("choiceListSess");
        List<Result> resultList = (List<Result>) oldSession.getAttribute("resultListSess");

        model.addAttribute("questionList", questionList.subList(0,1));
        model.addAttribute("choiceList", choiceList.subList(0,4));
        model.addAttribute("resultList", resultList.subList(0,1));
        model.addAttribute("index", 1);
        model.addAttribute("notFinish", 10);
        return "question";
    }

    @PostMapping("/question")
    public String submitAnswer(HttpServletRequest req, Model model,
                               @RequestParam(name = "input", required = false) String input,
                               @RequestParam("action") String action,
                               @RequestParam Integer index) {
        System.out.println("You are in post /onlinequiz/quesion!");
        HttpSession oldSession = req.getSession(false);

        List<Question> questionList = (List<Question>) oldSession.getAttribute("questionListSess");
        List<Choice> choiceList = (List<Choice>) oldSession.getAttribute("choiceListSess");
        List<Result> resultList = (List<Result>) oldSession.getAttribute("resultListSess");
//Old working code
//        if (input == null){
//            resultList.get(index).setSelectedAnswer(0L);
//            model.addAttribute("notFinish", 1);
//        } else{
//            resultList.get(index).setSelectedAnswer(Long.parseLong(input));
//        }
//Old working code


        if (input == null){
            resultList.get(index-1).setSelectedAnswer(0L);

        } else{
            resultList.get(index-1).setSelectedAnswer(Long.parseLong(input));
        }

        int notFinish = 0;
        for (Result r:resultList){
            if (r.getSelectedAnswer() == null || r.getSelectedAnswer() == 0){
                notFinish++;
            }
        }
        System.out.println("Not finish:" + notFinish);
        model.addAttribute("notFinish", notFinish);

        System.out.println("Current index: " + index);
        System.out.println("Question: " + questionList.get(index-1).getQuestionId() + questionList.get(index-1).getQuestionDetail());
        System.out.println("Selected answer: " + resultList.get(index-1).getSelectedAnswer());
        System.out.println("Selected answer from view: " + input);
        System.out.println("Corrected answer: " + quizService.getCorrectAnswerByQuestion(questionList.get(index-1)).getChoiceId());

        System.out.println(resultList);

        if (action.equals("next")){
            model.addAttribute("questionList", questionList.subList(index, index+1));
            model.addAttribute("choiceList", choiceList.subList((index)*4, (index)*4+4));
            model.addAttribute("resultList", resultList.subList(index, index+1));
            model.addAttribute("index", index + 1);
            return "question";
        }
        if (action.equals("previous")){
            model.addAttribute("questionList", questionList.subList(index-2, index-1));
            model.addAttribute("choiceList", choiceList.subList((index-2)*4, (index-2)*4+4));
            model.addAttribute("resultList", resultList.subList(index-2, index-1));
            model.addAttribute("index", index - 1);
            return "question";
        }
        return "redirect:/onlinequiz/result";
    }
}

//Old
//        if (action.equals("next")){
//            model.addAttribute("questionList", questionList.subList(index+1, index+2));
//            model.addAttribute("choiceList", choiceList.subList((index+1)*4, (index+1)*4+4));
//            model.addAttribute("resultList", resultList.subList(index+1, index+2));
//            model.addAttribute("index", index + 1);
//            return "question";
//        }
//        if (action.equals("previous")){
//            model.addAttribute("questionList", questionList.subList(index-1, index));
//            model.addAttribute("choiceList", choiceList.subList((index-1)*4, (index-1)*4+4));
//            model.addAttribute("resultList", resultList.subList(index-1, index));
//            model.addAttribute("index", index - 1);
//            return "question";
//        }
//        model.addAttribute("questionList",questionList);
//        model.addAttribute("choiceList", choiceList);
//        model.addAttribute("resultList", resultList);
