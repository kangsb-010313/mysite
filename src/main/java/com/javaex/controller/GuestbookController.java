package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.GuestbookService;
import com.javaex.vo.GuestbookVO;

@Controller
public class GuestbookController {
	
	//필드
	@Autowired
	private GuestbookService guestbookService;

	//메소드 일반
	//-- 방명록 전체 리스트 가져오기
	@RequestMapping(value="/guestbook/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("GuestbookController.list()");
		
		List<GuestbookVO> guestbookList = guestbookService.exeList();
		
		model.addAttribute("gList", guestbookList);
		
		return "guestbook/addlist";
	}
	
	//-- 방명록 글 저장
	/*
	public String add() {
		System.out.println("GuestbookController.add()");
		
		
		
		return "";
	}
	*/
	
}
