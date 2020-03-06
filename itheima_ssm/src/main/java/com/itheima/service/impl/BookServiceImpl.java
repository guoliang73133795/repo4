package com.itheima.service.impl;

import com.itheima.domain.Book;
import com.itheima.mapper.BookMapper;
import com.itheima.service.BookService;
import com.itheima.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookMapper bookMapper;

    @Override
    public PageBean<Book> findPage(Integer pageNum, Integer pageSize,Integer categoryId) {
        //创建PageBean对象
        PageBean<Book> pageBean = new PageBean<>();
        //private  Integer pageNum;  当前页
        pageBean.setPageNum( pageNum);
        //private Integer pageSize; 每页条数
        pageBean.setPageSize(pageSize);
        //private Integer total; 总条数
        Integer total = bookMapper.findTotalCount(categoryId);
        pageBean.setTotal(total);
        //private Integer pages;  总页数
        pageBean.setPages((int)Math.ceil(total * 1.0 / pageSize));
        //private List<T> data;  要显示的数据
        //要查询的数据的起始索引
        Integer startIndex = (pageNum - 1) * pageSize;
        //获取数据
        List<Book> bookList = bookMapper.getData(startIndex, pageSize,categoryId);

        pageBean.setData(bookList);
        return pageBean;
    }
}
