package com.shengfa.web;
import com.shengfa.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * <p>Title:UserServlet</p>
 * <p>Description:TODO</p>
 *
 * @author 郭亮
 * @date 2020/2/12 17:03
 */
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        ServletContext servletContext = req.getServletContext ();
        ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext ( servletContext );
        UserService userService = ac.getBean ( UserService.class );
        userService.save ();
    }
}
