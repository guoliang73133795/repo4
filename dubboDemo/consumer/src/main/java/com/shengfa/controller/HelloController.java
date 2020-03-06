package com.shengfa.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.shengfa.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>Title:HelloController</p>
 * <p>Description:TODO</p>
 *
 * @author 郭亮
 * @date 2020/3/3 17:45
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
    @Reference
    private HelloService helloService;

    @RequestMapping("/say")
    @ResponseBody
    public String sayHello(String name){
        return helloService.sayHello ( name );
    }
}
