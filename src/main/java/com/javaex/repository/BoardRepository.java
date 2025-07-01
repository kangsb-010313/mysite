package com.javaex.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BoardVO;

@Repository
public class BoardRepository {
	
	//필드
	@Autowired
	private SqlSession sqlSession;
	
	//메소드 일반
	
	//--전체 리스트 가져오기(게시판리스트)
	public List<BoardVO> boardSelectList() {
		System.out.println("BoardRepository.boardSelectList()");
		
		List<BoardVO> boardList = sqlSession.selectList("board.selectList");
		
		return boardList;
	}
	
	//--전체 리스트 가져오기2(페이징)
	public List<BoardVO> boardSelectList2(Map<String, Integer> limitMap) {
		System.out.println("BoardRepository.boardSelectList2()");
		
		List<BoardVO> boardList = sqlSession.selectList("board.selectList2", limitMap);
		
		return boardList;
	}
	
	//전체글 갯수 (페이징)
	public int selectTotalCount() {
		System.out.println("BoardRepository.selectTotalCount()");
		
		int totlaCount = sqlSession.selectOne("board.selectTotalCount");
		
		return totlaCount;
	}
	
	
	
	
	
	
	
	//글쓰기 
	public int boardInsert(BoardVO boardVO) {
		System.out.println("BoardRepository.boardInsert");
		
		int count = sqlSession.insert("board.insert", boardVO);
		
		return count;
	}

}
