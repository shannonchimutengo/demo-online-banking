package com.banking.demo4.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {

    @Id
    @SequenceGenerator(name = "users_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "users_sequence")
    Long id;

    String password;
    String username;



}
