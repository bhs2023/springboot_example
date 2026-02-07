package com.namgarambooks.myhome.todo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TodoDto {
    int id; //식별값
    String date; //시간
    String todo; //할일
}
