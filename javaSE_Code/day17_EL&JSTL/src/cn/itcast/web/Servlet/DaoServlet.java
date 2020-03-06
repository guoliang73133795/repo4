package cn.itcast.web.Servlet;
import cn.itcast.web.Dao.UseDao;
import cn.itcast.web.damain.Salgrade;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/DaoServlet")
public class DaoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding ( "utf-8" );

        UseDao useDao = new UseDao ();
        List<Salgrade> salgrade = useDao.CheckDao ();
        System.out.println (salgrade);
        if(salgrade!=null){
        request.setAttribute ( "salgrade",salgrade );
        request.getRequestDispatcher ( "/index.jsp" ).forward ( request,response );
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost ( request, response );
    }
}
