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

    // 1. 쿼리 메소드 방식 (추천: 직관적)
    // 연관 객체의 필드는 '_'를 사용하여 구분할 수 있습니다. (writer 객체의 username 필드)
    List<Board> findByWriter_UsernameContaining(String username);

    // 2. JPQL 방식 (추천: 복잡한 조인 제어)
    @Query("select b from Board b where b.writer.username like %:username%")
    List<Board> findByMemberName(@Param("username") String username);

    // --- 기존 코드 유지 ---
    @Query("select b from Board b join fetch b.writer") // 필드명 반영
    List<Board> findAllWithMember();

    @Modifying
    @Query("UPDATE Board b SET b.hit = b.hit + 1 WHERE b.seq = :seq")
    void incrementHit(@Param("seq") Long seq);
}