package com.kosa.myapp.guestbook.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kosa.myapp.guestbook.domain.GuestbookDto;
 
@Repository("guestbookDao")
public class GuestbookDaoImple implements GuestbookDao{
        
	@Autowired 
	SqlSessionTemplate sm;
	
	@Override
	public List<GuestbookDto> getList(GuestbookDto dto) {
		
		return sm.selectList("Guestbook_getList", dto);
	}

	@Override
	public void insert(GuestbookDto dto) {
		sm.insert("Guestbook_insert", dto);
	}

	@Override
	public void update(GuestbookDto dto) {
		sm.insert("Guestbook_update", dto);
	}

	@Override
	public void delete(GuestbookDto dto) {
		sm.insert("Guestbook_delete", dto);
	}

	@Override
	public GuestbookDto getView(GuestbookDto dto) {
		return sm.selectOne("Guestbook_getView", dto);
	}

	@Override
	public int getTotalCnt(GuestbookDto dto) {
		return sm.selectOne("Guestbook_getTotalCnt", dto);
	}

	

}



