package com.example.demo.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
    public class IndexListener implements ServletContextListener {
        private Log log = LogFactory.getLog(IndexListener.class);

        @Override
        public void contextInitialized(ServletContextEvent servletContextEvent) {
            log.info("IndexListener contextInitialized");
        }

        @Override
        public void contextDestroyed(ServletContextEvent servletContextEvent) {

        }
    }