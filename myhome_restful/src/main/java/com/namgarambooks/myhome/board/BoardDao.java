package com.namgarambooks.myhome.board;

import java.util.List;
import java.util.Optional;

public interface BoardDao {

    List<?> getList(BoardDto dto);
    Optional<BoardDto> getView(String id);
    boolean insert(BoardDto dto);
    boolean update(BoardDto dto);
    boolean delete(BoardDto dto);

}
