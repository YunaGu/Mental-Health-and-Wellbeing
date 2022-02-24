package com.example.client1.controller;

import com.example.client1.DTO.NewsContent;
import com.example.client1.Utils.FileUtils;
import com.example.client1.Utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
/*upload image*/
public class FileController {
    @PostMapping("fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        FileUtils fileUtils = new FileUtils();
        return fileUtils.upload(file);
    }

}


