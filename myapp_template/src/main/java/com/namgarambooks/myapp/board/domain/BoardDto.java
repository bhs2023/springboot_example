package com.kosa.myapp.board.domain;

import com.kosa.myapp.common.BaseDto;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto extends BaseDto{
	private String seq="";
	private String title="";
	private String writer="";
	private String contents="";
	private String filename="";
	private String image_url="";
	private String wdate="";
	private String rnum="";
	private String hit="0";
}
