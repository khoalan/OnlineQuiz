package com.example.onlinequiz.repository.impl;

import com.example.onlinequiz.entity.Choice;
import com.example.onlinequiz.entity.Result;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ResultRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertWithQuery(Choice choice) {
        entityManager.createNativeQuery("INSERT INTO result (question_id, correct_answer, selected_answer) VALUES (?,?,?)")
                .setParameter(1, choice.getQuestion().getQuestionId())
                .setParameter(2, choice.getChoiceId())
                .setParameter(3, 0)
                .executeUpdate();
    }

    @Transactional
    public List<Result> findAllResult() {
        Query query = entityManager.createQuery("SELECT e FROM Result e WHERE e.resultId > (SELECT MAX(e.resultId) - 10 from Result e)").setMaxResults(10);
        return (List<Result>) query .getResultList();
    }

    @Transactional
    public void clearAllResult() {
        Query query = entityManager.createQuery("delete FROM Result r where r.submission is NULL");
        query.executeUpdate();
    }

//    @Transactional
//    public void updateResultBySubmissionId(Long submissionId, Long selectedAnswer){
//        Query query = entityManager.createQuery("UPDATE Result r SET (r.submission.submissionId, r.selectedAnswer) = (:submissionId, :selectedAnswer) "
//                                + " WHERE r.resultId > (SELECT MAX(r.resultId) - 3 from Result r)");
//        query.executeUpdate();

}
