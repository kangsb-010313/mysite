package com.javaex.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.BoardService;
import com.javaex.vo.BoardVO;
import com.javaex.vo.UserVO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping(value="/board")
public class BoardController {
	
	//필드
	@Autowired
	private BoardService boardService;
	
	//메소드 일반
	
	//-- 게시판 전체 리스트
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("BoardController.list()");
		
		List<BoardVO> boardList = boardService.exeList();
		System.out.println(boardList);
		
		model.addAttribute("boardList", boardList);
		
		return"board/list";
	}
	
	//-- 게시판 전체 리스트2(페이징)
	@RequestMapping(value="/list2", method= {RequestMethod.GET, RequestMethod.POST})
	public String list2(@RequestParam(value="crtpage", required=false, defaultValue="1") int crtPage, 
						Model model) {
		System.out.println("BoardController.list2()");
		
		Map<String, Object> pMap = boardService.exeList2(crtPage);

		model.addAttribute("pMap", pMap);
		System.out.println(pMap);
		
		return "board/list2";
	}
	
	
	
	//-- 글쓰기폼
	@RequestMapping(value="/writeform", method= {RequestMethod.GET, RequestMethod.POST})
	public String writeForm(HttpSession session, Model model) {
		System.out.println("BoardController.writeForm()");
		
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		
		if(authUser==null) {
			return "redirect:/user/loginform";
		}
		model.addAttribute("authUser", authUser);
		
		return "board/writeForm";
	}

	
	
	//-- 글쓰기
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(BoardVO boardVO, HttpSession session){
		System.out.println("BoardController.write()");
		
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		
		if(authUser==null) {
			return "redirect:/user/loginform";
		}
		
		int no = authUser.getNo();
		
		boardVO.setUserNo(no);
		
		boardService.exeAdd(boardVO);
		
		return "redirect:/board/list2";
	}

	//-- 수정폼
	
	//-- 수정
	
	//-- 삭제

}
