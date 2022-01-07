package com.example.onlinequiz.repository.impl;

import com.example.onlinequiz.entity.Choice;
import com.example.onlinequiz.entity.Result;
import com.example.onlinequiz.entity.Submission;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class SubmissionRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertSubmission(String startTime, String endTime, String isPass, Long topicId, Long userId) {
        entityManager.createNativeQuery("INSERT INTO submission (start_time, end_time, is_pass, topic_id, id) VALUES (?,?,?,?,?)")
                .setParameter(1,startTime )
                .setParameter(2, endTime)
                .setParameter(3, isPass)
                .setParameter(4, topicId)
                .setParameter(5, userId)
                .executeUpdate();
    }

    @Transactional
    public List<Submission> findLastSubmission() {
        Query query = entityManager.createQuery("SELECT e FROM Submission e order by e.submissionId desc").setMaxResults(1);
        return (List<Submission>) query.getResultList();
    }


}
