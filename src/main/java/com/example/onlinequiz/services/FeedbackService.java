package com.example.onlinequiz.services;

import com.example.onlinequiz.repository.impl.FeedbackRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepositoryImpl feedbackRepo;

    public void insertNewFeedback(Long topicId, Integer rating, String comment) {
        feedbackRepo.insertFeedback(topicId, rating, comment);
    }
}
