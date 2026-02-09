package com.namgarambooks.myhome.board;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface BoardService {

    List<?> getList(BoardDto dto);
    BoardDto getView(String id);
    boolean insert(BoardDto dto);
    boolean update(BoardDto dto);
    boolean delete(String seq);

}
