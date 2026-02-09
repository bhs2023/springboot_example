package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fragment")
public class FragmentController {
    
    // Fragment 방식1: th:replace 사용 (조각 삽입)
    @GetMapping("/example1")
    public String fragmentExample1() {
        return "fragment/content";
    }
    
    // Fragment 방식2: layout:decorate 사용 (레이아웃 상속)
    @GetMapping("/example2")
    public String fragmentExample2() {
        return "fragment2/content";
    }
    
    // Fragment 기본 페이지
    @GetMapping("/basic1")
    public String fragmentBasic1() {
        return "fragment/basic";
    }
    
    @GetMapping("/basic2")
    public String fragmentBasic2() {
        return "fragment2/basic";
    }
}
