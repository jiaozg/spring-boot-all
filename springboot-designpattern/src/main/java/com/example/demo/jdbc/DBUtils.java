package com.example.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

/**
 * Created by jiaozhiguang on 2017/12/25.
 */
public class DBUtils {

    private static String driver;
    private static String url;
    private static String user;
    private static String pwd;

    private static Connection conn;

    static {
        ResourceBundle rb = ResourceBundle.getBundle("db");
        driver = rb.getString("driver");
        url = rb.getString("url");
        user = rb.getString("user");
        pwd = rb.getString("pwd");

    }

    public static Connection getConn()  {

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(DBUtils.getConn());
    }

}
