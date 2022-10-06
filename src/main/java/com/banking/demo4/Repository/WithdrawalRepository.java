package com.banking.demo4.Repository;

import com.banking.demo4.Entity.Withdrawal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WithdrawalRepository extends JpaRepository<Withdrawal,Long> {

    List<Withdrawal> findByUserId(String username);
}
