package com.cms.walletapp.util;

import com.cms.walletapp.beans.BankAccount;
import com.cms.walletapp.beans.Wallet;

import javax.persistence.*;
import java.util.List;

public class CustomerDetails {
    private Long customerId;
    private String customerName;
    private String email;
    private String mobileNo;

    private Wallet wallet;

    private List<BankAccount> account;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
