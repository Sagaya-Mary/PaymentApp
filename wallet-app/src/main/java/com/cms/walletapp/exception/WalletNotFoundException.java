package com.cms.walletapp.exception;

public class WalletNotFoundException extends RuntimeException{
    public WalletNotFoundException(String msg){
        super(msg);
    }
}
