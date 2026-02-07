package com.namgarambooks.myhome.todo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class RestExceptionController {

    @ExceptionHandler(IllegalArgumentException .class)
    public ResponseEntity<String> handleNotFoundException(IllegalArgumentException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("개별적인 처리를 했을때 : " + ex.getMessage());
    }

    @GetMapping("/test")
    public ResponseEntity<HashMap<String, Object>> add(Integer x, Integer y)
    {
        if( x ==null || y==null)
            throw new IllegalArgumentException("x값과 y값이 입력되어야 합니다.");

        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("x = ", x);
        result.put("y = ", y);
        result.put("result = ", x+y);
        return ResponseEntity.ok(result);
    }
}
