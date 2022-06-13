package com.cms.walletapp.exception;

public class AccountNotAssociateWithWallet extends RuntimeException{

    public AccountNotAssociateWithWallet(String msg){
        super(msg);
    }
}
