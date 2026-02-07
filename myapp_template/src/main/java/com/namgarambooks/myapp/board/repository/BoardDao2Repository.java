package com.kosa.myapp.board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosa.myapp.board.domain.BoardDto;

@Repository("boardDao2")
public class BoardDao2Repository implements BoardDao{
	@Autowired 
	SqlSessionTemplate sm;

	@Override
	public List<BoardDto> getList(BoardDto dto) {
		
		return sm.selectList("Board_getList", dto);
	}

	@Override
	public int getTotalCnt(BoardDto dto) {	
		return sm.selectOne("Board_getTotalCnt", dto);
	}

	@Override
	public BoardDto getView(BoardDto dto) {
		return sm.selectOne("Board_getView", dto);
	}

	@Override
	public void insert(BoardDto dto) {
		sm.insert("Board_insert", dto);
	}

	@Override
	public void update(BoardDto dto) {
		sm.update("Board_insert", dto);	
	}

	@Override
	public void delete(BoardDto dto) {
		sm.insert("Board_delete", dto);
	}
}
