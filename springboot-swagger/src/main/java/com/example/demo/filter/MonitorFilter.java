package com.example.demo.filter;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by jiaozhiguang on 2018/1/12.
 */
public class MonitorFilter implements Filter {

    private ServletContext sc;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(sc);

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        System.out.println(" this is MyFilter , url =  "+request.getRequestURL());
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
