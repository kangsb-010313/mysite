package com.javaex.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GuestbookVO;

@Repository
public class GuestbookRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	//전체 리스트 가져오기
	public List<GuestbookVO> guestbookSelect(){
		
		System.out.println("GuestbookRepository.guestbookSelect()");
		
		List<GuestbookVO> guestbookList = sqlSession.selectList("guestbook.selectList");

		return guestbookList;
	}
	

	//방명록 글 저장하기
	public int guestbookInsert(GuestbookVO guestbookVO) {
		System.out.println("GuestbookRepository.guestbookInsert()");
		
		int count = sqlSession.insert("guestbook.insert", guestbookVO);
		
		return count;
	}
	
	//방명록 글 삭제하기
	public int guestbookDelete(GuestbookVO guestbookVO) {
		System.out.println("GuestbookRepository.guestbookDelete()");
		
		int count = sqlSession.delete("guestbook.delete", guestbookVO);
		
		return count;
		
		
	}
	
}
