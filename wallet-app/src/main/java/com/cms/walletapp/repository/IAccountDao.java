package com.cms.walletapp.repository;

import com.cms.walletapp.beans.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAccountDao extends JpaRepository<BankAccount,Long> {

    @Query("select i from BankAccount i where i.wallet.walletId = :walletId ")
    List<BankAccount> findByWalletId(@Param(value = "walletId") long walletId);
}
