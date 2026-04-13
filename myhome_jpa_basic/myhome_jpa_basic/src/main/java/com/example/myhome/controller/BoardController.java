package com.example.myhome.controller;

import com.example.myhome.entity.Board;
import com.example.myhome.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {
    
    private final BoardService boardService;
    
    // 전체 게시글 조회
    @GetMapping
    public ResponseEntity<List<Board>> getAllBoards() {
        List<Board> boards = boardService.getAllBoards();
        return ResponseEntity.ok(boards);
    }
    
    // 게시글 상세 조회
    @GetMapping("/{seq}")
    public ResponseEntity<Board> getBoardById(@PathVariable Long seq) {
        return boardService.getBoardByIdWithHit(seq)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    // 게시글 등록
    @PostMapping
    public ResponseEntity<Board> createBoard(@RequestBody Board board) {
        Board savedBoard = boardService.createBoard(board);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBoard);
    }
    
    // 게시글 수정
    @PutMapping("/{seq}")
    public ResponseEntity<Board> updateBoard(@PathVariable Long seq, @RequestBody Board board) {
        try {
            Board updatedBoard = boardService.updateBoard(seq, board);
            return ResponseEntity.ok(updatedBoard);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    // 게시글 삭제
    @DeleteMapping("/{seq}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long seq) {
        boardService.deleteBoard(seq);
        return ResponseEntity.noContent().build();
    }
    
    // 제목으로 검색
    @GetMapping("/search/title")
    public ResponseEntity<List<Board>> searchByTitle(@RequestParam String keyword) {
        List<Board> boards = boardService.searchByTitle(keyword);
        return ResponseEntity.ok(boards);
    }
    
    // 작성자로 검색
    @GetMapping("/search/writer")
    public ResponseEntity<List<Board>> searchByWriter(@RequestParam String writer) {
        List<Board> boards = boardService.searchByWriter(writer);
        return ResponseEntity.ok(boards);
    }
    
    // 인기 게시글 조회
    @GetMapping("/popular")
    public ResponseEntity<List<Board>> getPopularBoards() {
        List<Board> boards = boardService.getPopularBoards();
        return ResponseEntity.ok(boards);
    }
}
