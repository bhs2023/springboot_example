package com.namgarambooks.myhome.todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    List<TodoDto> getAllTodos();

    // 특정 Todo 조회
    Optional<TodoDto> getTodoById(int id);
    boolean insert(TodoDto dto);
    boolean update(TodoDto dto);
    boolean delete(int id);
}
