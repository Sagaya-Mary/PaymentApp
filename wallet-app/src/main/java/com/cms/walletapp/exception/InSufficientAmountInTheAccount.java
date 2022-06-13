package com.cms.walletapp.exception;

public class InSufficientAmountInTheAccount extends RuntimeException{
    public InSufficientAmountInTheAccount(String msg){
        super(msg);
    }
}
