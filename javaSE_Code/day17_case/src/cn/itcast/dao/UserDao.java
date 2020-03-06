package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> findAll();
    User findUserByUsernameAndPassword(String username, String password);
    void addData(User user);
    void delete(String id);
    User findUserById(String id);

    void updateUser(User user);

    int findTotalCount(Map<String, String[]> condition);

    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
