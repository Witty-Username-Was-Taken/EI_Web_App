package edu.uga.cs.ei.finalwebapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("In Servlet!!!");
        String q = req.getParameter("query");
        System.out.println("Query is: " + q);
        //String html = NewsFinder.getArticles(req.getParameter("query"));

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        //out.println("<html><body><h1>Hello World</h1></body></html>");
        //out.println(html);

    }
}
