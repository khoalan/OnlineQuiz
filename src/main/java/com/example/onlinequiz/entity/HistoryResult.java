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
@Table(name = "history_result")
public class HistoryResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyResultId;

    @ManyToOne
    @JoinColumn(name = "submission_id")
    private Submission submission;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    private Long selectedHistoryAnswer;
    private Long correctHistoryAnswer;
}