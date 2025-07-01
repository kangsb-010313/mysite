package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.repository.BoardRepository;
import com.javaex.vo.BoardVO;

@Service
public class BoardService {
	
	//필드
	@Autowired
	private BoardRepository boardRepository;
	
	//메소드 일반
	
	//-- 게시판 전체리스트
	public List<BoardVO> exeList() {
		System.out.println("BoardService.exeList()");
		
		List<BoardVO> boardList = boardRepository.boardSelectList();
		
		return boardList;
	}
	//-- 게시판 전체리스트2(페이징)
	public List<BoardVO> exeList2(int crtPage) {
		System.out.println("BoardService.exeList2()");
		
		System.out.println(crtPage);
		
		////////////////////////////////////////////////////
		/// 리스트 가져오기
		////////////////////////////////////////////////////
		// 한 페이지의 출력 갯수
		int listCnt = 10;
		
		//시작 번호
		/*
		 1 -> (0, 10), 2 -> (11, 20), 3 -> (21, 30) 사람
		 1--> (0, 10), 2--> (10, 10), 3--> (20, 10) mysql
		 startRowNo = (crtPage-1)*listCnt
		 */
		int startRowNo = (crtPage-1)*listCnt;
		
		//두 개의 데이터를 묶는다 --> Map 사용
		Map<String, Integer> limitMap = new HashMap<String, Integer>();
		limitMap.put("startRowNo", startRowNo);
		limitMap.put("listCnt", listCnt);
		
		boardRepository.boardSelectList2(limitMap);
		
		return null;
	}
	
	// 글쓰기
	public int exeAdd(BoardVO boardVO) {
		System.out.println("BoardService.exeAdd");
		
		int count = boardRepository.boardInsert(boardVO);
		
		return count;
	}
	
}
