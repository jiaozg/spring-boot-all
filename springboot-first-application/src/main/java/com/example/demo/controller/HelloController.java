package com.example.demo.controller;

import com.example.demo.bean.Chapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Pattern;

/**
 * Created by jiaozhiguang on 2017/8/19.
 */
@RestController
public class HelloController {

    @GetMapping("/mq")
    public String mq() {
        return "mq";
    }

    @RequestMapping("/")
    public String index() {
        String pathname = "/Users/jiaozhiguang/baweiwork/springboot/spring-boot-all/springboot-first-application/a.txt";
        File file = new File(pathname);
        txt2String(file);

        return "Greetings from Spring Boot!";

    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//
//            System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//            String[] beanNames = ctx.getBeanDefinitionNames();
//            Arrays.sort(beanNames);
//            for (String beanName : beanNames) {
//                System.out.println(beanName);
//            }
//
//        };
//    }

    private String txt2String(File file){

        boolean contentStart = false;
        Chapter chapter = new Chapter();
        String pattern = "第.*.章.*";
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                boolean isMatch = Pattern.matches(pattern, s);

                if(isMatch){
                    chapter.setContent(result.toString());
                    result.delete(0, result.length());
                    System.out.println("name:"+chapter.getName() + " content:"+chapter.getContent());

                    chapter = new Chapter(s);


                    contentStart = true;
                }else {
                    if(contentStart) {
                        result.append(System.lineSeparator()+s);
                    }
                }


            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }

}
