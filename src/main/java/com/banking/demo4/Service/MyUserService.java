package com.banking.demo4.Service;

import com.banking.demo4.Model.UserPrincipal;
import com.banking.demo4.Entity.Users;
import com.banking.demo4.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class MyUserService implements UserDetailsService {
    @Autowired
    UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        username.toLowerCase(Locale.ROOT);
        Users user = repository.findByUsername(username.toLowerCase(Locale.ROOT));
        if (user == null){
         throw new  UsernameNotFoundException("user 404");

        }
        System.out.println("username test "+username);
        System.out.println(user);
        return new UserPrincipal(user);
    }
}
