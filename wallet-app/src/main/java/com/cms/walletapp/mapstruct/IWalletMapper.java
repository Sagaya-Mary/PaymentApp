package com.cms.walletapp.mapstruct;

import com.cms.walletapp.beans.BankAccount;
import com.cms.walletapp.beans.Customer;
import com.cms.walletapp.util.AccountDetails;
import com.cms.walletapp.util.CustomerDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IWalletMapper {
    @Mapping(source = "customerId",target = "customerId")
    CustomerDetails convertCustomerDto (Customer customer);
    @Mapping(source = "accountId",target = "accountId")
    AccountDetails convertAccountDto(BankAccount account);
}
