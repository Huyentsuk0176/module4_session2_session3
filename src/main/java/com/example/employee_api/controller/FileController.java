package com.example.employee_api.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class FileController {

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("image") MultipartFile file) throws IOException {
        if (file.isEmpty()){
            return "File rong";
        }
        String fileName=file.getOriginalFilename();
        //kiem tra dinh dang file
        if (! fileName.endsWith(".png")&& ! fileName.endsWith(".jpg")){
            return "chi cho phep file png hoac jpg";
        }

        String uploadDir = System.getProperty("user.dir")+"uploads/";


        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }


        File dest = new File(uploadDir+fileName);

        file.transferTo(dest);

        return "Upload thành công: " + fileName;
    }
}