package com.example.onlinequiz.services;

import com.example.onlinequiz.entity.Choice;
import com.example.onlinequiz.entity.Result;
import com.example.onlinequiz.entity.Submission;
import com.example.onlinequiz.repository.SubmissionRepository;
import com.example.onlinequiz.repository.impl.HistoryResultRepositoryImpl;
import com.example.onlinequiz.repository.impl.ResultRepositoryImpl;
import com.example.onlinequiz.repository.impl.SubmissionRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepositoryImpl resultRepo;

    @Autowired
    private SubmissionRepositoryImpl submissionRepo;

    @Autowired
    private SubmissionRepository submissionRepoInf;

    @Autowired
    private HistoryResultRepositoryImpl historyResultRepo;

//    public Submission getSubmission(){
//
//    }
    @Transactional
    public List<Result> getResultList(List<Choice> choiceList){
        List<Result> resultList = new ArrayList<>();
        for (Choice choice:choiceList){
            if (choice.getIsAnswer() == 1){
                resultRepo.insertWithQuery(choice);
            }
        }
        return resultRepo.findAllResult();
    }

    @Transactional
    public void clearResultList(){
        resultRepo.clearAllResult();
    }

    public Long updateSubmission(String startTime, String endTime, List<Result> resultList, Long topicId, Long userId){

        System.out.println("RSList in side update submission: " + resultList);
        String isPass;
        if (isPass(resultList)){
            isPass = "Passed";
        } else{
            isPass = "Fail";
        }
        submissionRepo.insertSubmission(startTime, endTime, isPass, topicId, userId);
        List<Submission> submission = submissionRepo.findLastSubmission();
        System.out.println("Submission id: " + submission.get(0).getSubmissionId());
        return submission.get(0).getSubmissionId();
    }
//    Long submissionId = resultService.updateSubmission(startTimeFrame, endTimeFrame, resultList, topicId, userId);

    public boolean isPass(List<Result> resultList){
        System.out.println("In side ispass: " + resultList);
        int countCorrectAnswer = 0;
        for (Result r:resultList){
            System.out.println("Select: " + r.getSelectedAnswer());
            System.out.println("Correct: " + r.getCorrectAnswer());
            if (r.getSelectedAnswer().equals(r.getCorrectAnswer())) {
                countCorrectAnswer++;
            }
        }
        if (countCorrectAnswer >= 6) return true;
        return false;
    }

    public List<Submission> getSubmissionByUserId(Long userId){

        return submissionRepoInf.findSubmissionByUserId(userId);
    }

    public Submission getSubmissionById(Long id){

        return submissionRepoInf.findSubmissionById(id);
    }

    public int getCorrectResult(List<Result> resultList){
        System.out.println("In side correct result: " + resultList);
        int correctAnswer = 0;
        for (Result r:resultList){
            System.out.println("S" + r.getSelectedAnswer());
            System.out.println("C" + r.getCorrectAnswer());
            System.out.println(correctAnswer);
            System.out.println(r.getSelectedAnswer() == r.getCorrectAnswer());
            System.out.println(r.getSelectedAnswer().equals(r.getCorrectAnswer()));
            if (r.getSelectedAnswer().equals(r.getCorrectAnswer())) {
                correctAnswer++;
            }
            System.out.println(correctAnswer);
        }
        System.out.println(correctAnswer);
        return correctAnswer;
    }

    public void updateHistoryResult(List<Result> resultList, Long submissionId){
        for (Result r:resultList){
            historyResultRepo.insertHistoryResult(r.getCorrectAnswer(), r.getSelectedAnswer(), r.getQuestion().getQuestionId(),submissionId);
        }

    }
}
