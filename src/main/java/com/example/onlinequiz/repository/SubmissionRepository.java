package com.example.onlinequiz.repository;

import com.example.onlinequiz.entity.Question;
import com.example.onlinequiz.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    @Query("SELECT s FROM Submission s WHERE s.user.id = ?1 ")
    public List<Submission> findSubmissionByUserId(Long userId);

    @Query("SELECT s FROM Submission s WHERE s.submissionId = ?1 ")
    public Submission findSubmissionById(Long userId);

}
