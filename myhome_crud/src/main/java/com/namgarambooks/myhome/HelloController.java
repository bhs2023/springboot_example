package com.namgarambooks.myhome;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class HelloController {

    @GetMapping("/add")
    public HashMap<String, String> add1(@RequestParam int x, @RequestParam int y){
        int result = x+y;
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("x", String.valueOf(x));
        map.put("y", String.valueOf(y));
        map.put("result", String.valueOf(result));

        return map;

    }

    @GetMapping("/add2/{x}/{y}")
    public HashMap<String, String> add2(@PathVariable int x, @PathVariable int y){
        int result = x+y;
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("x", String.valueOf(x));
        map.put("y", String.valueOf(y));
        map.put("result", String.valueOf(result));
        return map;
    }

    @PostMapping("/add_post")
    public HashMap<String, String> add_post(int x, int y){
        int result = x+y;
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("x", String.valueOf(x));
        map.put("y", String.valueOf(y));
        map.put("result", String.valueOf(result));
        return map;
    }

    @PostMapping("/add_form")
    public HashMap<String, String> add_form(int x, int y){
        int result = x+y;
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("x", String.valueOf(x));
        map.put("y", String.valueOf(y));
        map.put("result", String.valueOf(result));
        return map;
    }

    @PostMapping("/add_json")
    public HashMap<String, String> add_json(@RequestBody HashMap<String, String> paramMap){
        int result =Integer.parseInt(paramMap.get("x")) +  Integer.parseInt(paramMap.get("y"));
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("x", paramMap.get("x"));
        map.put("y", paramMap.get("y"));
        map.put("result", String.valueOf(result));
        return map;
    }
}
