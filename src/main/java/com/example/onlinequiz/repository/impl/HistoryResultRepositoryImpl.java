package com.example.onlinequiz.repository.impl;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class HistoryResultRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertHistoryResult(Long correctAnswer, Long selectedAnswer, Long questionId, Long submissionId) {
        entityManager.createNativeQuery("INSERT INTO history_result (correct_history_answer, selected_history_answer, question_id, submission_id) VALUES (?,?,?,?)")
                .setParameter(1,correctAnswer )
                .setParameter(2, selectedAnswer)
                .setParameter(3, questionId)
                .setParameter(4, submissionId)
                .executeUpdate();
    }
}
