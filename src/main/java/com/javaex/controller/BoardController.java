package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	//-- 전체 리스트 가져오기
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("BoardController.list()");
		
		List<BoardVO> boardList = boardService.exeList();
		System.out.println(boardList);
		
		model.addAttribute("boardList", boardList);
		
		return"board/list";
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
	@RequestMapping(value="/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String add(BoardVO boardVO, HttpSession session){
		System.out.println("BoardController.add()");
		
		UserVO authUser = (UserVO)session.getAttribute("authUser");
		
		int no = authUser.getNo();
		
		boardVO.setUserNO(no);
		
		boardService.exeAdd(boardVO);
		
		return "";
	}
	/*
    public String add(BoardVO boardVo, HttpSession session) {
        UserVO authUser = (UserVO)session.getAttribute("authUser");
        if(authUser == null) {
            return "redirect:/user/login";
        }
        boardVo.setUserNo(authUser.getNo()); // 세션에서 userNo 꺼내서 저장
        boardService.exeAdd(boardVo);
        return "redirect:/board/list"; // 글 목록으로 이동
    }
	*/
	//-- 수정폼
	
	//-- 수정
	
	//-- 삭제

}
