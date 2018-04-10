package com.example.demo.encrypt;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DESUtil {


  
    private static final String TAG = "TAG";  
  
    /** 
     * 生成密钥 
     */  
    public static byte[] initKey() {  
        try {  
            //KeyGenerator 密钥生成器  
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            //初始化密钥生成器  
            keyGenerator.init(56);  
            //生成密钥  
            SecretKey secretKey = keyGenerator.generateKey();
            return secretKey.getEncoded();  
        } catch (Exception e) {  
        }
        return null;  
    }  
  
    /** 
     * DES加密 
     * 
     * @param data 需要加密的数据 
     * @param key  加密使用的密钥 
     * @return 加密后获取的字节数组 
     */  
    public static byte[] encrypt(byte[] data, byte[] key) {  
        //恢复密钥  
        SecretKey secretKey = new SecretKeySpec(key, "DES");
        try {  
            //Cipher完成加密或解密工作  
            Cipher cipher = Cipher.getInstance("DES");
            //根据密钥对Cipher进行初始化 ENCRYPT_MODE, DECRYPT_MODE  
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);  
            //加密  
            return cipher.doFinal(data);  
        } catch (Exception e) {  
        }
        return null;  
    }  
  
    /** 
     * DES解密 
     */  
    /** 
     * @param data 密文对应的字节数组 
     * @param key  算法名字 
     * @return 解密后的字节数组 
     */  
    public static byte[] decrypt(byte[] data, byte[] key) {  
        SecretKey secretKey = new SecretKeySpec(key, "DES");  
        try {  
            Cipher cipher = Cipher.getInstance("DES");  
            cipher.init(Cipher.DECRYPT_MODE, secretKey);  
            return cipher.doFinal(data);  
       } catch (Exception e) {
        }
        return null;  
    }


    public static void main(String[] args) {
        System.out.println(initKey());
    }
}  