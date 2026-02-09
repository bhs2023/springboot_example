package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

//view  엔진 사용시에는 반드시 Controller를 사용해야 한다.
@Controller
//@RequestMapping(value="/mustache")  //클래스에  /mustache/ ~~~~ 는 전부 이 클래스가 처리한다
public class MustacheController {

    @GetMapping("/")
    public String  index(Model model){
        //ModelAndView 가  Model과 View로 쪼개짐
        //String  반환값이  view 주소
        //파라미터로  Model이 추가됨

        return "redirect:/home";  //  /resources/templates/home.html  파일을 찾는다
    }

    @GetMapping("/home")
    public String  home(Model model){
        //ModelAndView 가  Model과 View로 쪼개짐
        //String  반환값이  view 주소
        //파라미터로  Model이 추가됨

        model.addAttribute("msg", "머스티치 테스트");
        model.addAttribute("name", "홍길동");
        model.addAttribute("age", 12);

        return "/home";  //  /resources/templates/home.html  파일을 찾는다
    }

    @GetMapping("/list1")
    public String  list1(Model model){
        //ModelAndView 가  Model과 View로 쪼개짐
        //String  반환값이  view 주소
        //파라미터로  Model이 추가됨
        List<String> list = new ArrayList<String>();
        list.add("장미");
        list.add("작약");
        list.add("백일홍");
        list.add("천일홍");
        model.addAttribute("flowerList", list);

        return "/list1";  //  /resources/templates/home.html  파일을 찾는다
    }



}
