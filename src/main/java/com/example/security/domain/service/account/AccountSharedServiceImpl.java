package com.example.security.domain.service.account;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import com.example.security.domain.model.Account;
import com.example.security.domain.repository.account.AccountRepository;

@Service
public class AccountSharedServiceImpl implements AccountSharedService {
    @Inject
    AccountRepository accountRepository;

    @Transactional(readOnly = true)
    @Override
    public Account findOne(String username, String companyId) {
        
        Account param = new Account();
        param.setUsername(username);
        param.setCompanyId(companyId);
        Account account = accountRepository.findOne(param);
        if (account == null) {
            throw new ResourceNotFoundException(
                    "The given account is not found! username=" + username);
        }
        return account;
    }

}
