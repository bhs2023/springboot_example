package com.example.demo.board;

import java.util.List;

public interface BoardService {
    List<?> getList(BoardDto dto);
    BoardDto getView(String id);
    void insert(BoardDto dto);
}
