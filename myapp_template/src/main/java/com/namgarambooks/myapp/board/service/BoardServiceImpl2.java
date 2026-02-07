package com.kosa.myapp.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kosa.myapp.board.domain.BoardDto;
import com.kosa.myapp.board.repository.BoardDao;

import jakarta.annotation.Resource;

@Service("boardService2")
public class BoardServiceImpl2 implements BoardService{

	@Resource(name="boardDao")
	BoardDao boardDao;

	@Override
	public List<BoardDto> getList(BoardDto dto) {
		return boardDao.getList(dto);
	}

	@Override
	public int getTotalCnt(BoardDto dto) {
		
		return boardDao.getTotalCnt(dto);
	}

	@Override
	public BoardDto getView(BoardDto dto) {
		return boardDao.getView(dto);
	}

	@Override
	public void insert(BoardDto dto) {
		boardDao.insert(dto);
	}

	@Override
	public void update(BoardDto dto) {
		boardDao.update(dto);
		
	}

	@Override
	public void delete(BoardDto dto) {
		boardDao.delete(dto);
		
	}
	
}
