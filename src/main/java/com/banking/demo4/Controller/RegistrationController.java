package com.banking.demo4.Controller;

import com.banking.demo4.Model.EncryptPassword;
import com.banking.demo4.Entity.Users;
import com.banking.demo4.Service.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RegistrationController {

    EncryptPassword encryptPassword;
    RegisterService registerService;

    public RegistrationController(EncryptPassword encryptPassword, RegisterService registerService) {
        this.encryptPassword = encryptPassword;
        this.registerService = registerService;
    }

    @RequestMapping("/registration")
    public String Register(HttpServletRequest request, HttpSession session) {
    String  username =   request.getParameter("username").toLowerCase();
    String  password =   request.getParameter("password");
    String  lastname =   request.getParameter("lastname").toLowerCase();
    String  email =   request.getParameter("email").toLowerCase();
    String  confirmPassword =   request.getParameter("confirm_password");

        if (password.equals(confirmPassword)) {
            System.out.println(true);
            Users user = Users.builder()
                    .username(email)
                    .password(encryptPassword.encode(password))
                    .build();

            registerService.registerUser(user);
            return "login_form.html";
        } else {
            return "password_error.html";
        }

    }

}
