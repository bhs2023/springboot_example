package com.example.demo.board;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
//@RequestMapping ->클래스에 메서드에도 가능하다.
// 클래스에 붙이면 이클래스의 모든 메서드에 적용된다.
@RequestMapping(value="/board")

public class BoardController {
    private final BoardService service;

    @GetMapping("/list")
    public String board_list(Model model, HttpServletRequest request, String msg){
        //HttpSession session = request.getSession();
        String temp = request.getParameter("msg");
        request.setAttribute("msg", msg);
        model.addAttribute("boardList", service.getList(null));
        return "board/board_list";
    }

     // /board/view/2
    @GetMapping("/view/{id}")
    public String board_view(Model model, @PathVariable(name="id")String id)
    {
        BoardDto dto = service.getView(id);
        model.addAttribute("boardView", dto);
        return "board/board_view";
    }
    //write화면으로 이동
    @GetMapping("/write")
    public String board_write(){
        return "board/board_write";
    }

    /* 서버에서 서버로 페이지이동을 포워드
       클라이언트한테 보내서 다시 요청받느걸 redirect
    */
    @PostMapping("/save")
    public String board_save(BoardDto dto){
        service.insert(dto);

        return "redirect:/board/list";
    }
}









