package com.cms.walletapp.service;

import com.cms.walletapp.beans.BankAccount;
import com.cms.walletapp.beans.BankTransaction;
import com.cms.walletapp.beans.Customer;
import com.cms.walletapp.beans.Wallet;
import com.cms.walletapp.exception.AccountNotFound;
import com.cms.walletapp.exception.CustomerNotFoundException;
import com.cms.walletapp.exception.MoneyIsNotSufficientToOpenTheAccount;
import com.cms.walletapp.exception.WalletNotFoundException;
import com.cms.walletapp.mapstruct.IWalletMapper;
import com.cms.walletapp.repository.IAccountDao;
import com.cms.walletapp.repository.ICustomerDao;
import com.cms.walletapp.util.AccountDetails;
import com.cms.walletapp.util.AddAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AccountServiceImp implements IAccountService{

    @Autowired
    private IWalletMapper mapper;
    @Autowired
    private ICustomerDao customerDao;
    @Autowired
    private IAccountDao accountDao;
    @Override
    public AccountDetails addAccount(AddAccount account) {
        BankAccount bankAccount=new BankAccount();
        if(account.getBalance()<1000){
            throw new MoneyIsNotSufficientToOpenTheAccount("We need at least 1000 rupees to open the account in wallet");
        }
        bankAccount.setBalance(account.getBalance());
        bankAccount.setBankName(account.getBankName());
        bankAccount.setIfscCode(account.getIfscCode());
        long id=account.getWallet().getWalletId();
        Customer cust=customerDao.findByWalletId(id);

//        if(!cust.equals(account.getCustomer())) {
//            throw new CustomerNotFoundException("please enter correct customer details");
//        }

        bankAccount.setCustomer(account.getCustomer());
        if(customerDao.findByWalletId(id)==null){
            throw new WalletNotFoundException("wallet not found");
        }
        bankAccount.setWallet(account.getWallet());

        bankAccount= accountDao.save(bankAccount);
        AccountDetails detail=mapper.convertAccountDto(bankAccount);
        return detail;

    }

    @Override
    public AccountDetails findAccountById(long id) {
        Optional<BankAccount> optional=accountDao.findById(id);
        if(!optional.isPresent()){
            throw new AccountNotFound("this account is not found");
        }
      BankAccount account= optional.get();

        AccountDetails detail=mapper.convertAccountDto(account);
        return detail;
    }
}


