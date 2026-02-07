package com.namgarambooks.myhome.board;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository("boardDao")
public class BoardDaoImpl implements BoardDao{

    List<BoardDto> list = new ArrayList<BoardDto>();

    public BoardDaoImpl() {
        for(int i=1; i<=10; i++) {
            //빌더패턴을 이용해서 객체를 작성한다
            BoardDto dto = BoardDto.builder()
                    .id(i+"")
                    .title("제목"+i)
                    .writer("작성자"+i)
                    .contents("내용"+i)
                    .regdate("2024-08-06")
                    .build();
            list.add(dto); //리스트에 추가한다
        }
    }

    @Override
    public List<?> getList(BoardDto dto) {
        return list;
    }

    @Override
    public Optional<BoardDto> getView(String id) {
        List<BoardDto> result = list.stream().filter(dto->dto.getId().equals(id)).collect(Collectors.toList());
        System.out.println(result);
        //객체가 null 일수도 있다
        if( result.size()>0)
            return Optional.of(result.get(0));
        else
            return Optional.empty();

    }

    @Override
    public boolean insert(BoardDto dto) {
        String id = list.get(list.size()-1).getId();
        int nId = Integer.parseInt(id)+1;
        dto.setId(String.valueOf(nId));
        list.add(dto);
        return true;
    }

    @Override
    public boolean  update(BoardDto dto) {
        List<BoardDto> resultList = list.stream()
                .filter((o)->o.getId().equals(dto.getId()))
                .collect(Collectors.toList());

        if( resultList.size()>0)
        {
            //resultList.set(0, dto);의 형태는 안된다.
            BoardDto tempDto = resultList.get(0);//객체에 대한 참조를 가져온다.

            tempDto.setTitle(dto.getTitle());
            tempDto.setContents(dto.getContents());
            tempDto.setWriter(dto.getWriter());

            return true;
        }

        return false;
    }

    @Override
    public boolean delete(BoardDto dto) {
        //stream 은 삭제 안된다
        List<BoardDto> resultList = list.stream()
                .filter((o)->o.getId().equals(dto.getId()))
                .collect(Collectors.toList());

        if( resultList.size()>0)
        {
            BoardDto removeDto = resultList.get(0);
            list.remove(removeDto);
            return true;
        }

        return false;

    }
}

//        //findFirst는 해당하는 데이터가 있으면 반환하나 없을 경우에는 null 도 반환할 수 있어서 Optional 객체로 반환한다
//        Optional<BoardDto> result = list.stream().findFirst();
//        //해당하는 데이터가 있으면
//        if(result.isPresent()) //데이터가 존재하면 update 를 하자
//        {
//            System.out.println("update 되었음");
//            result.get().setTitle(dto.getTitle());
//            result.get().setContents(dto.getContents());
//            result.get().setWriter(dto.getWriter());
//        }
//        else
//        {
//            System.out.println("update 실패");
//        }
