package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.repository.GuestbookRepository;
import com.javaex.vo.GuestbookVO;

@Service
public class GuestbookService {
	
	//필드
	@Autowired
	private GuestbookRepository guestbookRepository;
	
	// 전체 리스트 가져오기
	public List<GuestbookVO> exeList(){
		System.out.println("GuestbookService.exeList()");
		
		List<GuestbookVO> guestbookList = guestbookRepository.guestbookSelect();
		
		return guestbookList;
	}
	
	

}
