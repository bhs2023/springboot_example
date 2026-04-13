package com.example.myhome.dto;

import com.example.myhome.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberResponseDTO {
    private Long seq;
    private String userid;
    private String username;
    private LocalDateTime wdate;

    // 작성한 게시글 목록 (Entity 대신 DTO 리스트로 변환하여 포함)
    private List<BoardResponseDTO> boards;
    private int boardCount; // 작성한 게시글 총 개수

    // Entity -> DTO 변환 메서드
    public static MemberResponseDTO fromEntity(Member member) {
        return MemberResponseDTO.builder()
                .seq(member.getSeq())
                .userid(member.getUserid())
                .username(member.getUsername())
                .wdate(member.getWdate())
                .boardCount(member.getBoards() != null ? member.getBoards().size() : 0)
                // 상세 목록이 필요한 경우만 변환하여 할당 (무한 루프 방지)
                .build();
    }
}