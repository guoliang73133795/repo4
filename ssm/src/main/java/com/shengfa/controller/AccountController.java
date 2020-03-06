package com.shengfa.controller;
import com.shengfa.domain.Account;
import com.shengfa.mapper.AccountMapper;
import com.shengfa.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * <p>Title:AccountController</p>
 * <p>Description:TODO</p>
 *
 * @author 郭亮
 * @date 2020/2/21 12:19
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping(value = "/save",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String save(Account account) {
        accountService.save ( account );
        return "保存成功!!!";
    }
//    允许所有的跨域请求,value值是数组,可以传多个值
    @CrossOrigin(value = "*")
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView (  );
        List<Account> accountList = accountService.findAll ();
        modelAndView.addObject ( "accountList",accountList );
        modelAndView.setViewName ( "accountList" );
        return modelAndView;
    }

    @RequestMapping("/trans")
    public String trans(String roll_out,String roll_in,double money){
        accountService.trans (roll_out,roll_in,money);
        return "findAll";
    }

}
