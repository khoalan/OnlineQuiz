package com.example.onlinequiz.repository;

import com.example.onlinequiz.entity.Choice;
import com.example.onlinequiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChoiceRepository extends JpaRepository<Choice, Long> {
    @Query("SELECT c FROM Choice c WHERE c.question.questionId = ?1")
    public List<Choice> findChoicesByQuestionId(Long topicId);

    @Query("SELECT c FROM Choice c WHERE c.question.questionId = ?1 AND c.isAnswer= 1")
    public Choice findCorrectChoiceByQuestionId(Long topicId);
}
