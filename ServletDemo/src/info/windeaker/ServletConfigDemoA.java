package info.windeaker;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/servlet-config-demo-a",name = "ServletConfigDemoA",initParams = {@WebInitParam(name
="charset",value = "UTF-8"),@WebInitParam(name = "name",value = "ServletConfigDemoA"),@WebInitParam(name = "password",value = "1234567890")})
public class ServletConfigDemoA extends HttpServlet {
    ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
        this.servletConfig=servletConfig;
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //获取在web.xml中配置的初始化参数
        String paramVal = this.servletConfig.getInitParameter("name");//获取指定的初始化参数
        response.getWriter().print(paramVal);

        response.getWriter().print("<hr/>");
        //获取所有的初始化参数
        Enumeration<String> e = servletConfig.getInitParameterNames();
        while(e.hasMoreElements()){
            String name = e.nextElement();
            String value = servletConfig.getInitParameter(name);
            response.getWriter().print(name + "=" + value + "<br/>");
        }
    }
}
