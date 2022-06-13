package com.cms.walletapp.util;

public class AddMoneyTransfer {

    private long walletId1;
    private long accountId1;
    private long walletId2;
    private long accountId2;
    private String type;
    private double amount;

    public long getWalletId1() {
        return walletId1;
    }

    public void setWalletId1(long walletId1) {
        this.walletId1 = walletId1;
    }

    public long getAccountId1() {
        return accountId1;
    }

    public void setAccountId1(long accountId1) {
        this.accountId1 = accountId1;
    }

    public long getWalletId2() {
        return walletId2;
    }

    public void setWalletId2(long walletId2) {
        this.walletId2 = walletId2;
    }

    public long getAccountId2() {
        return accountId2;
    }

    public void setAccountId2(long accountId2) {
        this.accountId2 = accountId2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
