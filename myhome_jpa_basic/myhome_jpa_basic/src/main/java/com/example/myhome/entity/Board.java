package com.example.myhome.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "board")
@Getter
@Setter
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
    
    @Column(nullable = false, length = 50)
    private String writer;
    
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
}
