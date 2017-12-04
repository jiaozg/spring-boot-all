package com.example.demo.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jiaozhiguang on 2017/10/31.
 * 爬虫 根据业务需求 抓取特定的
 */
public class SpiderUtil {

    public static void main(String[] args) throws IOException {
        String uri  = "http://search.51job.com/list/010000,000000,0000,00,9,${page},${keyword},2,1.html?lang=c&stype=1&postchannel=0000&workyear=99&cotype=99&degreefrom=99&jobterm=99&companysize=99&lonlat=0%2C0&radius=-1&ord_field=0&confirmdate=9&fromType=21&dibiaoid=0&address=&line=&specialarea=00&from=&welfare=";
        uri = uri.replace("${keyword}", "java"); System.out.println(uri);
        Map<String, Integer> results1 = getRange(uri);System.out.println(results1);

//        uri = uri.replace("${keyword}", "python");
//        Map<String, Integer> results3 = getRange(uri);System.out.println(results3);
//        uri = uri.replace("${keyword}", "ruby");
//        Map<String, Integer> results4 = getRange(uri);System.out.println(results4 );
    }




    public static String getHtml(String uri, String encoding) throws IOException {
        URL url = new URL(uri);

        URLConnection conn = url.openConnection();

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "GBK"));

        StringBuilder html = new StringBuilder();

        String tmp = "";

        while ( (tmp = reader.readLine()) != null) {
            html.append(tmp);
        }

        reader.close();
        return html.toString();
    }

    public static Map<String, Integer> getRange(String url) throws IOException {
        Map<String, Integer> results = new LinkedHashMap<>();
        for (int i = 1; i <= 12; i++) {
            String tempUrl = "";
            if (i > 9) {
                //10 11
                tempUrl = url.replace("${page}", i+"");
            } else {
                tempUrl = url.replace("${page}", "0" + i);
            }

            String html = getHtml(tempUrl, "gbk");

            Document document = Jsoup.parse(html.toString());
            Elements elements = document.getElementsByClass("rt");
            String  str = elements.get(0).text();

            Pattern pattern = Pattern.compile("[^0-9]");
            Matcher mathcer = pattern.matcher(str);
            String num = mathcer.replaceAll("").trim();

            String type = document.getElementsByClass("dw_c_orange").get(0).text();
//            System.out.println(type +" " +  num +"条岗位");
            results.put(type, Integer.valueOf(num));
        }

        return results;
    }



}
