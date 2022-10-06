package com.banking.demo4.Service;

import com.banking.demo4.Entity.Account;
import com.banking.demo4.Entity.Payment;
import com.banking.demo4.Repository.AccountRepository;
import com.banking.demo4.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Stack;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PaymentRepository paymentRepository;

    public Account SaveAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> findAccounts(String username) {

        return accountRepository.findAllByUserId(username);
    }

    public Double getAccountBalance(Long account_number, String user_id) {

        return accountRepository.findByAccount_NumberAndUser_Id(account_number, user_id);
    }
    public void update_balance(Double amount,Long account_number, String user_id, Principal principal){

    accountRepository.updateBalance(amount,account_number,user_id);
        Payment payment = Payment.builder()
                .accountHolder(account_number)
                .reference("Deposit")
                .localDateTime(LocalDateTime.now())
                .amount(amount)
                .userId(principal.getName())
                .build();
    paymentRepository.save(payment);


    }
    public Account doesAccountExists(Long account_number, String user_id){

        return accountRepository.findByAccount(account_number, user_id);
    }

    public Account findByAccountNumber(Long account_number){

        return accountRepository.findByAccount_number(account_number);
    }
}
