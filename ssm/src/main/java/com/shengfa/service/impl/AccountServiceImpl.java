package com.shengfa.service.impl;

import com.shengfa.domain.Account;
import com.shengfa.mapper.AccountMapper;
import com.shengfa.service.AccountService;
import com.shengfa.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Title:AccountServiceImpl</p>
 * <p>Description:TODO</p>
 *
 * @author 郭亮
 * @date 2020/2/21 12:18
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    public void save(Account account) {
//        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory ().openSession ();
//        AccountMapper mapper = sqlSession.getMapper ( AccountMapper.class );
//        mapper.save ( account );
//        sqlSession.commit ();
//        sqlSession.close ();
        accountMapper.save ( account );
    }

    public List<Account> findAll() {
//        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory ().openSession ();
//        AccountMapper mapper = sqlSession.getMapper ( AccountMapper.class );
//        List<Account> accountList = mapper.findAll ();
        List<Account> accountList = accountMapper.findAll ();
        return accountList;
    }

    public void trans(String roll_out,String roll_in,double money) {
//        SqlSession sqlSession = MybatisUtils.getSqlSessionFactory ().openSession ();
////        AccountMapper mapper = sqlSession.getMapper ( AccountMapper.class );
        accountMapper.transOut (roll_out,money);
        accountMapper.transIn (roll_out,money);

    }
}
