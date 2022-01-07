package com.example.onlinequiz.services;

import com.example.onlinequiz.entity.User;
import com.example.onlinequiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepo;

    public boolean validateLogin(String userName, String userPassword){
        User user = userRepo.findByUserName(userName);
        if (user != null && user.getUserPassword().equals(userPassword))
            return true;
        else return false;
    }

    public User getUserByUserName(String userName){
        User user = userRepo.findByUserName(userName);
        return user;
    }
}
