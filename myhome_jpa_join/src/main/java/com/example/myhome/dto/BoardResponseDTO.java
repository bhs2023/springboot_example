package com.example.myhome.dto;

import com.example.myhome.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponseDTO {
    private Long seq;
    private String title;
    private String contents;
     private Integer hit;
    private LocalDateTime wdate;

    // 외래키 ID 혹은 필요한 회원 정보만 선별
    private Long writer;
    private String memberName;

    // Entity -> DTO 변환 메서드 (Static Factory Method)
    public static BoardResponseDTO fromEntity(Board board) {
        return BoardResponseDTO.builder()
                .seq(board.getSeq())
                .title(board.getTitle())
                .contents(board.getContents())
                .hit(board.getHit())
                .wdate(board.getWdate())
                .writer(board.getWriter() != null ? board.getWriter().getSeq() : null)
                .memberName(board.getWriter() != null ? board.getWriter().getUsername() : "탈퇴회원")
                .build();
    }
    //Dto => Entity 변환
    public Board toEntity() {
        return Board.builder()
                .title(this.title)
                .contents(this.contents)
                // 주의: member는 여기서 바로 넣지 않고 서비스에서 찾아 세팅하거나,
                // ID값만 가진 프록시 객체를 활용합니다.
                .hit(0) // 초기값 설정
                .build();
    }
}