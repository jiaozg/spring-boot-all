package com.example.demo.demo;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Created by jiaozhiguang on 2017/10/13.
 */
public class RequestConfigDemo {


    public static void main(String[] args) {
        try {
            String url = "http://www.baidu.com";
            /**
             *  请求参数配置
             *  connectionRequestTimeout:
             *                          从连接池中获取连接的超时时间，超过该时间未拿到可用连接，
             *                          会抛出org.apache.http.conn.ConnectionPoolTimeoutException: Timeout waiting for connection from pool
             *  connectTimeout:
             *                  连接上服务器(握手成功)的时间，超出该时间抛出connect timeout
             *  socketTimeout:
             *                  服务器返回数据(response)的时间，超过该时间抛出read timeout
             */
            CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(RequestConfig.custom()
                    .setConnectionRequestTimeout(2000).setConnectTimeout(2000).setSocketTimeout(2000).build()).build();

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
