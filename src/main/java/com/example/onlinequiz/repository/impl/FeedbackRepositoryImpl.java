package com.example.onlinequiz.repository.impl;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class FeedbackRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertFeedback(Long topicId, Integer rating, String description){
        entityManager.createNativeQuery("INSERT INTO feedback (rating, description, topic_id) VALUES (?,?,?)")
                .setParameter(1,rating )
                .setParameter(2, description)
                .setParameter(3, topicId)
                .executeUpdate();
    }
}
