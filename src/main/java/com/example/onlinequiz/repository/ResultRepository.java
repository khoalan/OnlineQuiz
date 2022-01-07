package com.example.onlinequiz.repository;

import com.example.onlinequiz.entity.Result;
import com.example.onlinequiz.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {

//      @Query(value = "SELECT r FROM Result r WHERE r.correctAnswer = r.selectedAnswer")
//      public List<Result> findByCorrectAnswer();
 }
