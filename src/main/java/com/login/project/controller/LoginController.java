package com.login.project.controller;

import java.net.http.HttpRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.login.project.service.LoginService;
import com.login.project.vo.MemberVO;

@Controller
@SessionAttributes("memberInfo")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	//로그인 페이지
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginForm() {
		
		System.out.println("main page=================================");
		return "login/form";
	}
	
	//로그인 처리
	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public String loginProcess(MemberVO mVO, Model model) {
		
		//MemberVO loginVO  =  loginService.searchLoginInfo(mVO);
		
		
		 if(mVO != null) { model.addAttribute("memberInfo", mVO); 
		 	return "redirect:/post"; 
		 }else {
			 model.addAttribute("loginSucYn","N"); return "login/form"; }
		 
		
	}
	
	
	//로그아웃 페이지
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public String signout(SessionStatus ss) {
		ss.setComplete();
		
		return "login/form";
	}
	
}
