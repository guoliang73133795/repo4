package com.shengfa.dao.impl;

import com.shengfa.config.SpringConfig;
import com.shengfa.dao.TransMoney;
import com.shengfa.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>Title:TransMoneyImpl</p>
 * <p>Description:TODO</p>
 *
 * @author 郭亮
 * @date 2020/2/11 16:35
 */
@Repository("accountDao")
public class TransMoneyImpl implements TransMoney {
    @Autowired
   private JdbcTemplate jdbcTemplate ;
    public void sale() {

        List<Account> list = jdbcTemplate.query ( "select * from account where name = ?", new BeanPropertyRowMapper<Account> ( Account.class ) ,"aaa");
        Float money = list.get ( 0 ).getMoney ();
        this.jdbcTemplate.update ( "UPDATE account SET money = ? where name = ?",money + 100.0,"aaa" );
    }

    public void add() {
        List<Account> list = jdbcTemplate.query ( "select * from account where name = ?", new BeanPropertyRowMapper<Account> ( Account.class ) ,"bbb");
        Float money = list.get ( 0 ).getMoney ();
        jdbcTemplate.update ( "UPDATE account SET money = ? where name = ?",money - 100.0,"bbb" );
    }
}
