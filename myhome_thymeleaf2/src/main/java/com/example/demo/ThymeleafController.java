package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/thymeleaf")
public class ThymeleafController {
    @GetMapping("/test1")
    public String test1(Model model){
        model.addAttribute("msg", "타임리프 테스트");
        model.addAttribute("name", "임꺽정");
        model.addAttribute("age", "34");

        return "/test1";
    }
}
