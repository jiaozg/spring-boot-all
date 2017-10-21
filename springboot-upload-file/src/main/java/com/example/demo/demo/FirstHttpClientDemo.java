package com.example.demo.demo;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Created by jiaozhiguang on 2017/10/13.
 */
public class FirstHttpClientDemo {

    public static void main(String[] args) {
        try {
            String url = "http://www.baidu.com";
            // 使用默认配置创建httpclient的实例
            CloseableHttpClient client = HttpClients.createDefault();

            HttpPost post = new HttpPost(url);
//            HttpGet get = new HttpGet(url);

            CloseableHttpResponse response = client.execute(post);
//            CloseableHttpResponse response = client.execute(get);

            // 服务器返回码
            int status_code = response.getStatusLine().getStatusCode();
            System.out.println("status_code = " + status_code);

            // 服务器返回内容
            String respStr = null;
            HttpEntity entity = response.getEntity();
            if(entity != null) {
                respStr = EntityUtils.toString(entity, "UTF-8");
            }
            System.out.println("respStr = " + respStr);
            // 释放资源
            EntityUtils.consume(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
