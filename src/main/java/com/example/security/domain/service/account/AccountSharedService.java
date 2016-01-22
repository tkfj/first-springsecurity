package com.example.security.domain.service.account;

import java.util.List;

import com.example.security.domain.model.Account;

public interface AccountSharedService {

    List<Account> findOne(String username);
}
