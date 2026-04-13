package com.namgarambooks.myhome.api;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value="/api")
public class RestApiController {
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {

        return new ResponseEntity<>("Hello, World!", HttpStatus.OK);
    }

    @GetMapping("/hello2")
    public ResponseEntity<String> hello2() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "header-test");
        return new ResponseEntity<>("Hello, World!", headers, HttpStatus.OK);
    }

    @GetMapping("/add2")
    public ResponseEntity<HashMap> add2(int x, int y) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "header-test");
        HashMap<String, Integer> map = new HashMap<>();
        map.put("x", x);
        map.put("y", y);
        map.put("result", x+y);
        return new ResponseEntity<>(map, headers, HttpStatus.OK);
    }

    @GetMapping("/myinfo")
    public ResponseEntity<HashMap<String,String>> myinfo() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "myinfo");
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "홍길동");
        map.put("phone", "010-0000-0001");
        return new ResponseEntity<>(map, headers, HttpStatus.OK);
    }

    @GetMapping("/hero")
    public ResponseEntity<List<HashMap<String,String>>> hero() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "header-test");
        List<HashMap<String, String>>    list = new ArrayList<HashMap<String, String >>();
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "이순신");
        map.put("description", "임진왜란에서 승리");
        list.add(map);

        map = new HashMap<>();
        map.put("name", "세종대왕");
        map.put("phone", "한글창제");
        list.add(map);

        map = new HashMap<>();
        map.put("name", "강감찬");
        map.put("phone", "귀주대첨");
        list.add(map);

        map = new HashMap<>();
        map.put("name", "김종서");
        map.put("phone", "4군6진구축");
        list.add(map);

        return new ResponseEntity<>(list, headers, HttpStatus.OK);
    }
}