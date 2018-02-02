package com.example.demo.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", filterName = "indexFilter")
    public class IndexFilter implements Filter {

        Log log = LogFactory.getLog(IndexFilter.class);

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
            log.info("init IndexFilter");
        }

        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            log.info("doFilter IndexFilter");
            filterChain.doFilter(servletRequest,servletResponse);

        }

        @Override
        public void destroy() {

        }
    }