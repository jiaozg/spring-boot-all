package com.example.demo.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
  
@ControllerAdvice  
public class GlobalDefaultExceptionHandler {



    @ExceptionHandler(value = WithoutParamException.class)
    public String withoutParamExceptionHandler(Model model, Exception e)  {
        model.addAttribute("msg", e.getMessage());
        return "withoutParam";
    }

    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(HttpServletRequest req, Exception e)  {

        //打印异常信息：
        e.printStackTrace();
        System.out.println("GlobalDefaultExceptionHandler.defaultErrorHandler()");
        return "zero";
    }
}  