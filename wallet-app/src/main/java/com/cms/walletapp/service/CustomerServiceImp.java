package com.cms.walletapp.service;

import com.cms.walletapp.beans.Customer;
import com.cms.walletapp.beans.Wallet;
import com.cms.walletapp.exception.CustomerAlreadyFoundException;
import com.cms.walletapp.exception.CustomerNotFoundException;
import com.cms.walletapp.mapstruct.IWalletMapper;
import com.cms.walletapp.repository.ICustomerDao;
import com.cms.walletapp.repository.IWalletDao;
import com.cms.walletapp.util.AddCustomer;
import com.cms.walletapp.util.CustomerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImp implements  ICustomerService{
    @Autowired
    private ICustomerDao customerDao;

    @Autowired
    private IWalletMapper mapper;
    @Override
    public CustomerDetails createWallet(AddCustomer customer) {

        Customer cust=new Customer();
        cust.setCustomerName(customer.getCustomerName());
        cust.setEmail(customer.getEmail());
        if (customerDao.findOne(customer.getMobileNo()) != null) {
            throw new CustomerAlreadyFoundException("This mobileno has already been registered to a customer");
        }
        cust.setMobileNo(customer.getMobileNo());
        Wallet wallet=new Wallet();
       // wallet=customer.getWallet();
        cust.setWallet(wallet);
       cust= customerDao.save(cust);

        CustomerDetails detail= mapper.convertCustomerDto(cust);
        return detail;
    }

    @Override
    public Customer findCustomerById(long id) {
        Optional<Customer> optional=customerDao.findById(id);
        if(!optional.isPresent()){
            throw new CustomerNotFoundException("customer is not found");
        }
        Customer customer=optional.get();
        return customer;

    }

    @Override
    public Customer findByWalletId(long id){
        return customerDao.findByWalletId(id);
    }
}
