package com.example.demo.web;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import org.apache.poi.ss.usermodel.Workbook;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by jiaozhiguang on 2017/12/8.
 */
@RestController
public class ExcelController {

    @Autowired
    private UserMapper userMapper;

    // 下载execl文档
    @RequestMapping("/excel/download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 告诉浏览器用什么软件可以打开此文件
        response.setHeader("content-Type", "application/vnd.ms-excel");
        // 下载文件的默认名称
        response.setHeader("Content-Disposition", "attachment;filename=user.xls");
        List<UserEntity> list = userMapper.getAll();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), UserEntity.class, list);
        workbook.write(response.getOutputStream());
    }
}
