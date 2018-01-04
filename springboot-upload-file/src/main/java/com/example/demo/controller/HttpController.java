package com.example.demo.controller;

import com.example.demo.util.HttpClientUtil;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaozhiguang on 2018/1/4.
 */
@Controller
public class HttpController {


    @GetMapping("/test")
    @ResponseBody
    public String face() throws Exception {

        String url = "https://www.agoda.com/api/zh-cn/Main/GetSearchResultList";

        File file = new File("/Users/jiaozhiguang/baweiwork/springboot/spring-boot-all/springboot-upload-file/src/main/resources/param.txt");

        FileReader fr = new FileReader(file);

        BufferedReader bufferedReader = new BufferedReader(fr);

        List<NameValuePair> params = new ArrayList<>();

        String line = null;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
            System.out.println(line.split(":")[0]);

            String [] parameters = line.split(":");
            if (parameters.length == 2) {
                params.add(new BasicNameValuePair(parameters[0], parameters[1]));
            }
        }

        return HttpClientUtil.post(url, params);

    }


}
