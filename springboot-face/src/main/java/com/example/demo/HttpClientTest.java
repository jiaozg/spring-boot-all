package com.example.demo;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaozhiguang on 2017/10/13.
 */
public class HttpClientTest {


    public static void main(String[] args) {
        System.out.println("Hello World!");
        CloseableHttpClient httpClient = getHttpClient();
        try {
            HttpPost post = new HttpPost("https://api-cn.faceplusplus.com/cardpp/v1/ocridcard");          //这里用上本机的某个工程做测试
            //创建参数列表
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            list.add(new BasicNameValuePair("api_key", "uY828SsomgDN1uPatYXDmBpu0lPWcThx"));
            list.add(new BasicNameValuePair("api_secret", "0wAhnC5W1tLxtmFj_dM6uPyiZ7J3urL4"));
            list.add(new BasicNameValuePair("image_url", "http://localhost:8080/1.jpg"));
            //url格式编码
            UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(list,"UTF-8");
            post.setEntity(uefEntity);

            System.out.println("POST 请求...." + post.getURI());
            //执行请求
            CloseableHttpResponse httpResponse = httpClient.execute(post);
            try{
                HttpEntity entity = httpResponse.getEntity();
                if (null != entity){
                    System.out.println("-------------------------------------------------------");
                }
            } finally{
                httpResponse.close();
            }
        } catch( UnsupportedEncodingException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try{
                closeHttpClient(httpClient);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }
    private static CloseableHttpClient getHttpClient(){
        return HttpClients.createDefault();
    }
    private static void closeHttpClient(CloseableHttpClient client) throws IOException{
        if (client != null){
            client.close();
        }
    }

}
