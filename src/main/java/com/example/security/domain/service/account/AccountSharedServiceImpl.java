package com.example.security.domain.service.account;

import java.util.List;

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

    @Override
    @Transactional(readOnly = true)
    public List<Account> findOne(String username) {
        Account param = new Account();
        param.setUsername(username);
        List<Account> account = accountRepository.findOne(param);
        if (account.isEmpty()) {
            throw new ResourceNotFoundException(
                    "The given account is not found! username=" + param.getUsername());
        }
        return account;
    }

}
