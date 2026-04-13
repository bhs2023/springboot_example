package com.example.myhome.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    @Column(nullable = false, length = 200)
    private String userid;

    @Column(nullable = false, length = 200)
    private String password;

    @Column(nullable = false, length = 50)
    private String username;

    @Column(name = "wdate", nullable = false)
    private LocalDateTime wdate;

    // Member 클래스 내부에 추가
    @OneToMany(mappedBy = "writer") // Board의 writer 필드에 의해 매핑됨
    private List<Board> boards = new ArrayList<>();

}
