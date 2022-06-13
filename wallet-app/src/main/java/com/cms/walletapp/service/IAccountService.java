package com.cms.walletapp.service;

import com.cms.walletapp.beans.BankAccount;
import com.cms.walletapp.util.AccountDetails;
import com.cms.walletapp.util.AddAccount;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface IAccountService {
    AccountDetails addAccount(@Valid AddAccount account);
    AccountDetails findAccountById(long id);
}
