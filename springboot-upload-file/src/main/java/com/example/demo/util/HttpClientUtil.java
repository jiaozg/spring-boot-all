package com.example.demo.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

/**
 * Created by jiaozhiguang on 2017/10/13.
 */
public class HttpClientUtil {

    public static String post(String url, List<NameValuePair> params ) {

        // 使用默认配置创建httpclient的实例
        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost post = new HttpPost(url);

        /**
         * 设置参数，常用的有StringEntity,UrlEncodedFormEntity,MultipartEntity
         * 具体看org.apache.http.entity包
         */

        try {
            UrlEncodedFormEntity e = new UrlEncodedFormEntity(params, "UTF-8");
            post.setEntity(e);

            CloseableHttpResponse response = client.execute(post);

            // 服务器返回码
            int status_code = response.getStatusLine().getStatusCode();
            System.out.println(status_code);

            // 服务器返回内容
            String respStr = null;
            HttpEntity entity = response.getEntity();

            if(entity != null) {
                respStr = EntityUtils.toString(entity, "UTF-8");
            }
            System.out.println("respStr = " + respStr);
            // 释放资源

            EntityUtils.consume(entity);

            return respStr;
        } catch (IOException e1) {
            e1.printStackTrace();
        }


        return null;
    }

}
