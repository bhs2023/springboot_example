package com.namgarambooks.myhome.todo;

import com.namgarambooks.myhome.todo.TodoDao;
import com.namgarambooks.myhome.todo.TodoDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TodoDaoImpl implements TodoDao {
    private List<TodoDto> list = new ArrayList<>();

    public TodoDaoImpl(){
        list.add(new TodoDto(1, "2025-01-01", "새배가기"));
        list.add(new TodoDto(2, "2025-01-02", "프로젝트 준비하기"));
        list.add(new TodoDto(3, "2025-01-03", "친구랑 영화관 가기"));
        list.add(new TodoDto(4, "2025-01-04", "헬스하기"));
    }

    @Override
    public List<TodoDto> getList(TodoDto dto) {
        return list;
    }


    @Override
    public Optional<TodoDto> getView(int id) {
        Optional<TodoDto> result =  list.stream()
                .filter(o -> o.getId() == id)
                .findFirst();
        System.out.println(result.getClass());
        return result;
    }

    @Override
    public boolean insert(TodoDto dto) {
        int maxId = list.stream().mapToInt(TodoDto::getId).max().orElse(0);
        dto.setId(maxId + 1);
        return list.add(dto);
    }

    @Override
    public boolean update(TodoDto dto) {
        return list.stream()
                .filter(o -> o.getId() == dto.getId())
                .findFirst()
                .map(existingTodo -> {
                    existingTodo.setTodo(dto.getTodo());
                    existingTodo.setDate(dto.getDate());
                    return true;
                }).orElse(false);
    }

    @Override
    public boolean delete(int id) {
        return list.removeIf(o -> o.getId() == id);
    }
}
