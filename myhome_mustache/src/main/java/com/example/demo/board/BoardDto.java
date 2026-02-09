package com.example.demo.board;


import jdk.jshell.Snippet;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor //기본생성자
@Builder
@AllArgsConstructor
@ToString
/*
   BoardDto dto = new BoardDto("1", "제목", "작성자", "내용", "2024-11-11");

   BoardDto dto = BoardDto.builder()
                .id("1")
                .title("제목1")
                .build();
 */
public class BoardDto {
    private String id;
    private String title;
    private String writer;
    private String contents;
    private String regdate;

//    public BoardDto(String id, String title, String writer, String contents, String regdate) {
//        this.id = id;
//        this.title = title;
//        this.writer = writer;
//        this.contents = contents;
//        this.regdate = regdate;
//    }
}
