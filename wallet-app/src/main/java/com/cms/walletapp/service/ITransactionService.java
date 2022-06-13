package com.cms.walletapp.service;

import com.cms.walletapp.beans.BankTransaction;
import com.cms.walletapp.util.AccountDetails;
import com.cms.walletapp.util.AddMoneyTransfer;
import com.cms.walletapp.util.AddRequest;
import com.cms.walletapp.util.ServiceResponse;

public interface ITransactionService {
    AccountDetails withdraw(AddRequest request);
    AccountDetails deposit(AddRequest request);
    ServiceResponse transfer(AddMoneyTransfer request);
    double getBalance(long walletId,long accountId);
}
