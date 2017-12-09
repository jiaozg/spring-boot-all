package com.example.demo.web;

import com.example.demo.exception.UserNotExistException;
import com.example.demo.exception.WithoutParamException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiaozhiguang on 2017/12/7.
 */
@RestController
public class ExceptionController {

    @RequestMapping("/zeroException")
    public void zeroException(){
        int i = 1024/0;
    }

    @RequestMapping(value="/exception")
    public void exception() {
        throw new WithoutParamException("id不能为空");
    }

    @RequestMapping(value="/user/exception")
    public void userExcp() {
        throw new UserNotExistException("用户不存在");
    }

}
