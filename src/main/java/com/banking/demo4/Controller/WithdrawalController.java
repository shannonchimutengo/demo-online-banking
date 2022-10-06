package com.banking.demo4.Controller;

import com.banking.demo4.Entity.Withdrawal;
import com.banking.demo4.Service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
@Controller
public class WithdrawalController {
@Autowired
    WithdrawalService withdrawalService;

    @PostMapping("/withdraw")
    @ResponseBody
    public String withdraw(HttpServletRequest request, Principal principal){

        try{
            Long accountHolder = Long.parseLong(request.getParameter("account_number"));
            Double amount = Double.parseDouble(request.getParameter("amount"));
            return withdrawalService.withdrawal(accountHolder,amount,principal);

        }catch(Exception exception){

           return "Failed :( Invalid account or Amount ";

        }

    }
}
