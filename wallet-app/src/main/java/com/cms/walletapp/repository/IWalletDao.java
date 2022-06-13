package com.cms.walletapp.repository;

import com.cms.walletapp.beans.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWalletDao extends JpaRepository<Wallet,Long> {
}
