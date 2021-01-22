package com.windeaker.my_spring.annotation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author xiong qiang
 * @Description TODO
 * @Date 2021/1/22
 */
public class MyDispatcherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        InputStream in=null;
        try{
            Properties configContext=new Properties();
            in=this.getClass().getClassLoader().getResourceAsStream(config.getInitParameter(""));
            configContext.load(in);

        } catch (IOException e) {
            e.printStackTrace();
        }
        super.init(config);
    }

    private void doScanner(String scanPackage){

    }
}
