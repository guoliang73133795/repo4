package com.shengfa;

import com.shengfa.Acept.Target;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>Title:AopTest</p>
 * <p>Description:TODO</p>
 *
 * @author 郭亮
 * @date 2020/2/11 14:06
 */
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:aspect.xml")
public class AopTest {
    @Autowired
    private Target target;
    @Test
    public void Test01() {
        target.save ();
    }
}
