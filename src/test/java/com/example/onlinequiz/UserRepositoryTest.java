package com.example.onlinequiz;
import static org.assertj.core.api.Assertions.assertThat;
import com.example.onlinequiz.entity.User;
import com.example.onlinequiz.repository.UserRepository;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

//    @InjectMocks
//    private LoginService loginService;

    @Test
    public void testCreateUser(){
        User user = User.builder().userName("test456").userPassword("123").email("test@gmail.com").build();

        User savedUser = repo.save(user);

        User existUser = entityManager.find(User.class, savedUser.getId());

        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    public void testFindUserByEmail(){
        String email = "test@gmail.com";

        User user = repo.findByEmail(email);

        //System.out.println(user.toString());
        assertThat(user).isNotNull();
    }

//    @Test
//    public void testValidateLogin(){
//        String userName = "Kylan2";
//        String userPassword = "456";
//        User user = repo.findByUserName(userName);
//
//        //System.out.println(user.toString());
//        assertThat(user).isNotNull();
//        boolean login = loginService.validateLogin(userName, userPassword);
//        System.out.println(login);
//    }
}
