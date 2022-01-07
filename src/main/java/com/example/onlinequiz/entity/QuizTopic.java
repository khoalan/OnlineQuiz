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
@Table(name = "quiz_topic")
public class QuizTopic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicId;

    private String topicName;
    private String topicDifficulty;
    private Long topicTimeLimit;
    private String topicDescription;
    private String topicImageUrl;
}
