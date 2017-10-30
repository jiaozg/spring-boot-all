package com.example.demo.controllr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by jiaozhiguang on 2017/10/29.
 */
@Controller
public class UploadController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/fileUp")
    public void fileUp(@RequestParam("files") MultipartFile file, HttpServletRequest request) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        String savePath = request.getServletContext().getRealPath("/files");
        Collection<Part> files = request.getParts();
        for (Part part : files) {
            part.write(savePath + File.separator + part.getName());
        }
    }
}

