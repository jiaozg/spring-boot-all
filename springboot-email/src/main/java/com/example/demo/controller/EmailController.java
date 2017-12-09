package com.example.demo.controller;

import com.example.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * @author jiao
 * Created by jiaozhiguang on 2017/12/7.
 */
@RestController
public class EmailController {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @GetMapping("/send")
    public boolean send(String id) {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", id);
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("jiaozhiguang@126.com","主题：这是模板邮件",emailContent);
        return true;
    }

    @GetMapping("/receive/{user}")
    public String receive(@PathVariable(value = "user") String user) {
        return user + "激活成功";
    }


}
