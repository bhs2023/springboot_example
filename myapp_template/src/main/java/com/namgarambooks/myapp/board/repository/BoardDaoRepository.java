package com.kosa.myapp.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosa.myapp.board.domain.BoardDto;

//mapper 를 사용해 보자 
//@Repository("boardDao")
@Mapper
public interface BoardDaoRepository {
	
	List<BoardDto> Board_getList(BoardDto dto);
	int Board_getTotalCnt(BoardDto dto);
	BoardDto Board_getView(BoardDto dto);
	void Board_insert(BoardDto dto);
	void Board_update(BoardDto dto);	
	void Board_delete(BoardDto dto);	
}
