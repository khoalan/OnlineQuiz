package com.example.onlinequiz.repository;

import com.example.onlinequiz.entity.QuizTopic;
import com.example.onlinequiz.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuizTopicRepository extends JpaRepository<QuizTopic, Long> {

}
