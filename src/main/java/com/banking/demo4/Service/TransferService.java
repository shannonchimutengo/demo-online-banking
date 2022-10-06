package com.banking.demo4.Service;

import com.banking.demo4.Entity.Account;
import com.banking.demo4.Entity.Payment;
import com.banking.demo4.Entity.Transfer;
import com.banking.demo4.Repository.AccountRepository;
import com.banking.demo4.Repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransferService {
    @Autowired
    TransferRepository transferRepository;
    @Autowired
    AccountRepository accountRepository;

    public String transfer(Long accountHolder, Long beneficiaryAccount, Double amount, Principal principal) {

       try {


           Account checkAccountHolder = accountRepository.findByAccount(accountHolder, principal.getName());
           Account checkBeneficiaryAccount = accountRepository.findByAccount_number(beneficiaryAccount);
           System.out.println("holder: " + checkAccountHolder);
           System.out.println("bensfiii: " + checkBeneficiaryAccount);

           if (checkAccountHolder != null && checkBeneficiaryAccount != null) {
               Double accountHolderBalance = checkAccountHolder.getAccount_balance();
               Double beneficiaryAccountBalance = checkBeneficiaryAccount.getAccount_balance();


               if (accountHolderBalance == null) {

                   accountHolderBalance = 0.0;
               }
               if (beneficiaryAccountBalance == null) {

                   beneficiaryAccountBalance = 0.0;

               }
               System.out.println("account balances holder" + accountHolderBalance);
               System.out.println("account balances beneficiary" + beneficiaryAccountBalance);

               if (accountHolderBalance >= amount) {

                   accountHolderBalance = accountHolderBalance - amount;
                   beneficiaryAccountBalance = beneficiaryAccountBalance + amount;

                   accountRepository.updateBalanceAfterPayment(accountHolderBalance, accountHolder);
                   accountRepository.updateBalanceAfterPayment(beneficiaryAccountBalance, beneficiaryAccount);

                   Transfer transfer = Transfer.builder()
                           .accountHolder(accountHolder)
                           .amount(amount)
                           .beneficiaryAccount(beneficiaryAccount)
                           .reference("Transfer")
                           .localDateTime(LocalDateTime.now())
                           .userId(principal.getName())
                           .build();
                   transferRepository.save(transfer);
                   return "transaction successful";
               }

           }
           return "transaction failed check your account balance or beneficiary does not exists";
       }catch (NumberFormatException exception ){
           return "Invalid account entered";
       }
    }
    public List<Transfer> transferhistory(Principal principal){

        return transferRepository.findByUserId(principal.getName());
    }
}
