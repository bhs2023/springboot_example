package com.example.demo.board;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


//객체의 name을 기술하면 스프링부트가 객체를 저장해놓고 이 이름으로 접근 가능하도록 한다
//
@Repository("boardDao")
public class BoardDaoImpl implements BoardDao{
    List<BoardDto> list = new ArrayList<BoardDto>();
    public BoardDaoImpl(){ //생성자에서 가짜 데이터 생성하기
        for(int i=1; i<=12; i++)
        {
            BoardDto dto = BoardDto.builder().
                    id(i+"")
                    .title("제목"+i)
                    .contents("내용"+i)
                    .writer("작성자"+i)
                    .regdate("2024-11-11")
                    .build();
            list.add(dto);
        }
    }

    @Override
    public List<?> getList(BoardDto dto) {
        return list;///객체를 반환해야 한다.
    }

    @Override
    public BoardDto getView(String id) {
        return list.get( Integer.parseInt(id)-1); //객체를 반환한다.
    }

    @Override
    public void insert(BoardDto dto) {
        //id증기
        Integer id = list.size()+1;
        dto.setId(id+"");
        list.add(dto);
    }
}



