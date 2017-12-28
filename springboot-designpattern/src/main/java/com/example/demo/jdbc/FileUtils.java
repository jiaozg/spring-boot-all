package com.example.demo.jdbc;

import java.io.File;
import java.io.FileWriter;

/**
 * Created by jiaozhiguang on 2017/12/25.
 */
public class FileUtils {

    public static void writeStr2File(File file, String content) throws Exception {
        FileWriter fw = new FileWriter(file);
        fw.write(content);
        fw.close();
    }

}
