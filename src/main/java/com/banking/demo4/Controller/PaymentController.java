package com.banking.demo4.Controller;

import com.banking.demo4.Entity.Account;
import com.banking.demo4.Service.AccountService;
import com.banking.demo4.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    @PostMapping("/payment")
    @ResponseBody
    public String payment(HttpServletRequest request, Principal principal){

        try {

            Long accountHolder = Long.parseLong(request.getParameter("account_number"));
            Long beneficiaryAccount = Long.parseLong(request.getParameter("beneficiary_account"));
            Double amount = Double.parseDouble(request.getParameter("amount"));
            String reference = request.getParameter("reference");

            return paymentService.payment(accountHolder, beneficiaryAccount, amount, reference, principal);
        }catch (Exception exception){
            return "Failed Invalid value ): "+" "+exception.getMessage();
        }
    }

}
