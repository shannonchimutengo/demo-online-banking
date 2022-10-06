package com.banking.demo4.Repository;

import com.banking.demo4.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users,Long> {

   Users findByUsername(String username);

}
