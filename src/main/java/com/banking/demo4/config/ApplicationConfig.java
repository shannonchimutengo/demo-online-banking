package com.banking.demo4.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class ApplicationConfig  extends WebSecurityConfigurerAdapter {
     @Autowired
     UserDetailsService userDetailsService;
     @Bean
        AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);

        return daoAuthenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

         http.csrf().disable()
                 .authorizeHttpRequests()
                 .antMatchers("/login","/home","/password-error","/registration","/register","/css/**","/images/**")
                 .permitAll()
                 .anyRequest()
                 .authenticated()
                 .and()
                 .formLogin()
                 .loginPage("/login")
                 .usernameParameter("username")
                 .passwordParameter("password")
                 .and()
                 .logout()
                 .clearAuthentication(true)
                 .invalidateHttpSession(true)
                 .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));



    }
}
