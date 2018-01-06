package com.example.demo.util.word;

import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.File;

/**
 * Created by jiaozhiguang on 2018/1/5.
 */
public class WordTest {

    public static void main(String[] args) throws Exception{

        WordprocessingMLPackage word = WordprocessingMLPackage.createPackage();
        word.getMainDocumentPart().addStyledParagraphOfText("Title", "Title 标题");
        word.getMainDocumentPart().addStyledParagraphOfText("Subtitle", "Subtitle 子标题");
        File file = new File("./word.docx");
        word.save(file);

    }

    //空白文档
    public static void getWord2() throws Exception {
        WordprocessingMLPackage word = WordprocessingMLPackage.createPackage();
        word.getMainDocumentPart().addParagraphOfText("Hello World 你好 世界");
        File file = new File("./word.docx");
        word.save(file);
    }

    //空白文档
    public static void getWord() throws Exception {
        WordprocessingMLPackage word = WordprocessingMLPackage.createPackage();
        File file = new File("./word.docx");
        word.save(file);
    }

}
