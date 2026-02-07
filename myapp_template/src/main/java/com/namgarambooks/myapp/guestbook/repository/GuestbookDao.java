package com.kosa.myapp.guestbook.repository;

import java.util.List;

import com.kosa.myapp.guestbook.domain.GuestbookDto;

public interface GuestbookDao {
	List<GuestbookDto> getList(GuestbookDto dto);
	int getTotalCnt(GuestbookDto dto);
	void insert(GuestbookDto dto);
	void update(GuestbookDto dto);
	void delete(GuestbookDto dto);
	GuestbookDto getView(GuestbookDto dto);
}
