package com.example.client1.controller;

import com.example.client1.Utils.CSVUtils;
import com.example.client1.Utils.FileUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;



@RestController
/*upload csv*/
public class csvController {
        @PostMapping("csvUpload")
        public String csvUpload(@RequestParam("file") MultipartFile file) throws IOException {
            CSVUtils csvUtils = new CSVUtils();
            return csvUtils.upload(file);
        }
}
