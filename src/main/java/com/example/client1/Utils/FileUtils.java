package com.example.client1.Utils;

import com.example.client1.Client1Application;
import org.springframework.web.multipart.MultipartFile;

import javax.crypto.spec.PSource;
import java.awt.*;
import java.io.*;
import java.net.URLDecoder;
import java.util.Objects;
import java.util.UUID;

public class FileUtils {

    public String upload(MultipartFile file) throws IOException {
        String[] fileName = Objects.requireNonNull(file.getOriginalFilename()).split("\\.");
        // Judge file upload type
        if(fileName[1].equals("jpg")) {
            String[] builds = URLDecoder.decode(Client1Application.class.getResource("").getPath(),"utf-8").split("build");
            // File return path splicing
            String path =  (builds[0] + "build/resources/main/static/images/" + file.getOriginalFilename()).substring(1);
            File newFile = new File(path);
            // File save
            file.transferTo(newFile);
            return path;
        }
        return "error";
    }

}
