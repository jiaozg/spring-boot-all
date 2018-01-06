package com.example.demo.util.word;

import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.File;

/**
 * Created by jiaozhiguang on 2018/1/5.
 */
public class ReadWordTest {

    public static void main(String[] args) throws Exception {
        File file = new File("./word.docx");
        WordprocessingMLPackage word = WordprocessingMLPackage.load(file);
        String xml = word.getMainDocumentPart().getXML();
        System.out.println(xml);
    }

}
