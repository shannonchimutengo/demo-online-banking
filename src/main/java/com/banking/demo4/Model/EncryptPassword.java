package com.banking.demo4.Model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class EncryptPassword extends BCryptPasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return super.encode(rawPassword);
    }

}
