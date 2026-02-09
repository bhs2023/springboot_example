package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/")
public class ThymeleafController {
    
    @GetMapping("/test1")
    public String test1(Model model){
        model.addAttribute("msg", "타임리프 테스트");
        model.addAttribute("name", "임꺽정");
        model.addAttribute("age", "34");

        return "test1";
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

        return "list1";
    }

    // 예제 1: 조건문 사용 (th:if, th:unless)
    @GetMapping("/condition")
    public String condition(Model model) {
        model.addAttribute("score", 85);
        model.addAttribute("isLoggedIn", true);
        model.addAttribute("userName", "홍길동");
        
        return "condition";
    }

    // 예제 2: 객체 사용 예제
    @GetMapping("/user")
    public String user(Model model) {
        User user1 = new User("김철수", 25, "kim@example.com", true);
        User user2 = new User("이영희", 30, "lee@example.com", false);
        
        model.addAttribute("user", user1);
        model.addAttribute("inactiveUser", user2);
        
        return "user";
    }

    // 예제 3: 반복문과 인덱스 사용
    @GetMapping("/books")
    public String books(Model model) {
        List<String> bookList = new ArrayList<>();
        bookList.add("자바의 정석");
        bookList.add("스프링 부트 시작하기");
        bookList.add("클린 코드");
        bookList.add("이펙티브 자바");
        bookList.add("토비의 스프링");
        
        model.addAttribute("books", bookList);
        model.addAttribute("totalBooks", bookList.size());
        
        return "books";
    }

    // 예제 4: URL 링크 생성 예제
    @GetMapping("/links")
    public String links(Model model) {
        List<User> users = new ArrayList<>();
        users.add(new User("김철수", 25, "kim@example.com", true));
        users.add(new User("이영희", 30, "lee@example.com", true));
        users.add(new User("박민수", 28, "park@example.com", false));
        
        model.addAttribute("users", users);
        model.addAttribute("baseUrl", "/user/detail");
        
        return "links";
    }

}
