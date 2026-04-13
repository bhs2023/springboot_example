package com.example.myhome.repository;

import com.example.myhome.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    
    // 제목으로 검색
    List<Board> findByTitleContaining(String title);
    
    // 작성자로 검색
    List<Board> findByWriter(String writer);
    
    // 조회수 증가
    @Modifying
    @Query("UPDATE Board b SET b.hit = b.hit + 1 WHERE b.seq = :seq")
    void incrementHit(@Param("seq") Long seq);
    
    // 조회수 기준 상위 게시글
    List<Board> findTop10ByOrderByHitDesc();
}
