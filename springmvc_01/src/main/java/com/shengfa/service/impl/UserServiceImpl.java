package com.shengfa.service.impl;

import com.shengfa.dao.UserDao;
import com.shengfa.service.UserService;

/**
 * <p>Title:UserServiceImpl</p>
 * <p>Description:TODO</p>
 *
 * @author 郭亮
 * @date 2020/2/12 16:02
 */
public class UserServiceImpl implements UserService {
    private UserDao dao;
    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    public void save() {
            dao.save();
    }
}
