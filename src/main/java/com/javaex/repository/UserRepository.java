package com.javaex.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVO;

@Repository
public class UserRepository {
	
	//필드
	@Autowired
	private SqlSession sqlSession;
	
	
	//메소드 일반
	//--user저장(회원가입)
	public int userInsert(UserVO userVO) {
		
		System.out.println("UserRepository.userInsert()");

		int count = sqlSession.insert("user.insert", userVO);
		
		return count;
		
	}
	
	
	//--user정보 가져오기 (id password)s
	public void userSelectOneByIdPw(UserVO userVO) {
		
		System.out.println("UserRepository.userSelectOneByIdPw()");
	
		System.out.println(userVO); //id, pw --> 0x999
		
		UserVO authUser = sqlSession.selectOne("user.selectOneByIdPw", userVO); //다 들어있음 (정보) --> 0x567
		System.out.println(authUser); 
		
		
	}

}
