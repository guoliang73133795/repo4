package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.utils.JdbcUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
@SuppressWarnings ( "all" )
public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate ( JdbcUtils.getDataSource () );

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = template.query ( sql, new BeanPropertyRowMapper<> ( User.class ) );
        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject ( sql, new BeanPropertyRowMapper<User> ( User.class ), username, password );
            return user;
        } catch (Exception e) {
            e.printStackTrace ();
            return null;
        }

    }

    @Override
    public void addData(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        template.update ( sql, user.getName (), user.getGender (), user.getAge (), user.getAddress (), user.getQq (), user.getEmail () );
    }

    @Override
    public void delete(String id) {
        String sql = "delete from user where id=?";
        template.update ( sql, id );
    }

    @Override
    public User findUserById(String id) {
        String sql = "select * from user where id =?";
        User user = template.queryForObject ( sql, new BeanPropertyRowMapper<> ( User.class ), id );
        return user;
    }

    @Override
    public void updateUser(User user) {
        String sql = "update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id =?";
        template.update ( sql, user.getName (), user.getGender (), user.getAge (), user.getAddress (), user.getQq (), user.getEmail (), user.getId () );

    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
//        定义模板初始化sql
        String sql = "select count(*) from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder ( sql );
//      遍历map
        Set<String> keys = condition.keySet ();
//        定义参数的集合
        List<Object> params = new ArrayList<> ();
        for (String key : keys) {
            if ("currentPage".equals ( key ) || "rows".equals ( key )) {
                continue;
            }
            String value = condition.get ( key )[0];
            if (value != null && "".equals ( value )) {
                sb.append ( "and " + key + " like ? " );
                params.add ( "%" + value + "%" );
            }
        }
        return template.queryForObject ( sb.toString (), Integer.class, params.toArray () );
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder ( sql );
        Set<String> keys = condition.keySet ();
//        定义参数的集合
        List<Object> params = new ArrayList<> ();
        for (String key : keys) {
            if ("currentPage".equals ( key ) || "rows".equals ( key )) {
                continue;
            }
            String value = condition.get ( key )[0];
            if (value != null && !"".equals ( value )) {
                sb.append ( "and " + key + " like ? " );
                params.add ( "%" + value + "%" );
            }
        }
        sb.append ( " limit ?,? " );
        params.add ( start );
        params.add ( rows );
        sql = sb.toString ();
        return template.query ( sql, new BeanPropertyRowMapper<User> ( User.class ),params.toArray () );
    }
}

