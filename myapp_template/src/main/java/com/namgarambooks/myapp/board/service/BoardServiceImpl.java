package com.kosa.myapp.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.myapp.board.domain.BoardDto;
import com.kosa.myapp.board.repository.BoardDaoRepository;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardDaoRepository boardDao;

	@Override
	public List<BoardDto> getList(BoardDto dto) {
		return boardDao.Board_getList(dto);
	}

	@Override
	public int getTotalCnt(BoardDto dto) {
		
		return boardDao.Board_getTotalCnt(dto);
	}

	@Override
	public BoardDto getView(BoardDto dto) {
		return boardDao.Board_getView(dto);
	}

	@Override
	public void insert(BoardDto dto) {
		boardDao.Board_insert(dto);
	}

	@Override
	public void update(BoardDto dto) {
		boardDao.Board_update(dto);
		
	}

	@Override
	public void delete(BoardDto dto) {
		boardDao.Board_delete(dto);
		
	}
	
}
