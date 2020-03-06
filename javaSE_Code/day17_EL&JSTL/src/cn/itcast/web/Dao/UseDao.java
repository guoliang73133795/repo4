package cn.itcast.web.Dao;
import cn.itcast.web.damain.Salgrade;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UseDao {
    private JdbcTemplate template = new JdbcTemplate ( cn.itcast.utils.JdbcUtils.getDataSource () );
    public List<Salgrade> CheckDao(){
        try {
            String sql = "select * from salgrade";
//            Salgrade sal = template.queryForObject ( sql, new BeanPropertyRowMapper<> ( Salgrade.class ));
            List<Salgrade> list = template.query ( sql, new BeanPropertyRowMapper<> ( Salgrade.class ) );

            return list;
        } catch (DataAccessException e) {
            return null;
        }

    }

}
