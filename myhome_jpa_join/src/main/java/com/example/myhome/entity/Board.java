package com.example.myhome.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_board")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Board {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;
    
    @Column(nullable = false, length = 200)
    private String title;
    

    @Column(name = "wdate", nullable = false)
    private LocalDateTime wdate;
    
    @Column(nullable = false, columnDefinition = "TEXT")
    private String contents;
    
    @Column(nullable = false)
    private Integer hit;
    
    @PrePersist
    public void prePersist() {
        if (this.wdate == null) {
            this.wdate = LocalDateTime.now();
        }
        if (this.hit == null) {
            this.hit = 0;
        }
    }

    //@Column(nullable = false, length = 50)
    //private String writer; -- 이컬럼으로 조인하려고 함

    // 핵심: Member와 N:1 관계 설정
    @ManyToOne(fetch = FetchType.LAZY) // 지연 로딩 권장
    @JoinColumn(name = "writer")   // DB 외래키 컬럼명
    private Member writer;

    public void changeBoard(String title, String contents) {
        this.title = title;
        this.contents = contents;

        // 필요한 경우 수정 시간(mdate) 등을 여기서 갱신할 수도 있습니다.
    }

    public void setMember(Member writer) {
        this.writer = writer;
        // (선택사항) Member 쪽에도 게시글 추가가 필요하다면 연관관계 편의 로직 추가
        if (!writer.getBoards().contains(this)) {
            writer.getBoards().add(this);
        }
    }

    public void updateHit() {
        this.hit = (this.hit == null) ? 1 : this.hit + 1;
    }


}
