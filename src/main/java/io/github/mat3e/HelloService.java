package io.github.mat3e;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name= "name",urlPatterns = "/api/*")
public class HelloService extends HttpServlet
{
    String param_query = "name";
    String param_lang = "lang";

    HelloServlet servlet;

    public HelloService()
    {
        this(new HelloServlet());
    }

    public HelloService(HelloServlet servlet)
    {
        this.servlet = servlet;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.getWriter().write(servlet.preaperGreetings(req.getParameter(param_query),req.getParameter(param_lang)));
    }
}
