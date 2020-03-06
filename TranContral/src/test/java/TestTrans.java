import com.shengfa.config.SpringConfig;
import com.shengfa.service.TransMoneyService;
import com.shengfa.service.impl.TransMoneyServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>Title:TestTrans</p>
 * <p>Description:TODO</p>
 *
 * @author 郭亮
 * @date 2020/2/11 17:12
 */
//@RunWith (SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationConfig.xml")

public class TestTrans {

    @Test
    public void Tran() {
        ApplicationContext ac = new ClassPathXmlApplicationContext ( "classpath:applicationConfig.xml" );
//        service层事务代理了  用接口去接收就不会报错 或者注解里面配置AOP动态代理
        TransMoneyService tranService = ac.getBean ( "accountService",TransMoneyService.class );
//        TransMoneyService tranService = new TransMoneyServiceImpl ();
//        TransMoneyService tranService;
        tranService.Trans ();
    }
}
