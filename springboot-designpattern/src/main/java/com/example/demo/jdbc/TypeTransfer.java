package com.example.demo.jdbc;

/**
 * Created by jiaozhiguang on 2017/12/25.
 */
public class TypeTransfer {

    public static String tranTableName(String tableName) {

        String [] strs = tableName.split("_");
        StringBuilder sb = new StringBuilder();
        sb.append(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            sb.append(initCap(strs[i]));
        }
        return sb.toString();
    }

    public static String initCap(String name) {
        char [] ch = name.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char)(ch[0] - 32);
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        System.out.println(tranTableName("sys_area"));
    }




    public static String toJavaType(String sqlType) {
        if ("tinyint".equalsIgnoreCase(sqlType)) {
            return "byte";
        } else if ("smallint".equalsIgnoreCase(sqlType)) {
            return "short";
        }else if ("int".equalsIgnoreCase(sqlType) || "integer".equalsIgnoreCase(sqlType)) {
            return "int";
        }else if ("bigint".equalsIgnoreCase(sqlType)) {
            return "long";
        }else if ("float".equalsIgnoreCase(sqlType)) {
            return "float";
        }else if ("decimal".equalsIgnoreCase(sqlType) ||
                "numeric".equalsIgnoreCase(sqlType) ||
                "real".equalsIgnoreCase(sqlType) ||
                "money".equalsIgnoreCase(sqlType) ||
                "smallmoney".equalsIgnoreCase(sqlType) ||
                "double".equalsIgnoreCase(sqlType) ) {
            return "Double";
        }else if ("varchar".equalsIgnoreCase(sqlType) ||
                "char".equalsIgnoreCase(sqlType) ||
                "nvarchar".equalsIgnoreCase(sqlType) ||
                "nchar".equalsIgnoreCase(sqlType) ) {
            return "String";
        }else if ("datetime".equalsIgnoreCase(sqlType) ||
                "date".equalsIgnoreCase(sqlType) ||
                "time".equalsIgnoreCase(sqlType) ||
                "timestamp".equalsIgnoreCase(sqlType)) {
            return "Date";
        }else if ("image".equalsIgnoreCase(sqlType)) {
            return "Blob";
        }else if ("text".equalsIgnoreCase(sqlType) ) {
            return "Clob";
        }
        return "Object";
    }

}
