package com.namgarambooks.myhome.todo;

import com.namgarambooks.myhome.board.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todo")

//@CrossOrigin(origins = "http://localhost:3000") // 허용할 Origin
public class RestTodoController {
    private final TodoService service;

    @GetMapping("/cors")
    public ResponseEntity<HashMap<String, String>> getTest() {

        HashMap<String,String> map = new HashMap<String, String>();
        map.put("msg", "cors 테스트입니다");
        map.put("username", "홍길동");
        return ResponseEntity.ok(map);
    }

    @GetMapping("/list")
    public ResponseEntity<HashMap<String, Object>> todo_list(TodoDto dto){
        HashMap<String, Object>map = new HashMap<String, Object>();
        map.put("result", "success");
        map.put("data", service.getAllTodos());
        return ResponseEntity.ok(map);
    }


    @GetMapping("/view/{id}")
    public ResponseEntity<HashMap<String, Object>> todo_view(@PathVariable("id")Integer id)  {
        HashMap<String, Object> map = new HashMap<String, Object>();
        if( service.getTodoById(id).isPresent()) {
            map.put("result", "success");
            map.put("data", service.getTodoById(id).get());
        }
        else
        {
            map.put("result", "fail");
            map.put("data", new HashMap<>());
        }
        return ResponseEntity.ok(map);
    }

    @PostMapping("/save")
    public ResponseEntity<HashMap<String, Object>> todo_save(@RequestBody TodoDto dto)  {
        HashMap<String, Object> map = new HashMap<String, Object>();

        boolean result = service.insert(dto);
        if(result) {
            map.put("result", "success");
            map.put("data", service.getAllTodos());
        }else{
            map.put("result", "fail");
            map.put("data",  service.getAllTodos());
        }

        return ResponseEntity.ok(map);
    }

    @PutMapping("/update")
    public ResponseEntity<HashMap<String, Object>> todo_update(@RequestBody TodoDto dto)  {
        HashMap<String, Object> map = new HashMap<String, Object>();

        boolean result = service.update(dto);
        if(result) {
            map.put("result", "success");
            map.put("data", service.getAllTodos());
        }else{
            map.put("result", "fail");
            map.put("data",  service.getAllTodos());
        }

        return ResponseEntity.ok(map);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HashMap<String, Object>> todo_delete(@PathVariable("id") Integer id,
                                                                TodoDto dto)  {
        HashMap<String, Object> map = new HashMap<String, Object>();

        boolean result = service.delete(id);
        if(result) {
            map.put("result", "success");
            map.put("data", service.getAllTodos());
        }else{
            map.put("result", "fail");
            map.put("data", service.getAllTodos() );
        }       return ResponseEntity.ok(map);
    }
}


