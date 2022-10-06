package com.banking.demo4.Service;

import com.banking.demo4.Entity.Account;
import com.banking.demo4.Entity.Withdrawal;
import com.banking.demo4.Repository.AccountRepository;
import com.banking.demo4.Repository.WithdrawalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class WithdrawalService {
    @Autowired
    WithdrawalRepository withdrawalRepository;
    @Autowired
    AccountRepository accountRepository;

    public String withdrawal(Long accountHolder, Double amount, Principal principal) {


        Account checkAccountHolder = accountRepository.findByAccount(accountHolder, principal.getName());
        System.out.println("holder: " + checkAccountHolder);


        if (checkAccountHolder != null) {

            Double accountHolderBalance = checkAccountHolder.getAccount_balance();

            if (accountHolderBalance == null) {
                accountHolderBalance = 0.0;

            }
            if (accountHolderBalance >= amount) {

                accountHolderBalance = accountHolderBalance - amount;

                Withdrawal withdrawal = Withdrawal.builder()
                        .accountNumber(accountHolder)
                        .reference("Withdrawal")
                        .localDateTime(LocalDateTime.now())
                        .amount(amount * (-1))
                        .userId(principal.getName())
                        .build();
                withdrawalRepository.save(withdrawal);
                accountRepository.updateBalance(accountHolderBalance, accountHolder, principal.getName());
                return "successfully withdrawn : " + withdrawal.getAmount();
            }
        }
        return "Failed to complete the operation";
    }
    public List<Withdrawal> withdrawalHistory(Principal principal){

        return withdrawalRepository.findByUserId(principal.getName());

    }

}
