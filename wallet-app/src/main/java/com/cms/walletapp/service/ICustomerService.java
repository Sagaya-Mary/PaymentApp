package com.cms.walletapp.service;

import com.cms.walletapp.beans.Customer;
import com.cms.walletapp.util.AddCustomer;
import com.cms.walletapp.util.CustomerDetails;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Validated
public interface ICustomerService {
    CustomerDetails createWallet(@Valid AddCustomer customer);
    Customer findCustomerById(long id);
    Customer findByWalletId(long id);
}
