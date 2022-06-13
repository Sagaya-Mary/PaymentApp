package com.cms.walletapp.beans;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class BankAccount implements Serializable {

    @Id
    @GeneratedValue
    private Long accountId;
    private String ifscCode;
    private String bankName;
    private Double balance;
    @ManyToOne
    private Wallet wallet;
    @ManyToOne
    private Customer customer;
    private static final long serialVersionUID = 1L;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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
