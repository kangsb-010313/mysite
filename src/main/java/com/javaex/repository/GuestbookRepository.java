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
	

}
