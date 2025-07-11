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
	
	//방명록 글 저장하기
	public int exeAdd(GuestbookVO guestbookVO) {
		System.out.println("GuestbookService.exeAdd()");
		
		int count = guestbookRepository.guestbookInsert(guestbookVO);
		
		return count;
	}
	
	//방명록 글 삭제하기
	public int exeRemove(GuestbookVO guestbookVO) {
		System.out.println("GuestbookService.exeRemove()");
		
		int count = guestbookRepository.guestbookDelete(guestbookVO);
		
		return count;
	}
	
	//--방명록 저장하기 key 조회(ajax)
	public GuestbookVO exeAddKey(GuestbookVO guestbookVO) {
		System.out.println("GuestbookService.exeAddKey");
		
		int count = guestbookRepository.guestbookInsertKey(guestbookVO); //저장키값 가져오기
		
		//추가된 방명록 글 가져오기
		GuestbookVO gVO = guestbookRepository.guestbookSelectOne(guestbookVO.getNo());
		
		return gVO;
	}
	
	

}
