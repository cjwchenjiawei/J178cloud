package com.cjw.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@RestController
public class FileController {
//    @PostMapping("uploadFile")
//    public String uploadFile(@RequestParam("fileName")MultipartFile file){
//        File f=new File("d:/img/1.jpg");
//        try {
//            file.transferTo(f);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "上传成功";
//    }
  @GetMapping("fileShow")
    public String fileShow(){
        return "http://127.0.0.1:8080/img/1.jpg";
    }
}
