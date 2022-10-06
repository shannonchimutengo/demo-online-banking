package com.banking.demo4.Repository;

import com.banking.demo4.Entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {
@Autowired
  UserRepository userRepository;
    @Test
    void findByUsername() {
   Users user =  userRepository.findByUsername("shannonchimutengo@gmail.com");
        System.out.println(user);
    }
}