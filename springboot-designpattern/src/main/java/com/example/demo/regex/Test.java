package com.example.demo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jiaozhiguang on 2017/11/14.
 */
public class Test {

    public static void main(String[] args) {


        String regex = "\\b(select|insert|update|delete)\\b";
        Pattern pattern = Pattern.compile(regex);
        String str = "select * from table";
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()){
            System.out.println(str);
            System.out.println("find "+matcher.group()
                    +" position: "+matcher.start()+"-"+matcher.end());
        }

    }

}
