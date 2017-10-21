package com.example.demo.demo;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;

/**
 * Created by jiaozhiguang on 2017/10/13.
 */
public class ClientCustomSSL {

    private static String reqStr = "txnType=00&signMethod=01&certId=68759663125&encoding=UTF-8&merId=777290058110048&bizType=000201&txnSubType=00&signature=k0lrWgeLK%2Fx%2B8ajj15QCYfmdQxZSKBjXUJN0bLt17rp87ptogxWgHAAq7EUt8RlEbxD6GaRngwtdLGiy6are45Gj1dBLJBtW2841WIq4Ywzx3oK6538Kfh9ll91GJcZJGYz8LuJoZfii7HFPlpl1ZsPZbbdKP6WFVHNMnGnL9nk9QSa%2BihXGpyK%2Fy1FA42AJpfc%2FTT3BV6C%2FxpoEhXzVckHnniVnCpLdGnPfZOd76wK%2Fa%2BALNmniwUZmMj9uNPwnONIIwL%2FFqrqQinQArolW%2FrcIt9NL7qKvQujM%2BdRvd1fboAHI5bZC3ktVPB0s5QFfsRhSRFghVi4RHOzL8ZG%2FVQ%3D%3D&orderId=20160309145206&version=5.0.0&txnTime=20160309145206&accessType=0";
    private static String url = "https://101.231.204.80:5000/gateway/api/queryTrans.do";

    // 信任管理器
    private static X509TrustManager tm = new X509TrustManager() {
        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    };

    public final static void main(String[] args) throws Exception {
        long starttime = System.currentTimeMillis();
        SSLContext sslContext = SSLContext.getInstance("TLS");
        // 初始化SSL上下文
        sslContext.init(null, new TrustManager[] { tm }, null);
        // SSL套接字连接工厂,NoopHostnameVerifier为信任所有服务器
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
        /**
         * 通过setSSLSocketFactory(sslsf)保证httpclient实例能发送Https请求
         */
        CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).setMaxConnTotal(50)
                .setMaxConnPerRoute(50).setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectionRequestTimeout(60000).setConnectTimeout(60000).setSocketTimeout(60000).build())
                .build();
        try {

            HttpPost httppost = new HttpPost(url);

            // 设置参数，参数含义不需要理解
            Map<String, String> map = new HashMap<String, String>();
            map.put("txnType","00");
            map.put("signMethod","01");
            map.put("certId","68759663125");
            map.put("encoding","UTF-8");
            map.put("merId","777290058110048");
            map.put("bizType","000201");
            map.put("txnSubType","00");
            map.put("signature","k0lrWgeLK%2Fx%2B8ajj15QCYfmdQxZSKBjXUJN0bLt17rp87ptogxWgHAAq7EUt8RlEbxD6GaRngwtdLGiy6are45Gj1dBLJBtW2841WIq4Ywzx3oK6538Kfh9ll91GJcZJGYz8LuJoZfii7HFPlpl1ZsPZbbdKP6WFVHNMnGnL9nk9QSa%2BihXGpyK%2Fy1FA42AJpfc%2FTT3BV6C%2FxpoEhXzVckHnniVnCpLdGnPfZOd76wK%2Fa%2BALNmniwUZmMj9uNPwnONIIwL%2FFqrqQinQArolW%2FrcIt9NL7qKvQujM%2BdRvd1fboAHI5bZC3ktVPB0s5QFfsRhSRFghVi4RHOzL8ZG%2FVQ%3D%3D");
            map.put("orderId","20160309145206");
            map.put("version","5.0.0");
            map.put("txnTime","20160309145206");
            map.put("accessType","0");

            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> elem = (Map.Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
            }
            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "UTF-8");
                httppost.setEntity(entity);
            }

            System.out.println("executing request " + httppost.getRequestLine());

            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();

                System.out.println("----------------------------------------");
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    System.out.println("Response content length: " + entity.getContentLength());
                }
                String s = EntityUtils.toString(entity,"UTF-8");
                System.out.println("应答内容：" + s);

                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }

        long endtime = System.currentTimeMillis();
        System.out.println("耗时:" + (endtime-starttime) + "ms");
    }



}
