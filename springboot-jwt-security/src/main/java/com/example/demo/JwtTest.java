package com.example.demo;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.crypto.MacProvider;

import javax.crypto.SecretKey;

/**
 * Created by jiaozhiguang on 2018/1/14.
 * eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjNhIn0.eVmWMqaHnG6nyIz8etXjZkx2yDRb_hR5x88HxKdEUTs
 * eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMjNhIn0.-YfdpEZjP-FqKDo1LzWnChlEr-prJYazQinAETc0VgI
 *
 * header
 * body
 * signature
 */
public class JwtTest {

    private static SecretKey key = MacProvider.generateKey();

//    private staticproxy String key = "jiao";

    private static String info = "test";

    public static void main(String[] args) {

        String claim = encrypt(info);

        System.out.println(claim);

        System.out.println(decrypt(claim));
        System.out.println(getJWS(claim).getHeader());
        System.out.println(getJWS(claim).getBody());
        System.out.println(getJWS(claim).getSignature());

//        System.out.println(decryptError(claim));
    }

    public static String decryptError(String claim) {
        String subject = Jwts.parser().setSigningKey(MacProvider.generateKey()).parseClaimsJws(claim).getBody().getSubject();
        return subject;
    }

    public static String decrypt(String claim) {
        String subject = Jwts.parser().setSigningKey(key).parseClaimsJws(claim).getBody().getSubject();
        return subject;
    }

    public static String encrypt(String subject) {
        String str = Jwts.builder()
                .setSubject(subject)
                .signWith(SignatureAlgorithm.HS256, key).compact();//.signWith(SignatureAlgorithm.HS256, key).compact();
        return str;
    }

    public static String encryptAndGzip(String subject) {
        String str = Jwts.builder()
                .setSubject(subject)
                .compressWith(CompressionCodecs.GZIP)
                .signWith(SignatureAlgorithm.HS256, key).compact();//.signWith(SignatureAlgorithm.HS256, key).compact();
        return str;
    }

    public static Jws<Claims> getJWS(String claim) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(claim);
        return claimsJws;
    }

}
