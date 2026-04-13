package com.example.myhome.dto;

import com.example.myhome.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardRequestDTO {

    // 등록/수정 시 클라이언트가 보내주는 데이터
    private String title;
    private String contents;
    private Long writer;    // 작성자 고유 번호 (외래키 ID)

    /**
     * DTO를 Entity로 변환하는 메서드
     * 주의: Member 객체는 연관관계 처리를 위해 서비스 계층에서 주입함
     */
    public Board toEntity() {
        return Board.builder()
                .title(this.title)
                .contents(this.contents)
                .hit(0) // 새 글 등록 시 조회수는 0으로 초기화
                .build();
    }
}