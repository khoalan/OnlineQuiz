package com.example.onlinequiz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class OnlineQuizApplication {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(OnlineQuizApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        String sql = "insert into users (user_name, user_password) values (?,?)";
//        int result = jdbcTemplate.update(sql,  "lan1", "1234");
//        if (result > 0){
//            System.out.println("Inserted!");
//        }
//    }
}
