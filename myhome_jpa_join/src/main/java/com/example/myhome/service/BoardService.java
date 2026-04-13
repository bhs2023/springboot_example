package com.example.myhome.service;

import com.example.myhome.dto.BoardRequestDTO;
import com.example.myhome.dto.BoardResponseDTO;
import com.example.myhome.entity.Board;
import com.example.myhome.repository.BoardRepository;
import com.example.myhome.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;
import com.example.myhome.entity.Member;
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {

    private final BoardRepository boardRepository;
    private final MemberRepository memberRepository; // Member 조회를 위해 추가

    // 1. 전체 게시글 조회 (Fetch Join 활용)
    public List<BoardResponseDTO> getAllBoards() {
        return boardRepository.findAllWithMember().stream()
                .map(BoardResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    // 2. 게시글 상세 조회 (조회수 증가 포함)
    @Transactional
    public BoardResponseDTO getBoardByIdWithHit(Long seq) {
        Board board = boardRepository.findById(seq)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        // Dirty Checking(변경 감지)을 통한 조회수 증가
        board.updateHit();

        return BoardResponseDTO.fromEntity(board);
    }

    // 3. 게시글 등록 (Member 연관 관계 처리)
    @Transactional
    public Long createBoard(BoardRequestDTO dto) {
        // 1. 작성자(Member) 확인
        Member member = (Member) memberRepository.findById(dto.getWriter())
                .orElseThrow(() -> new RuntimeException("존재하지 않는 회원입니다."));

        // 2. DTO -> Entity 변환 및 연관 관계 설정
        Board board = dto.toEntity();
        board.setMember(member); // 연관 관계 편의 메서드 권장

        return boardRepository.save(board).getSeq();
    }

    // 4. 게시글 수정
    @Transactional
    public void updateBoard(Long seq, BoardRequestDTO dto) {
        Board board = boardRepository.findById(seq)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        board.changeBoard(dto.getTitle(), dto.getContents());
        // 엔티티의 상태만 변경하면 트랜잭션 종료 시 자동으로 DB에 반영됨 (save 호출 불필요)
    }

    // 5. 게시글 삭제
    @Transactional
    public void deleteBoard(Long seq) {
        boardRepository.deleteById(seq);
    }
}