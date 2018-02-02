package com.example.demo.filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "IndexServlet",urlPatterns = "/servlet")
    public class IndexServlet extends HttpServlet {
        @Override
        public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.getWriter().print("hello word");
            resp.getWriter().flush();
            resp.getWriter().close();
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doGet(req, resp);
        }
    }