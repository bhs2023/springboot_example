package com.namgarambooks.myhome.board;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class BoardDto {
	private String id;
	private String title;
	private String writer;
	private String contents;
	private String regdate;
}
