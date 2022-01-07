package com.example.onlinequiz.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "submission")
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long submissionId;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private QuizTopic quizTopic;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    private String startTime;

    private String endTime;

    private String isPass;
}
