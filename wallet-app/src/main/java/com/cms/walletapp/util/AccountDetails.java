package com.cms.walletapp.util;

import com.cms.walletapp.beans.Customer;
import com.cms.walletapp.beans.Wallet;

public class AccountDetails {

    private long accountId;
    private String ifscCode;
    private String bankName;
    private Double balance;
    private Wallet wallet;
    private Customer customer;

    public long getAccountId(){
        return accountId;
    }
    public void setAccountId(long accountId){
        this.accountId=accountId;
    }
    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
