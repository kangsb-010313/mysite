package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaex.MysiteApplication;
import com.javaex.repository.BoardRepository;
import com.javaex.vo.BoardVO;

@Service
public class BoardService {

    private final MysiteApplication mysiteApplication;
	
	//필드
	@Autowired
	private BoardRepository boardRepository;

    BoardService(MysiteApplication mysiteApplication) {
        this.mysiteApplication = mysiteApplication;
    }
	
	//메소드 일반
	
	//-- 게시판 전체리스트
	public List<BoardVO> exeList() {
		System.out.println("BoardService.exeList()");
		
		List<BoardVO> boardList = boardRepository.boardSelectList();
		
		return boardList;
	}
	
	
	//-- 게시판 전체리스트2(페이징)
	public Map<String, Object> exeList2(int crtPage) {
		System.out.println("BoardService.exeList2()");
		
		System.out.println(crtPage);
		
		////////////////////////////////////////////////////
		/// 리스트 가져오기
		////////////////////////////////////////////////////
		// 한 페이지의 출력 갯수(게시글)
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
		
		List<BoardVO> boardList = boardRepository.boardSelectList2(limitMap);
		
		////////////////////////////////////////////////////
		/// 페이징버튼 (하단 버튼)
		////////////////////////////////////////////////////
		
		//페이지당 버튼갯수
		int pageBtnCount = 5;
		
		// 마지막 버튼 번호 endPageBtnNo
		/*
		 1 2 3 4 5 >
		 
		 1 -> (1, 5) 
		 2 -> (1, 5)
		 3 -> (1, 5)
		 4 -> (1, 5)
		 5 -> (1, 5)
		 6 -> (6, 10)
		 7 -> (6, 10)
		 ...
		 10 -> (6, 10)
		 11 -> (11, 15)
		 
		 1--> 올림(1/5)5 --> 0.2(1)*5 -->5
		 2--> 올림(2/5)5 --> 0.4(1)*5 -->5
		 3--> 올림(3/5)5 --> 0.6(1)*5 -->5
		 4--> 올림(4/5)5 --> 0.8(1)*5 -->5
		 5--> 올림(5/5)5 --> 1.0(1)*5 -->5
		 6--> 올림(6/5)5 --> 1.2(2)*5 -->10
		 11--> 올림(11/5)5 --> 2.2(3)*5 -->15
		 
	 	페이지 마지막 버튼 번호 */
		int endPageBtnNo = ((int)Math.ceil(crtPage/((double)pageBtnCount)))*pageBtnCount;
	
		//시작 버튼 번호 startPageBtnNo
		int startPageBtnNo = (endPageBtnNo - pageBtnCount) + 1;
		 
		//다음 화살표 유무 next
		/* 총 글 수와 연관이 있음, 한 페이지당 글 갯수
	  
	  	1)
	  	전체 글 갯수 51
	  	1 2 3 4 5 > true
	  	한 페이지 당 글 갯수(10)*5 <	전체글갯수(51)	--> true
	  
	  	10*5 50 다음버튼 있어야 함
	  
	  	2)
	  	전체글 갯수 49
	  	1 2 3 4 5 (x)
	  	한 페이지 당 글 갯수(10)*5 >	전체글갯수(49)	--> false
	   
	  	10*5 50 다음버튼 없어야 함
	  	*/
		
		//-- 전체 글 갯수
		int totalCount = boardRepository.selectTotalCount();
		//다음 화살표 
		boolean next = false;
		
		if(listCnt*endPageBtnNo < totalCount) {//한 페이지 당 글 갯수(10)*마지막 버튼 번호(5) <	전체글갯수(51)
			next = true;
		}else { //다음 화살표가 false일 때 마지막 버튼 번호를 다시 계산해야 한다
			//185 --> 19page  185/10 (한 페이지 10개 씩) --> 18.5 --> 19 올림처리한다
			
			endPageBtnNo = (int)Math.ceil(totalCount/((double)listCnt));
			
		}
		
		//이전 화살표 유무 prev
		boolean prev = false;
		if(startPageBtnNo != 1) {
			prev = true;
		}
		
		//모두 묶어서 컨트롤러에 리턴해준다 --> Map 사용
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("boardList", boardList); //리스트
		
		pMap.put("prev", prev); //이전 버튼 유무
		pMap.put("next", next); //다음 버튼 유무
		pMap.put("startPageBtnNo", startPageBtnNo); // 시작버튼 번호
		pMap.put("endPageBtnNo", endPageBtnNo); // 마지막버튼 번호

		/*
		 prev -> 이전 화살표 버튼
		 next -> 다음 화살표 버튼
		 pageBtnCount -> 페이지당 버튼 갯수
		 startPageBtnNo -> 페이지 시작 버튼 번호
		 endPageBtnNo -> 페이지 마지막 버튼 번호
		 */
		return pMap;
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	
	//-- 게시판 전체리스트3(페이징+검색)
	public Map<String, Object> exeList3(int crtPage, String kwd) {
		System.out.println("BoardService.exeList3()");
		
		System.out.println(crtPage);
		System.out.println(kwd);
		
		////////////////////////////////////////////////////
		/// 리스트 가져오기
		////////////////////////////////////////////////////
		// 한 페이지의 출력 갯수(게시글)
		int listCnt = 10;
		
		//시작 번호
		int startRowNo = (crtPage-1)*listCnt;
		
		//두 개의 데이터를 묶는다 --> Map 사용
		Map<String,Object> limitMap = new HashMap<String, Object>();
		limitMap.put("startRowNo", startRowNo);
		limitMap.put("listCnt", listCnt);
		limitMap.put("kwd", kwd);
		
		List<BoardVO> boardList = boardRepository.boardSelectList3(limitMap);
		
		////////////////////////////////////////////////////
		/// 페이징버튼 (하단 버튼)
		////////////////////////////////////////////////////
		
		//페이지당 버튼갯수
		int pageBtnCount = 5;
		
		// 마지막 버튼 번호 endPageBtnNo
		int endPageBtnNo = ((int)Math.ceil(crtPage/((double)pageBtnCount)))*pageBtnCount;
	
		//시작 버튼 번호 startPageBtnNo
		int startPageBtnNo = (endPageBtnNo - pageBtnCount) + 1;
		
		//-- 전체 글 갯수
		int totalCount = boardRepository.selectTotalCountByKwd(kwd);
		//다음 화살표 
		boolean next = false;
		
		if(listCnt*endPageBtnNo < totalCount) {//한 페이지 당 글 갯수(10)*마지막 버튼 번호(5) <	전체글갯수(51)
			next = true;
		}else { //다음 화살표가 false일 때 마지막 버튼 번호를 다시 계산해야 한다
			//185 --> 19page  185/10 (한 페이지 10개 씩) --> 18.5 --> 19 올림처리한다
			
			endPageBtnNo = (int)Math.ceil(totalCount/((double)listCnt));
			
		}
		
		//이전 화살표 유무 prev
		boolean prev = false;
		if(startPageBtnNo != 1) {
			prev = true;
		}
		
		//모두 묶어서 컨트롤러에 리턴해준다 --> Map 사용
		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("boardList", boardList); //리스트
		
		pMap.put("prev", prev); //이전 버튼 유무
		pMap.put("next", next); //다음 버튼 유무
		pMap.put("startPageBtnNo", startPageBtnNo); // 시작버튼 번호
		pMap.put("endPageBtnNo", endPageBtnNo); // 마지막버튼 번호

		/*
		 prev -> 이전 화살표 버튼
		 next -> 다음 화살표 버튼
		 pageBtnCount -> 페이지당 버튼 갯수
		 startPageBtnNo -> 페이지 시작 버튼 번호
		 endPageBtnNo -> 페이지 마지막 버튼 번호
		 */
		return pMap;
	}
	
	
	
	
	
	
	
	
	//////////////////////////////////////////////////////////////
	
	// 글쓰기
	public int exeAdd(BoardVO boardVO) {
		System.out.println("c.exeAdd()");
		
		int count = boardRepository.boardInsert(boardVO);
		
		return count;
	}
	
	//게시판 글 보기, 수정폼
	public BoardVO exeRead(int no) {
		System.out.println("BoardService.exeRead()");
		
		BoardVO boardVO = boardRepository.boardSelectOne(no);
		
		return boardVO;
	}
	
	//게시판 글 수정
	public int exeEdit() {
		System.out.println("BoardService.exeEdit()");
		
		return 0;
	}
	

}
