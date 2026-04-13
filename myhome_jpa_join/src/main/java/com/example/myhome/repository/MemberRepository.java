package com.example.myhome.repository;

import com.example.myhome.entity.Board;
import com.example.myhome.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // Fetch Join: Member와 연관된 boards를 한 번의 쿼리로 조회
    @Query("select m from Member m join fetch m.boards")
    List<Member> findAllWithBoards();
}
