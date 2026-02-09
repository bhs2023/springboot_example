package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController  //결과를 json으로 반환한다
public class HelloController {

    // http://localhost:9000/hello
    @RequestMapping("/hello")
    public String hello(){
        return "Hello";  //
    }

    //http://localhost:9000/add?x=4&y=5   :호출방식
    @GetMapping("/add")
    public String add(Integer x, Integer y){
        Integer result = x+y;
        return String.format("%d + %d =%d", x, y, result);
    }

    //http://localhost:9000/add2/4/5   :호출방식 - pathVariable을 사용한다.
    //@PathVariable 방식
    @GetMapping("/add2/{x}/{y}")
    public String add2(@PathVariable(name="x")Integer x, @PathVariable(name="y")Integer y){
        Integer result = x+y;
        return String.format("%d + %d =%d", x, y, result);
    }

    //http://localhost:9000/add3/14/5
    @GetMapping("/add3/{x}/{y}")
    public HashMap<String, String> add3(@PathVariable(name="x")Integer x, @PathVariable(name="y")Integer y){
        Integer result = x+y;
        HashMap<String,String> map =new HashMap<String,String>();

        map.put("x", x+"");
        map.put("y", y+"");
        map.put("result", (x+y)+"");

        return map; //java객체가 => JSON타입으로 전환된다.
    }

    @PostMapping("/add_post") //데이터를 body로 받는다.
    public HashMap<String, String> add_post(Integer x, Integer y){
        HashMap<String,String> map =new HashMap<String,String>();

        map.put("x", x+"");
        map.put("y", y+"");
        map.put("result", (x+y)+"");

        return map; //java객체가 => JSON타입으로 전환된다.
    }

    //json으로 받으려면 매개변수 앞에 @RequestBody가 붙어야 한다.
    //객체로 파라미터가  HashMap타입이거나 Dto 타입으로 받아야 한다.
    //jquery의 $.ajax는 기본이 form전송, json 전송이 아니다
    //axios, fetch 는 json 전송이 기본이다. vuejs가 주고  axios나 fetch를 사용한다.
    @PostMapping("/add_json")
    public HashMap<String, Integer>add_json(@RequestBody HashMap<String, Integer>paramMap){
        Integer x = paramMap.get("x");
        Integer y = paramMap.get("y");

        paramMap.put("result", (x+y));

        return paramMap;
    }
}









