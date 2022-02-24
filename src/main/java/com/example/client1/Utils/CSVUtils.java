package com.example.client1.Utils;

import com.example.client1.Client1Application;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Objects;

public class CSVUtils {

        public String upload(MultipartFile file) throws IOException {
            String[] fileName = Objects.requireNonNull(file.getOriginalFilename()).split("\\.");
            // Judge file upload type
            if(fileName[1].equals("csv")) {
                String[] builds = URLDecoder.decode(Client1Application.class.getResource("").getPath(),"utf-8").split("build");
                // File return path splicing
                String path =  (builds[0] + "build/resources/main/static/csv/" + file.getOriginalFilename()).substring(1);
                File newFile = new File(path);
                // File save
                file.transferTo(newFile);
                return path;
            }
            return "error";
        }

}
