package com.example.demo.annotation;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by jiaozhiguang on 2017/9/28.
 *
 * 应用注解 - 定制序列化
 定义注解
 上节我们演示了一个简单的通用序列化类SimpleMapper，在将对象转换为字符串时，格式是固定的，本节演示如何对输出格式进行定制化
 */
public class SimpleFormatter {

    static class Student {
        @Label("姓名")
        String name;

        @Label("出生日期")
        @Format(pattern="yyyy/MM/dd")
        Date born;

        @Label("分数")
        double score;

        public Student() {
        }

        public Student(String name, Date born, Double score) {
            super();
            this.name = name;
            this.born = born;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student [name=" + name + ", born=" + born + ", score=" + score + "]";
        }
    }

    public static String format(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            StringBuilder sb = new StringBuilder();
            for (Field f : cls.getDeclaredFields()) {
                if (!f.isAccessible()) {
                    f.setAccessible(true);
                }
                Label label = f.getAnnotation(Label.class);
                String name = label != null ? label.value() : f.getName();
                Object value = f.get(obj);
                if (value != null && f.getType() == Date.class) {
                    value = formatDate(f, value);
                }
                sb.append(name + "：" + value + "\n");
            }
            return sb.toString();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private static Object formatDate(Field f, Object value) {
        Format format = f.getAnnotation(Format.class);
        if (format != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(format.pattern());
            sdf.setTimeZone(TimeZone.getTimeZone(format.timezone()));
            return sdf.format(value);
        }
        return value;
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Student zhangsan = new Student("张三", sdf.parse("1990-12-12"), 80.9d);
        System.out.println(SimpleFormatter.format(zhangsan));

    }

}
