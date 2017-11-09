package com.example.demo.util;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.currentThread;

/**
 * Created by jiaozhiguang on 2017/11/4.
 */
public class ClassScaner {

    public static Map<String, Class<?>> scanerClass(String basePackage) throws ClassNotFoundException {
        Map<String, Class<?>> results = new HashMap<>();
        String filePath = basePackage.replace(".", "/");
        URL url = currentThread().getContextClassLoader().getResource(filePath);
        if (url.getProtocol().equals("file")) {
            File file = new File(url.getPath());
            scanerFile(file, filePath, results);
        }
        return results;
    }

    public static void scanerFile(File folder, String rootPath, Map<String, Class<?>> classes) throws ClassNotFoundException {
        File [] files = folder.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                scanerFile(file, rootPath + "/"+ file.getName() + "/", classes);
            } else {
                String path = file.getAbsolutePath();
                if (path.endsWith(".class")) {
                    path = path.replace("\\", "/");

                    String className = path.substring(path.indexOf(rootPath), path.indexOf(".class"));
                    className = className.replace("/", ".");
                    classes.put(className, Class.forName(className));
                    System.out.println(className);
                }
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        scanerClass("com.example.demo");
    }
}