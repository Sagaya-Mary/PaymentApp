package com.cms.walletapp.repository;

import com.cms.walletapp.beans.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerDao extends JpaRepository<Customer,Long> {

    @Query("select c from Customer c where c.mobileNo = :mobileNo")
    public Customer findOne(@Param(value = "mobileNo") String mobileNo);

    @Query("select i from Customer i where i.wallet.walletId = :walletId")
    public Customer findByWalletId(@Param(value = "walletId") long walletId);


}
