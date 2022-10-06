package com.banking.demo4.Controller;

import com.banking.demo4.Entity.Transfer;
import com.banking.demo4.Service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@Controller
public class TransferController {
    @Autowired
    TransferService transferService;

    @PostMapping("/transfer")
    @ResponseBody
    public String transfer(HttpServletRequest request, Principal principal) {
try {


    Long accountHolder = Long.parseLong(request.getParameter("account_number"));
    Long beneficiaryAccount = Long.parseLong(request.getParameter("beneficiary_account"));
    Double amount = Double.parseDouble(request.getParameter("transfer_amount"));

    return transferService.transfer(accountHolder, beneficiaryAccount, amount, principal);

}catch(Exception exception){

    return "Failed :( ->  Number Format Exception... please enter a valid account number";

}

    }

}
