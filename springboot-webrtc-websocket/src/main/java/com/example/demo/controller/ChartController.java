package com.example.demo.controller;

import com.example.demo.util.SpiderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Map;

/**
 * Created by jiaozhiguang on 2017/11/18.
 */
@Controller
public class ChartController {

    @Autowired
    SpiderUtil spiderUtil;

    @GetMapping("/chart")
    public String chart() {
        return "chart";
    }

    @GetMapping("/map")
    @ResponseBody
    public Map<String, Integer> getMap(String lan) throws IOException {
        String uri  = "http://search.51job.com/list/010000,000000,0000,00,9,${page},${keyword},2,1.html?lang=c&stype=1&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=21&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=";
        uri = uri.replace("${keyword}", lan); System.out.println(uri);
        return spiderUtil.getRange(uri);
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

    @GetMapping("/index")
    String index() {
        return "index";
    }

    @GetMapping("/test")
    String test() {
        return "test";
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
