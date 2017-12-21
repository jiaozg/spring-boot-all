package com.example.demo.controller;

import com.example.demo.util.SpiderUtil;
import com.example.demo.util.ValidateCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by jiaozhiguang on 2017/11/18.
 */
@Controller
public class ChartController {



    @GetMapping("/gaode")
    public String gaode() {
        return "gaode";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/chart")
    public String chart() {
        return "chart";
    }

    @GetMapping("/map")
    @ResponseBody
    public Map<String, Integer> getMap(String lan) throws IOException {
        String uri  = "http://search.51job.com/list/010000,000000,0000,00,9,${page},${keyword},2,1.html?lang=c&stype=1&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=21&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=";
        uri = uri.replace("${keyword}", lan); System.out.println(uri);
        return SpiderUtil.getRange(uri);
    }



    @RequestMapping("/toValidateCode")
    @ResponseBody
    public void toValidateCode(HttpServletResponse response, HttpSession session)throws Exception{
        ValidateCode vCode = new ValidateCode(160,40,5,150);
        // 设置响应的类型格式为图片格式
        response.setContentType("image/jpeg");
        //禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        vCode.write(response.getOutputStream());
        System.out.println(vCode.getCode().toString());
        session.setAttribute("code",vCode.getCode().toString());
    }

    @RequestMapping("yzCode")
    @ResponseBody
    public String yzCode(String code,HttpSession session){
        String codel = (String)session.getAttribute("code");
        if(code.equalsIgnoreCase(codel)){
            System.out.println("验证成功");
            return "1";
        }
        System.out.println("验证失败");
        return "0";
    }

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World! 8081";
    }
    @GetMapping("/show")
    String show() {
        return "show";
    }

    @GetMapping("/validcode")
    String validcode() {
        return "validcode";
    }

    @GetMapping("/index")
    String index() {
        return "index";
    }

    @GetMapping("/client")
    String test() {
        return "client";
    }

    @GetMapping("/xiu")
    String xiu() {
        return "xiu";
    }

    @GetMapping("/live")
    String live() {
        return "live";
    }

    @GetMapping("/ball")
    String ball() {
        return "ball";
    }

    @GetMapping("/shoot")
    String shoot() {
        return "shoot";
    }

    @GetMapping("/snake")
    String snake() {
        return "snake";
    }

    @GetMapping("/kefu")
    String kefu() {
        return "kefu";
    }

}
