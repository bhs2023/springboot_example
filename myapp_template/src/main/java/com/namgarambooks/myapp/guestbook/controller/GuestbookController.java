package com.kosa.myapp.guestbook.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kosa.myapp.guestbook.domain.GuestbookDto;
import com.kosa.myapp.guestbook.service.GuestbookService;

import jakarta.annotation.Resource;

@RestController 
public class GuestbookController {
	@Resource(name="guestbookService")
	GuestbookService service;
	
	//guestbook/list/1 
	
	@GetMapping("/guestbook/list/{pg}")
	public HashMap<String, Object> getList(@PathVariable("pg")int pg, 
			GuestbookDto dto)
	{
		HashMap<String, Object> resultMap = new 
				HashMap<String, Object>();
	
		dto.setPg(pg);
		
		resultMap.put("totalCnt", service.getTotalCnt(dto));
		resultMap.put("data", service.getList(dto));
		
		return resultMap;	
	}
	
	/*
	 *  { "title":"새로운 글", "writer":"test3", 
	 *     "contents":"내용"}
	 *    
	 */
	
	//post 방식 전송은 브라우저로 안됨
	//json형태로 데이터를 수신하고 싶다면, 매개변수 앞에 @RequestBody 
	//를 써야하고 HashMap 이나 Dto 객체로 받아야 한다 
	@PostMapping("/guestbook/insert")
	public HashMap<String, String> guestbook_insert(
			@RequestBody GuestbookDto dto)
	{
		HashMap<String, String> resultMap = new 
				HashMap<String, String>();
		try
		{
			service.insert(dto);
			resultMap.put("result", "success");
		}
		catch(Exception e)
		{
			e.printStackTrace();//실제운영시에는 없애야 한다 
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	
	// /guestbook/view/2   /guestbook/view?seq=2 (옛날방식)  둘다 GET방식 - 간단하고 보안이 필요없는 데이터 보낼때
	@GetMapping("/guestbook/view/{seq}")
	public HashMap<String, Object>guestbook_getView(@PathVariable("seq")String seq, 
			GuestbookDto dto)
	{
		HashMap<String, Object> resultMap = new 
				HashMap<String, Object>();
	
		dto.setSeq(seq);
		try
		{
			resultMap.put("result", "success");
			resultMap.put("msg", "성공");
			resultMap.put("data", service.getView(dto));
			
		}
		catch(Exception ex)
		{
			resultMap.put("result", "fail");
			resultMap.put("msg", "실패");
		}
		
		return resultMap;	
	}
}




