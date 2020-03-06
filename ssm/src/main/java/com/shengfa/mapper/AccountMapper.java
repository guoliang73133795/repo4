package com.shengfa.mapper;
import com.shengfa.domain.Account;
import java.util.List;

public interface AccountMapper {
    void save(Account account);

    List<Account> findAll();

    void transOut(String roll_out,double money);

    void transIn(String roll_in,double money);
}
