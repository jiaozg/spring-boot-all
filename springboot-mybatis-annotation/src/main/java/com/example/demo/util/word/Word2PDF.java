package com.example.demo.util.word;

import org.docx4j.Docx4J;
import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.fonts.PhysicalFonts;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by jiaozhiguang on 2018/1/5.
 */
public class Word2PDF {

    public static void main(String[] args) throws Exception {

        File file = new File("./word.docx");
        WordprocessingMLPackage word = WordprocessingMLPackage.load(file);

        Mapper font = new IdentityPlusMapper();
        font.put("黑体", PhysicalFonts.get("SimHei"));
        word.setFontMapper(font);

        Docx4J.toPDF(word, new FileOutputStream(new File("./word.pdf")));
    }

    public static void toPDF() throws Exception {
        File file = new File("./word.docx");
        WordprocessingMLPackage word = WordprocessingMLPackage.load(file);

        Docx4J.toPDF(word, new FileOutputStream(new File("./word.pdf")));
    }

}
