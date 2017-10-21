package com.example.demo.demo;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaozhiguang on 2017/10/13.
 */
public class RequestParameterDemo {

    public static void main(String[] args) {
        try {
            String url = "https://api-cn.faceplusplus.com/cardpp/v1/ocridcard";
            // 使用默认配置创建httpclient的实例
            CloseableHttpClient client = HttpClients.createDefault();

            HttpPost post = new HttpPost(url);

            /**
             * 设置参数，常用的有StringEntity,UrlEncodedFormEntity,MultipartEntity
             * 具体看org.apache.http.entity包
             */
            List<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("api_key", "uY828SsomgDN1uPatYXDmBpu0lPWcThx"));
            params.add(new BasicNameValuePair("api_secret", "0wAhnC5W1tLxtmFj_dM6uPyiZ7J3urL4"));
            params.add(new BasicNameValuePair("image_url", "https://thumbnail0.baidupcs.com/thumbnail/a7bed4fedd60bd659193511d0bd772f7?fid=1430534537-250528-815664779642130&time=1507870800&rt=sh&sign=FDTAER-DCb740ccc5511e5e8fedcff06b081203-obh9g0kmGS4DbqV6qDMw2bt7HBM%3D&expires=8h&chkv=0&chkbd=0&chkpc=&dp-logid=6623453428403123212&dp-callid=0&size=c710_u400&quality=100&vuk=-&ft=video"));
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
//                respStr = EntityUtils.toString(entity, "UTF-8");
                respStr = EntityUtils.toString(entity);
            }
            System.out.println("respStr = " + respStr);
            // 释放资源
            EntityUtils.consume(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
