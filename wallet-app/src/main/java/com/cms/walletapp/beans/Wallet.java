package com.cms.walletapp.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Wallet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long walletId;
    @OneToMany(mappedBy = "wallet")
    @JsonIgnore
    private List<BankAccount> account;
    private static final long serialVersionUID = 1L;

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public List<BankAccount> getAccount() {
        return account;
    }

    public void setAccount(List<BankAccount> account) {
        this.account = account;
    }
}
