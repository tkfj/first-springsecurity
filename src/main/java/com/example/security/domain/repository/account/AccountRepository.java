package com.example.security.domain.repository.account;

import java.util.List;

import com.example.security.domain.model.Account;

public interface AccountRepository {
    List<Account> findOne(Account account);
}
