package com.itheima.service;

import com.itheima.domain.Book;
import com.itheima.utils.PageBean;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface BookService {
    PageBean<Book> findPage(Integer pageNum, Integer pageSize, Integer categoryId);

}
