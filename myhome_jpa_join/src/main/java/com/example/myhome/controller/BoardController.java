package com.example.myhome.controller;

import com.example.myhome.common.ApiResponseDTO;
import com.example.myhome.dto.BoardRequestDTO;
import com.example.myhome.dto.BoardResponseDTO;
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

    // 1. 전체 게시글 조회
    @GetMapping
    public ResponseEntity<List<BoardResponseDTO>> getAllBoards() {
        // 서비스에서 이미 DTO 리스트로 변환해서 반환함
        return ResponseEntity.ok(boardService.getAllBoards());
    }

    // 2. 게시글 상세 조회
    @GetMapping("/{seq}")
    public ResponseEntity<BoardResponseDTO> getBoardById(@PathVariable Long seq) {
        // 조회수 증가 로직이 포함된 서비스 호출
        BoardResponseDTO board = boardService.getBoardByIdWithHit(seq);
        return ResponseEntity.ok(board);
    }

    // 3. 게시글 등록
    @PostMapping
    public ResponseEntity<?> createBoard(@RequestBody BoardRequestDTO dto) {
        try{
        // 등록 후 생성된 게시글의 ID(seq)만 반환하는 것이 관례
        //writer(작성자 seq), title, contents
        Long savedSeq = boardService.createBoard(dto);

        // 성공 시 메시지와 상태를 담아 응답
        return ResponseEntity.ok(ApiResponseDTO.success(
                savedSeq +  " 글이추가되었습니다",
                null // 필요하다면 수정된 dto를 리턴해도 됩니다.
        ));
    } catch (RuntimeException e) {
        // 예외 발생 시 400 에러와 함께 에러 메시지 전달
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}

    // 4. 게시글 수정
    @PutMapping("/{seq}")
    public ResponseEntity<?> updateBoard(@PathVariable Long seq, @RequestBody BoardRequestDTO dto) {
        try {
            boardService.updateBoard(seq, dto);

            // 성공 시 메시지와 상태를 담아 응답
            return ResponseEntity.ok(ApiResponseDTO.success(
                    seq + "번 게시글이 성공적으로 수정되었습니다.",
                    null // 필요하다면 수정된 dto를 리턴해도 됩니다.
            ));
        } catch (RuntimeException e) {
            // 예외 발생 시 400 에러와 함께 에러 메시지 전달
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // 5. 게시글 삭제
    @DeleteMapping("/{seq}")
    public ResponseEntity<?> deleteBoard(@PathVariable Long seq) {
        try {
            boardService.deleteBoard(seq);

            // 성공 시 메시지와 상태를 담아 응답
            return ResponseEntity.ok(ApiResponseDTO.success(
                    seq + "번 게시글이 성공적으로 삭제되었습니다.",
                    null // 필요하다면 수정된 dto를 리턴해도 됩니다.
            ));
        } catch (RuntimeException e) {
            // 예외 발생 시 400 에러와 함께 에러 메시지 전달
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}