package com.example.onlinequiz;

import com.example.onlinequiz.entity.QuizTopic;
import com.example.onlinequiz.entity.User;
import com.example.onlinequiz.repository.QuizTopicRepository;
import com.example.onlinequiz.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class QuizTopicRepositoryTest {
    @Autowired
    private QuizTopicRepository repo;

    @Autowired
    private TestEntityManager entityManager;

//    @InjectMocks
//    private LoginService loginService;

    @Test
    public void testCreateTopic(){
        QuizTopic topic1 = QuizTopic.builder()
                .topicName("HTML")
                .topicDescription("HTML quiz")
                .topicDifficulty("Normal")
                .topicImageUrl("https://img.icons8.com/external-soft-fill-juicy-fish/344/external-html-coding-and-development-soft-fill-soft-fill-juicy-fish.png")
                .topicTimeLimit(15L)
                .build();

        QuizTopic topic2 = QuizTopic.builder()
                .topicName("JavaScript")
                .topicDescription("JavaScript quiz")
                .topicDifficulty("Normal")
                .topicImageUrl("https://img.icons8.com/external-soft-fill-juicy-fish/344/external-html-coding-and-development-soft-fill-soft-fill-juicy-fish.png")
                .topicTimeLimit(10L)
                .build();

        QuizTopic topic3 = QuizTopic.builder()
                .topicName("Python")
                .topicDescription("Python quiz")
                .topicDifficulty("Extreme")
                .topicImageUrl("https://img.icons8.com/external-soft-fill-juicy-fish/344/external-html-coding-and-development-soft-fill-soft-fill-juicy-fish.png")
                .topicTimeLimit(1L)
                .build();
        QuizTopic savedTopic = repo.save(topic1);
        QuizTopic savedTopic2 = repo.save(topic2);
        QuizTopic savedTopic3 = repo.save(topic3);

        QuizTopic existUser = entityManager.find(QuizTopic.class, savedTopic.getTopicId());

        assertThat(existUser.getTopicName()).isEqualTo(topic1.getTopicName());
    }

}
