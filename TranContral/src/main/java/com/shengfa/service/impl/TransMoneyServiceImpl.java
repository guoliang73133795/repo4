package com.shengfa.service.impl;
import com.shengfa.dao.TransMoney;
import com.shengfa.dao.impl.TransMoneyImpl;
import com.shengfa.service.TransMoneyService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>Title:TransMoneyServiceImpl</p>
 * <p>Description:TODO</p>
 *
 * @author 郭亮
 * @date 2020/2/11 17:09
 */
@Service("accountService")
public class TransMoneyServiceImpl implements TransMoneyService {
    @Autowired
   private TransMoney dao ;
//    @Pointcut(value = "execution(* com.shengfa.service.impl.*.*(..))")
//    @Transactional()
    @Transactional()
    public void Trans() {
        dao.sale ();
        int a =1/0;
        dao.add ();
    }
}
