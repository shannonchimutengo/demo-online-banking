package com.banking.demo4.Service;

import com.banking.demo4.Entity.Users;
import com.banking.demo4.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    UserRepository userRepository;

    public void registerUser(Users users){

       userRepository.save(users);
    }
}

