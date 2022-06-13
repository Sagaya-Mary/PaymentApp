package com.cms.walletapp.exception;

public class MoneyIsNotSufficientToOpenTheAccount  extends RuntimeException{


    public MoneyIsNotSufficientToOpenTheAccount(String msg){
        super(msg);
    }
}
