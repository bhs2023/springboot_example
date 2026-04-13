package com.namgarambooks.myhome.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{

    final TodoDao todoDao;



    @Override
    public List<TodoDto> getAllTodos() {

        return todoDao.getList(null);  // TodoDao의 getList() 메서드 호출
    }

    @Override
    public Optional<TodoDto> getTodoById(int id) {
        return todoDao.getView(id);
    }

    // 새 Todo 추가
    @Override
    public boolean insert(TodoDto dto) {
        return todoDao.insert(dto);  // TodoDao의 insert() 메서드 호출
    }

    // Todo 수정
    @Override
    public boolean update(TodoDto dto) {
        return todoDao.update(dto);  // TodoDao의 update() 메서드 호출
    }

    // Todo 삭제
    @Override
    public boolean delete(int id) {
        return todoDao.delete(id);  // TodoDao의 delete() 메서드 호출
    }
}
