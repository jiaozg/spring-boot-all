package com.example.demo;

import com.example.demo.util.ClassScaner;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiaozhiguang on 2017/11/4.
 */

@WebServlet(urlPatterns = {"*.do"},initParams = {@WebInitParam(name="basePackage", value = "com.example.demo")})
public class MyDispatcherServlet extends HttpServlet{

    private Map<String, Object> controllers = new HashMap<>();
    private Map<String, Method> methods = new HashMap<>();

    public MyDispatcherServlet() {
        super();
    }

    public void init(ServletConfig config) {
        String basePackage = config.getInitParameter("basePackage");
        try {
            Map<String, Class<?>> cons = ClassScaner.scanerClass(basePackage);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
