package com.example.demo.board;

import java.util.List;

public interface BoardDao {
    List<?> getList(BoardDto dto);
    BoardDto getView(String id);
    void insert(BoardDto dto);

}
