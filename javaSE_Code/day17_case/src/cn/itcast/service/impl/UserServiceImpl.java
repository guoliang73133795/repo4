package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl ();

    @Override
    public List<User> findAll() {
        return dao.findAll ();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword ( user.getUsername (), user.getPassword () );
    }

    @Override
    public void addData(User user) {
        dao.addData ( user );
    }

    @Override
    public void delete(String id) {
        dao.delete ( id );
    }

    @Override
    public User findUserById(String id) {
        return dao.findUserById ( id );
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser ( user );
    }

    @Override
    public void delSelectedUser(String[] ids) {
        for (String id : ids) {
            dao.delete ( id );
        }
    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt ( _currentPage );
        int rows = Integer.parseInt ( _rows );
        if (currentPage <= 0) {
            currentPage = 1;
        }

//        创建空的PageBean对象
        PageBean<User> pb = new PageBean<> ();
//        设置参数

        pb.setRows ( rows );
//        调用dao查询总记录数
        int totalCount = dao.findTotalCount (condition);
        pb.setTotalCount ( totalCount );
//        调用dao查询list集合
        int start = (currentPage - 1) * rows;
        List<User> list = dao.findByPage ( start, rows,condition );
        pb.setList ( list );
//       计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount / rows : totalCount / rows + 1;
        if (currentPage > totalPage) {
            currentPage = totalPage;
        }
        pb.setCurrentPage ( currentPage );
        pb.setTotalPage ( totalPage );

        return pb;
    }


}
