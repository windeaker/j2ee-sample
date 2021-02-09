package info.windeaker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/ServletWRSDemo",name = "ServletWRSDemo")
public class ServletWRSDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String testParam=request.getParameter("testParam");
        System.out.println(testParam);
        PrintWriter printWriter=response.getWriter();
        printWriter.print("llalal--->"+testParam);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String testParam=request.getParameter("testParam");
        System.out.println(testParam);
        PrintWriter printWriter=response.getWriter();
        printWriter.print("llalal--->"+testParam);
    }
}
