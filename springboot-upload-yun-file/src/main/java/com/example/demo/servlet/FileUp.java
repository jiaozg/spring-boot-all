package com.example.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

/**
 * Created by jiaozhiguang on 2017/10/29.
 */
@WebServlet("/fileUp.do")
@MultipartConfig
public class FileUp extends HttpServlet {

    private final Path rootLocation = Paths.get(new StorageProperties().getLocation());

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
//        String savePath = request.getServletContext().getRealPath("/files");
        Collection<Part> files = request.getParts();
        for (Part part : files) {
            System.out.println(part.getName());
//            part.write(rootLocation + File.separator + part.getName());
        }
    }

}
