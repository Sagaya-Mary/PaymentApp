package com.cms.walletapp.exception;

public class CustomerAlreadyFoundException extends RuntimeException{

    public CustomerAlreadyFoundException(String msg){
        super(msg);
    }
}
