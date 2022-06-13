package com.cms.walletapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class WalletExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomerAlreadyFoundException.class)
    public String CustomerFoundException(CustomerAlreadyFoundException e) {
        return e.getMessage();
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(WalletNotFoundException.class)
    public String WalletNotFound(WalletNotFoundException e) {
        return e.getMessage();
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(MoneyIsNotSufficientToOpenTheAccount.class)
    public String InsufficientMoneyException(MoneyIsNotSufficientToOpenTheAccount e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ConstraintViolationException.class)
    public String ConstraintException(ConstraintViolationException e) {
        return e.getMessage();
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CustomerNotFoundException.class)
    public String CustomerNotFound(CustomerNotFoundException e) {
        return e.getMessage();
    }
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(AccountNotAssociateWithWallet.class)
    public String AccountMisMatchToWallet(AccountNotAssociateWithWallet e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(AccountNotFound.class)
    public String AccountNotFoundException(AccountNotFound e) {
        return e.getMessage();
    }

}
