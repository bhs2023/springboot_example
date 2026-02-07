package com.kosa.myapp.guestbook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kosa.myapp.guestbook.domain.GuestbookDto;
import com.kosa.myapp.guestbook.repository.GuestbookDao;

import jakarta.annotation.Resource;

@Service("guestbookService")
public class GuestbookServiceImpl implements GuestbookService{
	@Resource(name="guestbookDao")
	GuestbookDao dao;

	@Override
	public List<GuestbookDto> getList(GuestbookDto dto) {
		
		return dao.getList(dto);
	}

	@Override
	public void insert(GuestbookDto dto) {
		dao.insert(dto);
	}

	@Override
	public void update(GuestbookDto dto) {
		dao.update(dto);
	}

	@Override
	public void delete(GuestbookDto dto) {
		dao.delete(dto);
	}

	@Override
	public GuestbookDto getView(GuestbookDto dto) {
		
		return dao.getView(dto);
	}

	@Override
	public int getTotalCnt(GuestbookDto dto) {
		
		return dao.getTotalCnt(dto);
	}
	
	
}
