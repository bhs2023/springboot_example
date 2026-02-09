package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index/index";
    }

    @GetMapping("/test1")
    public String test1(){
        return "test1";
    }
}

