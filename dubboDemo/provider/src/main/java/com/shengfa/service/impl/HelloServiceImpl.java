package com.shengfa.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.shengfa.service.HelloService;

/**
 * <p>Title:HelloServiceImpl</p>
 * <p>Description:TODO</p>
 *
 * @author 郭亮
 * @date 2020/3/3 17:06
 */
@Service//发布为服务
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        return "hello "+name;
    }
}
