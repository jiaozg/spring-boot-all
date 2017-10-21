package com.example.demo.util;

/**
 * Created by jiaozhiguang on 2017/10/13.
 */
public class AsciiUtil {

    public static char ascii2Char(int ASCII) {
        return (char) ASCII;
    }

    public static int char2ASCII(char c) {
        return (int) c;
    }

    public static String ascii2String(String str) {
        StringBuffer sb = new StringBuffer();
        int [] ASCIIs =string2ASCII(str);
        for (int i = 0; i < ASCIIs.length; i++) {
            sb.append((char) ascii2Char(ASCIIs[i]));
        }
        return sb.toString();
    }

    public static int[] string2ASCII(String s) {// 字符串转换为ASCII码
        if (s == null || "".equals(s)) {
            return null;
        }

        char[] chars = s.toCharArray();
        int[] asciiArray = new int[chars.length];

        for (int i = 0; i < chars.length; i++) {
            asciiArray[i] = char2ASCII(chars[i]);
        }
        return asciiArray;
    }

    public static void main(String[] args) {
        String str = "{\"image_id\": \"BEC984lG2NPmWeefZKpLDw==\", \"request_id\": \"1507875749,c560a9d9-5955-47bf-90fd-c7d20a7d0b87\", \"cards\": [{\"name\": \"\\u7126\\u5fd7\\u5e7f\", \"gender\": \"\\u7537\", \"id_card_number\": \"232103198210164819\", \"birthday\": \"1982-10-16\", \"race\": \"\\u6c49\", \"address\": \"\\u9ed1\\u9f99\\u6c5f\\u7701\\u4e94\\u5e38\\u5e02\\u516b\\u5bb6\\u5b50\\u4e61\\u9a6c\\u9e7f\\u6751\\u524d\\u9a6c\\u9e7f\\u4e8c\\u5c6f\", \"type\": 1, \"side\": \"front\"}], \"time_used\": 935}";
        System.out.println(string2ASCII(str));
    }

}
