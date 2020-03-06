package com.shengfa.service;

import com.shengfa.domain.Account;

import java.util.List;

public interface AccountService {
    void save(Account account);

    List<Account> findAll();

    void trans(String roll_out,String roll_in,double money);
}
