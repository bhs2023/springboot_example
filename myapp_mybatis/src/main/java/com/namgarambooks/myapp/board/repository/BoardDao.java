package com.kosa.myapp.board.repository;

import java.util.List;

import com.kosa.myapp.board.domain.BoardDto;

public interface BoardDao {
	List<BoardDto> getList(BoardDto dto);
	int getTotalCnt(BoardDto dto);
	BoardDto getView(BoardDto dto);
	void insert(BoardDto dto);
	void update(BoardDto dto);
	void delete(BoardDto dto);
	
}
