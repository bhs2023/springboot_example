package com.namgarambooks.myhome.board;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service("boardService")
public class BoardServiceImpl implements BoardService{

//    @Autowired
//    BoardDao boardDao;

//
//   @Resource(name="boardDao")
//   BoardDao boardDao;
    private final BoardDao boardDao;

    // @Autowired 어노테이션을 사용하지 않아도 Spring이 자동으로 주입된다
    public BoardServiceImpl(BoardDao boardDao) {
        this.boardDao = boardDao;
    }



    @Override
    public List<?> getList(BoardDto dto) {
        return boardDao.getList(dto);
    }

    @Override
    public Optional<BoardDto> getView(String id) {

        return boardDao.getView(id);
    }

    @Override
    public boolean insert(BoardDto dto) {
        return  boardDao.insert(dto);
    }

    @Override
    public boolean update(BoardDto dto) {

        return boardDao.update(dto);
    }

    @Override
    public boolean delete(BoardDto dto) {

        return boardDao.delete(dto);
    }
}
