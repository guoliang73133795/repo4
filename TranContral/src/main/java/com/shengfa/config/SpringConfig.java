package com.shengfa.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * <p>Title:SpringConfig</p>
 * <p>Description:TODO</p>
 *
 * @author 郭亮
 * @date 2020/2/11 18:10
 */

@PropertySource ( "classpath:druid.properties" )
public class SpringConfig {
    @Value ( "${driverClassName}" )
    private String name;
    @Value ( "${url}" )
    private String url;
    @Value ( "${user}" )
    private String username;
    @Value ( "${password}" )
    private String password;
     @Bean("jdbcTemplate")
    public JdbcTemplate getTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate (  );
        DruidDataSource dataSource = new DruidDataSource ();
        dataSource.setDriverClassName ( name );
        dataSource.setUrl ( url );
        dataSource.setUsername ( username );
        dataSource.setPassword ( password );
        jdbcTemplate.setDataSource ( dataSource );
        return jdbcTemplate;
    }
}
