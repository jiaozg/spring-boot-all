package com.example.demo.jdbc;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

/**
 * Created by jiaozhiguang on 2017/12/25.
 */
public class GenareateEntityUtil {

    private static String [] fieldNames;
    private static String [] fieldTypes;

    static Connection conn = DBUtils.getConn();

    public static void getEntity(String packagePath, String tableName) throws Exception {

        String sql = "select * from " + tableName;
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSetMetaData rsmd = ps.getMetaData();
//        System.out.println(rsmd);

        int size = rsmd.getColumnCount();
        fieldNames = new String[size];
        fieldTypes = new String[size];
        for (int i = 0; i < size; i++) {
            fieldNames[i] = rsmd.getColumnName(i+1);
//            System.out.println(fieldNames[i]);
            fieldTypes[i] = rsmd.getColumnTypeName(i + 1);
//            System.out.println(fieldTypes[i]);
        }
        String path = System.getProperty("user.dir") + "/springboot-designpattern/src" + packagePath;
        System.out.println(path);
        File dir = new File(path);
        if (! dir.exists()) {
            dir.mkdirs();
        }



    }

    public static void main(String[] args) throws Exception {
        GenareateEntityUtil.getEntity(null,"users");
    }

}
