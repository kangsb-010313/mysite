package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVO;

@Controller
public class UserController {
	
	//필드
	@Autowired
	private UserService userService;

	//메소드일반
	//회원가입폼
	@RequestMapping(value="/user/joinform", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinForm() {
		System.out.println("UserController.joinForm()");
		
		return "user/joinForm";
		
	}
	
	//회원가입
	@RequestMapping(value="/user/joinok", method= {RequestMethod.GET, RequestMethod.POST})
	public String joinOk(@ModelAttribute UserVO userVO) {
		System.out.println("UserController.joinOk()");
		
		userService.exeJoin(userVO);
		
		return "user/joinok";
	}
	
	
}
