package com.example.demo.web;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Random;

/**
 * @author jiao
 * Created by jiaozhiguang on 2017/12/8.
 */
@Controller
public class PDFController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/pdf/download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/pdf");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=user.pdf");

        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",
                BaseFont.NOT_EMBEDDED);
        Font font = new Font(bf, 16);

        List<UserEntity> list = userMapper.getAll();
        for (UserEntity user : list) {
            PdfPTable table = new PdfPTable(3);
            PdfPCell cell = new PdfPCell();
            cell.setPhrase(new Paragraph(user.getId().toString()));
            table.addCell(cell);
            document.add(table);

            cell = new PdfPCell();
            cell.setPhrase(new Paragraph(user.getUserName().toString()));
            table.addCell(cell);
            document.add(table);

            cell = new PdfPCell();
            cell.setPhrase(new Paragraph("测试", font));
            table.addCell(cell);
            document.add(table);
        }
        document.close();
    }

    @RequestMapping("/pdf/math")
    public void math(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/pdf");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=user.pdf");

        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        int column = 8;

        for (int i = 0; i < 200 ; i++) {
            PdfPTable table = new PdfPTable(column);
            for (int j = 0; j < column; j++) {
                PdfPCell cell = new PdfPCell();
                cell.setPhrase(new Paragraph(new Random().nextInt(11)+"+ " + new Random().nextInt(11) +"=  "));
                table.addCell(cell);
                document.add(table);
            }



        }

        document.close();
    }

}
