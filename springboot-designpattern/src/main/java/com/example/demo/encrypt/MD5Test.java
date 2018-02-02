package com.example.demo.encrypt;

import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;

/**
 * Created by jiaozhiguang on 2018/1/9.
 */
public class MD5Test {

    public static void main(String[] args) throws Exception {

        String str = "jiao";
        System.out.println(md5(str));

    }

    public static String md5(String str) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("md5");
        byte[] bytes = str.getBytes("UTF-8");
        byte [] md5Byte = md5.digest(bytes);
        StringBuilder hexValue = new StringBuilder();
        for (int i = 0; i < md5Byte.length; i++) {
            int value = (int)md5Byte[i] & 0xff;
            if (value < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(value));
        }
        return hexValue.toString();
    }

    public static void printAlgorithms() throws Exception {
        MessageDigest md = MessageDigest.getInstance("md5");
        Provider[] providers = Security.getProviders();
        for (Provider provider : providers) {
            System.out.println(provider.getName());
            for (Provider.Service service : provider.getServices()) {
                System.out.println(" Type : " + service.getType() + " Algorithm : " + service.getAlgorithm());
            }
        }
    }

}
