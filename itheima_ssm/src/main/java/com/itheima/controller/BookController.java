package com.itheima.controller;

import com.itheima.domain.Book;
import com.itheima.service.BookService;
import com.itheima.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    /**
     * 分页查询
     * @param pageNum  当前页，如果没有传参，则默认查询第一页
     * @param pageSize 每页条数，如果没有传参，默认每页显示5条
     * @param categoryId  分类id
     * @return
     */
    @RequestMapping("/findPage")
    public ModelAndView findPage(
            @RequestParam(required = false,defaultValue = "1") Integer pageNum,
            @RequestParam(required = false,defaultValue = "12") Integer pageSize,
            @RequestParam(required = false) Integer categoryId){

        PageBean<Book> pageBean = bookService.findPage(pageNum,pageSize,categoryId);
        System.out.println(pageBean);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageBean", pageBean);
        modelAndView.addObject("categoryId", categoryId);
        modelAndView.setViewName("/book_list.jsp");
//        遍历一下
        for (int i = 0; i < 100; i++) {
            System.out.println (i);
        }
        return modelAndView;
    }
}
