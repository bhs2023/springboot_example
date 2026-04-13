package com.namgarambooks.myhome.todo;

import java.util.List;
import java.util.Optional;

public interface TodoDao {
    public List<TodoDto> getList(TodoDto dto);
    Optional<TodoDto> getView(int id);
    boolean insert(TodoDto dto);
    boolean update(TodoDto dto);
    boolean delete(int id);
}
