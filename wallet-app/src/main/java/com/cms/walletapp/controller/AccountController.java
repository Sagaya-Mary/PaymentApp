package com.cms.walletapp.controller;

import com.cms.walletapp.beans.BankAccount;
import com.cms.walletapp.service.IAccountService;
import com.cms.walletapp.util.AccountDetails;
import com.cms.walletapp.util.AddAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @PostMapping("/account/add")
    public AccountDetails addAccount(@RequestBody AddAccount account){
        return accountService.addAccount(account);
    }

    @GetMapping("/account/findid/{id}")
    public AccountDetails findAccountById(@PathVariable long id){
        return accountService.findAccountById(id);
    }
}
