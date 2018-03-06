package com.example.demo.controller;

import com.example.demo.annotation.Token;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jiaozhiguang on 2018/2/11.
 *
 访问 http://localhost:8088/savetoken 来获得令牌值
 访问 http://localhost:8088/removetoken?token=XXX 来提交真正的表单
 */
@Controller
public class TokenController {

    @Token(save = true)
    @RequestMapping("/savetoken")
    @ResponseBody
    public String getToken(HttpServletRequest request, HttpServletResponse response){
        return (String) request.getSession().getAttribute("token");
    }


    @Token(remove = true)
    @RequestMapping("/removetoken")
    @ResponseBody
    public String removeToken(HttpServletRequest request, HttpServletResponse response){
        return "success";
    }

}
