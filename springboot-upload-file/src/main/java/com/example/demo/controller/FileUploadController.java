package com.example.demo.controller;

import com.example.demo.storage.StorageFileNotFoundException;
import com.example.demo.storage.StorageService;
import com.example.demo.util.HttpClientUtil;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jiaozhiguang on 2017/8/25.
 */
@Controller
public class FileUploadController {

    @Autowired
    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/")
    public String listUploadedFiles(Model model) throws IOException {

        model.addAttribute("files", storageService
                .loadAll()
                .map(path ->
                        MvcUriComponentsBuilder
                                .fromMethodName(FileUploadController.class, "serveFile", path.getFileName().toString())
                                .build().toString())
                .collect(Collectors.toList()));

        return "uploadForm";
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }

    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, String name,
                                   RedirectAttributes redirectAttributes) {

        System.out.println(name);

        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }

    @GetMapping("/test")
    @ResponseBody
    public String face() {

        String url = "https://api-cn.faceplusplus.com/cardpp/v1/ocridcard";

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("api_key", "uY828SsomgDN1uPatYXDmBpu0lPWcThx"));
        params.add(new BasicNameValuePair("api_secret", "0wAhnC5W1tLxtmFj_dM6uPyiZ7J3urL4"));
        params.add(new BasicNameValuePair("image_url", "https://thumbnail0.baidupcs.com/thumbnail/a7bed4fedd60bd659193511d0bd772f7?fid=1430534537-250528-815664779642130&time=1507870800&rt=sh&sign=FDTAER-DCb740ccc5511e5e8fedcff06b081203-obh9g0kmGS4DbqV6qDMw2bt7HBM%3D&expires=8h&chkv=0&chkbd=0&chkpc=&dp-logid=6623453428403123212&dp-callid=0&size=c710_u400&quality=100&vuk=-&ft=video"));

        return HttpClientUtil.post(url, params);

    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }

}
