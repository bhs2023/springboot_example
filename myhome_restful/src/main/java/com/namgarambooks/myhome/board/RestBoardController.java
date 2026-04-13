package com.namgarambooks.myhome.board;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequestMapping("/api/board")
@RestController
public class RestBoardController {

    private final BoardService boardService;


    public RestBoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public ResponseEntity<HashMap<String, Object>> board_list(BoardDto dto){
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("result", "success");
        map.put("data", boardService.getList(dto));
        return ResponseEntity.ok(map);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<HashMap<String, Object>> board_view(@PathVariable("id")String id)  {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("result", "success");
        map.put("data", boardService.getView(id));
        return ResponseEntity.ok(map);
    }

    @PostMapping("/save")
    public ResponseEntity<HashMap<String, Object>> board_save(@RequestBody BoardDto dto)  {
        HashMap<String, Object> map = new HashMap<String, Object>();

        boardService.insert(dto);
        map.put("result", "success");
        map.put("data", boardService.getList(dto));
        return ResponseEntity.ok(map);
    }

    @PutMapping("/update")
    public ResponseEntity<HashMap<String, Object>> board_update(@RequestBody BoardDto dto)  {
        HashMap<String, Object> map = new HashMap<String, Object>();

        boardService.update(dto);
        map.put("result", "success");
        map.put("data", boardService.getList(dto));
        return ResponseEntity.ok(map);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HashMap<String, Object>> board_delete(@PathVariable("id") String id)  {
        HashMap<String, Object> map = new HashMap<String, Object>();

        BoardDto dto = new BoardDto();
        dto.setId(id);
        boardService.delete(dto);
        map.put("id", id);

        map.put("result", "success");
        map.put("data", boardService.getList(dto));
        return ResponseEntity.ok(map);
    }


}

