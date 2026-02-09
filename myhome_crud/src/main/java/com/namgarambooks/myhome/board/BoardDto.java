package com.namgarambooks.myhome.board;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class BoardDto {
	private String seq;
	private String title;
	private String writer;
	private String contents;
	private String filename;
	private String imageurl;
	private String wdate;
	private String rnum="";
	private String hit="0";

}
