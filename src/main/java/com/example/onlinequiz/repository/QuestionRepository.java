package com.example.onlinequiz.repository;

import com.example.onlinequiz.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query("SELECT q FROM Question q WHERE q.quizTopic.topicId = ?1 ")
    public List<Question> findQuestionsByQuizTopicId(Long topicId);
}
