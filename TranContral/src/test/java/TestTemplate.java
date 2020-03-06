import com.shengfa.config.SpringConfig;
import com.shengfa.domain.Account;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * <p>Title:TestTemplate</p>
 * <p>Description:TODO</p>
 *
 * @author 郭亮
 * @date 2020/2/11 18:20
 */
public class TestTemplate {

    @Test
    public void T() {
        ApplicationContext ac = new ClassPathXmlApplicationContext ( "classpath:applicationConfig.xml" );
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ac.getBean ( "jdbcTemplate" );


        List<Account> list = jdbcTemplate.query ( "select * from account where name = ?", new BeanPropertyRowMapper<Account> ( Account.class ) ,"aaa");
        System.out.println (list);
    }
}
