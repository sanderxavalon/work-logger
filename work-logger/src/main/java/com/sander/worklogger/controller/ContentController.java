package com.sander.worklogger.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContentController {

    @GetMapping("/test")
    public String test(){
        return "Hello World";
    }
}
