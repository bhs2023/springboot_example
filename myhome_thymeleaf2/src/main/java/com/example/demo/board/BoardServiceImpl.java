package com.example.demo.board;

import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor  // public BoardServiceImpl(BoardDao dao){this.boardDao=dao}
@Service
public class BoardServiceImpl implements BoardService{
    @Resource(name="boardDao")
    BoardDao boardDao2;

    private final BoardDao boardDao;
    //final 이 반드시 붙어야 @RequiredArgsConstructor
    //가 적절한 생성자를 만들어 준다

    @Override
    public List<?> getList(BoardDto dto) {
        return boardDao.getList(dto);
    }

    @Override
    public BoardDto getView(String id) {
        return boardDao.getView(id);
    }

    @Override
    public void insert(BoardDto dto) {
        boardDao.insert(dto);
    }
}
