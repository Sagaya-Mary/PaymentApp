package com.cms.walletapp.service;

import com.cms.walletapp.beans.BankAccount;
import com.cms.walletapp.beans.BankTransaction;
import com.cms.walletapp.beans.Customer;
import com.cms.walletapp.exception.AccountNotAssociateWithWallet;
import com.cms.walletapp.exception.AccountNotFound;
import com.cms.walletapp.exception.InSufficientAmountInTheAccount;
import com.cms.walletapp.exception.WalletNotFoundException;
import com.cms.walletapp.mapstruct.IWalletMapper;
import com.cms.walletapp.repository.IAccountDao;
import com.cms.walletapp.repository.ICustomerDao;
import com.cms.walletapp.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TransactionServiceImp implements ITransactionService{

    @Autowired
    private ICustomerService customerService;
    @Autowired
    private ICustomerDao customerDao;
    @Autowired
    private IAccountDao accountDao;
    @Autowired
    private IAccountService service;
    @Autowired
    private IWalletMapper mapper;
    @Override
    public AccountDetails withdraw(AddRequest request) {
        long walletId=request.getWalletId();
        long accountId=request.getAccountId();
        String type=request.getType();
        double amount=request.getAmount();
        Customer customer=customerDao.findByWalletId(walletId);
      //  Wallet wallet=customer.getWallet();
        if(customerDao.findByWalletId(walletId)==null){
            throw new WalletNotFoundException("wallet is not exist");
        }
        if(customer.getWallet()==null){
            throw new WalletNotFoundException("wallet is not exist");
        }
        AccountDetails account=service.findAccountById(accountId);
       long requestWalletId=account.getWallet().getWalletId();
            if(requestWalletId!=walletId){
                throw new AccountNotAssociateWithWallet("Wallet with walledId is not associated with accountId ");
            }

//        List<BankAccount>list=accountDao.findByWalletId(walletId);
//        long id=list.get(0).getWallet().getWalletId();
//        if(id==walletId){
//            throw new AccountNotAssociateWithWallet("Wallet with walledId is not associated with accountId ");
//        }
        List<BankAccount> associateAccount =  customer.getWallet().getAccount().stream().filter(aa -> aa.getAccountId() == accountId).collect(Collectors.toList());
        if(associateAccount.get(0).getBalance()<amount){
            throw new InSufficientAmountInTheAccount("Your account is not having sufficient money");
        }
        double currentBalance=associateAccount.get(0).getBalance();
        associateAccount.get(0).setBalance(currentBalance-amount);
        BankAccount ac=accountDao.save(associateAccount.get(0));
        AccountDetails detail=mapper.convertAccountDto(ac);
        BankTransaction transaction=new BankTransaction();
        if(type.equals("WITHDRAW")){
            transaction.setTransactionType(TransactionConstants.WITHDRAW);
            transaction.setAccount(associateAccount.get(0));
            transaction.setDescription(TransactionConstants.WITHDRAW_DESCRIPTION);
            transaction.setStatus(TransactionConstants.STATUS_OK);
        }
        return detail;
    }

    @Override
    public AccountDetails deposit(AddRequest request) {
        long walletId=request.getWalletId();
        long accountId=request.getAccountId();
        String type=request.getType();
        double amount=request.getAmount();
        Customer customer=customerDao.findByWalletId(walletId);
        if(customer.getWallet()==null){
            throw new WalletNotFoundException("wallet is not exist");
        }
        AccountDetails account=service.findAccountById(accountId);
        long requestWalletId=account.getWallet().getWalletId();
        if(requestWalletId!=walletId){
            throw new AccountNotAssociateWithWallet("Wallet with walledId is not associated with accountId ");
        }
        List<BankAccount> associateAccount =  customer.getWallet().getAccount().stream().filter(aa -> aa.getAccountId() == accountId).collect(Collectors.toList());
        if(associateAccount.get(0).getBalance()<amount){
            throw new InSufficientAmountInTheAccount("Your account is not having sufficient money");
        }
        double currentBalance=associateAccount.get(0).getBalance();
        associateAccount.get(0).setBalance(currentBalance+amount);
        BankAccount ac=accountDao.save(associateAccount.get(0));
        AccountDetails detail=mapper.convertAccountDto(ac);
        BankTransaction transaction=new BankTransaction();
        if(type.equals("DEPOSIT")){
            transaction.setTransactionType(TransactionConstants.DEPOSIT);
            transaction.setAccount(associateAccount.get(0));
            transaction.setDescription(TransactionConstants.DEPOSIT_DESCRIPTION);
            transaction.setStatus(TransactionConstants.STATUS_OK);
        }
        return detail;
    }

    @Override
    public ServiceResponse transfer(AddMoneyTransfer request) {
        long walletId1=request.getWalletId1();
        long walletId2=request.getWalletId2();
        long accountId1=request.getAccountId1();
        long accountId2=request.getAccountId2();
        String type=request.getType();
        double amount=request.getAmount();
        Customer customer1=customerDao.findByWalletId(walletId1);
        Customer customer2=customerDao.findByWalletId(walletId2);
        if(customer1.getWallet().getWalletId()==null || customer2.getWallet().getWalletId()==null){
            throw new WalletNotFoundException("wallet is not found");
        }
        AccountDetails account1=service.findAccountById(accountId1);
        AccountDetails account2=service.findAccountById(accountId2);
        if(account1==null || account2==null){
            throw new AccountNotFound("Account is not found");
        }
        long requestWalletId1=account1.getWallet().getWalletId();
        long requestWalletId2=account2.getWallet().getWalletId();
        if(requestWalletId1!=walletId1 || requestWalletId2!=walletId2){
            throw new AccountNotAssociateWithWallet("mismatch wallet and account");
        }
        List<BankAccount> associateAccount1=customer1.getAccount().stream().filter(aa->aa.getAccountId()==accountId1).collect(Collectors.toList());

        List<BankAccount> associateAccount2=customer2.getAccount().stream().filter(aa->aa.getAccountId()==accountId2).collect(Collectors.toList());

        double currentBalanceForCustomer1=associateAccount1.get(0).getBalance();
        double currentBalanceForCustomer2=associateAccount2.get(0).getBalance();
        if(associateAccount1.get(0).getBalance()<amount){
            throw new InSufficientAmountInTheAccount("Your account is not having sufficient money");
        }
        associateAccount1.get(0).setBalance(currentBalanceForCustomer1-amount);
        associateAccount2.get(0).setBalance(currentBalanceForCustomer2+amount);
        BankAccount ac1=accountDao.save(associateAccount1.get(0));
        BankAccount ac2=accountDao.save(associateAccount2.get(0));
        //AccountDetails detail=mapper.convertAccountDto(ac1);
        BankTransaction transaction=new BankTransaction();
        if(type.equals("TRANSFER")){
            transaction.setTransactionType(TransactionConstants.TRANSFER);
            transaction.setStatus(TransactionConstants.STATUS_OK);
        }
        ServiceResponse detail=new ServiceResponse();
        detail.setDescription("Transfer successful");
        detail.setStatus(TransactionConstants.STATUS_OK);
        return detail;
    }

    @Override
    public double getBalance(long walletId, long accountId) {
        AccountDetails accounts=service.findAccountById(accountId);
        long wall=accounts.getWallet().getWalletId();
        long acc=accounts.getAccountId();
        if(accounts==null){
            throw new AccountNotFound("account is not found");
        }
        if(wall!=walletId){
            throw new AccountNotAssociateWithWallet("Wallet with walledId is not associated with accountId ");
        }
        return accounts.getBalance();

    }

}
