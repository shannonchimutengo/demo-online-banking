package com.banking.demo4.Repository;

import com.banking.demo4.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@SuppressWarnings("all")
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAllByUserId(String username);

    @Query(nativeQuery = true, value = "select account_balance from account where account_number = ?1 and user_id = ?2")
    Double findByAccount_NumberAndUser_Id(@Param("account_number") Long account_number, @Param("user_id") String user_id);

    @Query(nativeQuery = true, value = "select * from account where  account_number = ?1 and user_id =?2")
    Account findByAccount(@Param("account_number") Long account_number, @Param("user_id") String user_id);

    @Query(nativeQuery = true, value = "select * from account where  account_number = ?1")
    Account findByAccount_number(@Param("account_number") Long account_number);

    @Query(nativeQuery = true, value = "select account_balance from account where account_number = ?1")
    Double retriveAccounBalance(@Param("account_number") Long account_number);


    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update account set account_balance = ? where  account_number = ? and  user_id = ?")
    void updateBalance(@Param("account_balance") Double amount, @Param("account_number") Long account_number, @Param("user_id") String user_id);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update account set account_balance = ?1 where  account_number = ?2")
    void updateBalanceAfterPayment(@Param("account_balance") Double amount, @Param("account_number") Long account_number);
}
