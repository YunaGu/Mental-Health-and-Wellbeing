package com.example.client1.controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
//Set the userName and password for administrator login
@RestController
public class AddController {
    @PostMapping("/Add")
    public String Add(@RequestBody HashMap name) {
        if ("Admin".equals(name.get("username")) && "123456".equals(name.get("password"))) {
            return "success";
        }
        return "error";
    }
}


