package com.itheima.mapper;

import com.itheima.domain.Book;

import java.util.List;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface BookMapper {
    Integer findTotalCount(Integer categoryId);

    List<Book> getData(Integer startIndex, Integer pageSize, Integer categoryId);
}
