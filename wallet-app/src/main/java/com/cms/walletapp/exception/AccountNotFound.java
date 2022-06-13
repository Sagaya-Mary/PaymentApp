package com.cms.walletapp.exception;

import com.cms.walletapp.util.AccountDetails;

public class AccountNotFound extends  RuntimeException{
    public AccountNotFound(String msg){
        super(msg);
    }
}
