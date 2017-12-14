package com.example.demo.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
  
@ControllerAdvice  
public class GlobalDefaultExceptionHandler {

    public static final String EXCEPTION = "exception";


    @ExceptionHandler(value = UserNotExistException.class)
    public String userNotExistExceptionHandler(Model model, Exception e)  {
        model.addAttribute("msg", e.getMessage());
        return EXCEPTION;
    }

    @ExceptionHandler(value = WithoutParamException.class)
    public String withoutParamExceptionHandler(Model model, Exception e)  {
        model.addAttribute("msg", e.getMessage());
        return EXCEPTION;
    }

    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(Model model, Exception e)  {

        //打印异常信息：
        model.addAttribute("msg", e.getMessage());
        e.printStackTrace();
        return EXCEPTION;
    }
}  