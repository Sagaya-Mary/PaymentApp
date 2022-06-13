package com.cms.walletapp.controller;

import com.cms.walletapp.beans.Customer;
import com.cms.walletapp.service.ICustomerService;
import com.cms.walletapp.util.AddCustomer;
import com.cms.walletapp.util.CustomerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @PostMapping("/customer/add")
    public CustomerDetails create(@RequestBody AddCustomer customer){
        return customerService.createWallet(customer);
    }

    @GetMapping("/customer/findById/{id}")
    public Customer findById(@PathVariable long id){
        return customerService.findCustomerById(id);
    }
    @GetMapping("/customer/findWalletId/{id}")
    public Customer findByWalletId(@PathVariable long id){
        return  customerService.findByWalletId(id);
    }

}
