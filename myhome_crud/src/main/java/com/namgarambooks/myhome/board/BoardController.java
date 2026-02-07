package com.namgarambooks.myhome.board;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value="/board")
public class BoardController {

    private final BoardService boardService;


    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public String getList(Model model, BoardDto dto){

        model.addAttribute("boardList", boardService.getList(dto));
        return "board/board_list";
    }

    @GetMapping("/view/{id}")
    public String getView(Model model, @PathVariable("id")String id){

        model.addAttribute("boardView", boardService.getView(id));
        System.out.println(boardService.getView(id));
        return  "board/board_view";
    }

    @GetMapping("/write")
    public String write(Model model ){
        model.addAttribute("mode", "insert");
        return  "board/board_write";
    }

    @PostMapping("/save")
    public String save(BoardDto dto){
        boardService.insert(dto);
        return  "redirect:/board/list";
    }

    @GetMapping("/modify/{id}")
    public String modify(Model model,  @PathVariable("id")String id){
        model.addAttribute("mode", "modify");
        model.addAttribute("boardView", boardService.getView(id));
        return  "board/board_write2";
    }

    @PostMapping("/update")
    public String update(BoardDto dto){

        boardService.update(dto);
        return  "redirect:/board/list";
    }

    @PostMapping("/delete")
    public String delete(BoardDto dto) {

        boardService.delete(dto);
        return "redirect:/board/list";
    }
}
