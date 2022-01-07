package com.example.onlinequiz.services;

import com.example.onlinequiz.entity.User;
import com.example.onlinequiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepo;

    public boolean validUserName(String userName){
        User user = userRepo.findByUserName(userName);
        if (user != null)
            return false;
        return true;
    }
    public boolean validEmail(String email){
        User user = userRepo.findByEmail(email);
        if (user != null)
            return false;
        return true;
    }

    public void saveNewUser(User user){
        userRepo.save(user);
    }

    //Implement check unique username, email
}
