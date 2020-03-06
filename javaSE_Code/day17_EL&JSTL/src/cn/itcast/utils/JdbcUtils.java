package cn.itcast.utils;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.util.Properties;
@SuppressWarnings ( "all" )
public class JdbcUtils {
    private static DataSource ds;

    static {
        try {
            Properties pro = new Properties (  );
            pro.load ( JdbcUtils.class.getClassLoader ().getResourceAsStream ( "druid.properties" ) );
            ds = DruidDataSourceFactory.createDataSource ( pro );
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
    public static DataSource getDataSource(){
        return ds;
    }
}
