package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    // 메인 홈 페이지
    @GetMapping("/")
    public String index() {
        return "index";
    }
    
}
