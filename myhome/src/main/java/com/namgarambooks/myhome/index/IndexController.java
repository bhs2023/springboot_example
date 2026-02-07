package com.namgarambooks.myhome.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index/index";
    }

    @GetMapping("/basic")
    public String basic(){
        return "fragment/basic";
    }

    @GetMapping("/fragment")
    public String fragment(){
        return "fragment/content";
    }

    @GetMapping("/fragment2")
    public String fragment2(){
        return "fragment2/content";
    }
}
