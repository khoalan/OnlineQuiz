package com.example.onlinequiz.services;

import com.example.onlinequiz.entity.Choice;
import com.example.onlinequiz.entity.Question;
import com.example.onlinequiz.entity.QuizTopic;
import com.example.onlinequiz.repository.ChoiceRepository;
import com.example.onlinequiz.repository.QuestionRepository;
import com.example.onlinequiz.repository.QuizTopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class QuizService {

    private final int totalQuiz = 10;

    @Autowired
    private QuizTopicRepository quizTopicRepo;

    @Autowired
    private QuestionRepository questionRepo;

    @Autowired
    private ChoiceRepository choiceRepo;

    private List<Question> questionList = new ArrayList<>();

    public List<QuizTopic> getAllQuizTopic(){
        List<QuizTopic> quizTopics = new ArrayList<>();
        quizTopics = quizTopicRepo.findAll();
        return quizTopics;
    }

    public List<Question> getQuestionListByTopicId(Long id){
        List<Question> allQuestions = new ArrayList<>();
        allQuestions = questionRepo.findQuestionsByQuizTopicId(id);

        Random rand = new Random();
        questionList.clear();

        for (int i = 0; i < totalQuiz; i++){
            int randomIdx = rand.nextInt(allQuestions.size());
            questionList.add(allQuestions.get(randomIdx));
            allQuestions.remove(randomIdx);
        }
        System.out.println("My question: ");
        for (Question q:questionList){
            System.out.print(": " + q.getQuestionId()+ " ");
        }

        return questionList;
    }

    public List<Choice> getChoiceListByQuestionList(List<Question> questionList){
        List<Choice> choiceList = new ArrayList<>();
//        System.out.println("My question in side choice: " + questionList);
        for (int i = 0; i < questionList.size(); i++){
            List<Choice> tempChoiceList = new ArrayList<>();
            tempChoiceList = choiceRepo.findChoicesByQuestionId(questionList.get(i).getQuestionId());
            for (Choice choice:tempChoiceList){
                choiceList.add(choice);
            }
        }
        System.out.println("\nMy choices: ");
        for (Choice choice:choiceList){
            System.out.print(" ! " + choice.getChoiceId() + ": is answer " + choice.getIsAnswer());
            if (choice.getChoiceId() % 4 ==0){
                System.out.println("");
            }
        }

        return choiceList;
    }

    public Choice getCorrectAnswerByQuestion(Question question){
        Choice correctChoice = choiceRepo.findCorrectChoiceByQuestionId(question.getQuestionId());
        return correctChoice;
    }
}
