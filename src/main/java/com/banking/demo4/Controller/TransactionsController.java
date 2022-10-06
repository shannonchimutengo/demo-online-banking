package com.banking.demo4.Controller;

import com.banking.demo4.Entity.Payment;
import com.banking.demo4.Entity.Transfer;
import com.banking.demo4.Entity.Withdrawal;
import com.banking.demo4.Service.PaymentService;
import com.banking.demo4.Service.TransferService;
import com.banking.demo4.Service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class TransactionsController {
    @Autowired
    TransferService transferService;
    @Autowired
    PaymentService paymentService;
    @Autowired
    WithdrawalService withdrawalService;

    @GetMapping("/transactions")
    public String transactions(Model model,  Principal principal){

       List<Withdrawal> withdrawalList =  withdrawalService.withdrawalHistory( principal);
       List<Transfer> transferList = transferService.transferhistory(principal);

       List<Payment> paymentList = paymentService.paymentHistory(principal);

        model.addAttribute("Withdrawals",withdrawalList);
        model.addAttribute("Transfers",transferList);
        model.addAttribute("Payments",paymentList);

        return "transactions.html";
    }
}
