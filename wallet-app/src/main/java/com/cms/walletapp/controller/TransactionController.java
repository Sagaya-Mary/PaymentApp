package com.cms.walletapp.controller;

import com.cms.walletapp.service.ITransactionService;
import com.cms.walletapp.util.AccountDetails;
import com.cms.walletapp.util.AddMoneyTransfer;
import com.cms.walletapp.util.AddRequest;
import com.cms.walletapp.util.ServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    @Autowired
    private ITransactionService service;
    @PostMapping("/transaction/withdraw")
    public AccountDetails withdraw(@RequestBody AddRequest request){
        return service.withdraw(request);
    }
    @PostMapping("/transaction/deposit")
    public AccountDetails deposit(@RequestBody AddRequest request){
        return service.deposit(request);
    }
    @PostMapping("/transaction/transfer")
    public ServiceResponse transfer(@RequestBody AddMoneyTransfer request){
        return service.transfer(request);
    }
    @GetMapping("/transaction/getBalance/{walletId},{accountId}")
    public double getBalance(@PathVariable long walletId, @PathVariable long accountId){
        return service.getBalance(walletId,accountId);
    }


}
