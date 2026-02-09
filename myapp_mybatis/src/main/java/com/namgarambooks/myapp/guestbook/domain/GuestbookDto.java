package com.kosa.myapp.guestbook.domain;

import com.kosa.myapp.common.BaseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GuestbookDto extends BaseDto{
	private String seq="";
	private String title="";
	private String writer="";
	private String contents="";
	private String wdate="";
	private String hit="";	
}




