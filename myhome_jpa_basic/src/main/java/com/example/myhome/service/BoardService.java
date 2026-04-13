package com.example.myhome.service;

import com.example.myhome.entity.Board;
import com.example.myhome.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {
    
    private final BoardRepository boardRepository;
    
    // 전체 게시글 조회
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }
    
    // 게시글 상세 조회
    public Optional<Board> getBoardById(Long seq) {
        return boardRepository.findById(seq);
    }
    
    // 게시글 상세 조회 (조회수 증가)
    @Transactional
    public Optional<Board> getBoardByIdWithHit(Long seq) {
        boardRepository.incrementHit(seq);
        return boardRepository.findById(seq);
    }
    
    // 게시글 등록
    @Transactional
    public Board createBoard(Board board) {
        if (board.getWdate() == null) {
            board.setWdate(LocalDateTime.now());
        }
        if (board.getHit() == null) {
            board.setHit(0);
        }
        return boardRepository.save(board);
    }
    
    // 게시글 수정
    @Transactional
    public Board updateBoard(Long seq, Board boardDetails) {
        Board board = boardRepository.findById(seq)
                .orElseThrow(() -> new RuntimeException("Board not found with id: " + seq));
        
        board.setTitle(boardDetails.getTitle());
        board.setWriter(boardDetails.getWriter());
        board.setContents(boardDetails.getContents());
        
        return boardRepository.save(board);
    }
    
    // 게시글 삭제
    @Transactional
    public void deleteBoard(Long seq) {
        boardRepository.deleteById(seq);
    }
    
    // 제목으로 검색
    public List<Board> searchByTitle(String title) {
        return boardRepository.findByTitleContaining(title);
    }
    
    // 작성자로 검색
    public List<Board> searchByWriter(String writer) {
        return boardRepository.findByWriter(writer);
    }
    
    // 인기 게시글 조회
    public List<Board> getPopularBoards() {
        return boardRepository.findTop10ByOrderByHitDesc();
    }
}
