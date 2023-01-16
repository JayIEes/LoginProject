package com.login.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.login.project.service.LoginService;
import com.login.project.vo.LoginVO;

@Controller
@Component
@SessionAttributes("memberNum")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	//로그인 페이지
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String loginForm() {
		
		return "login/form";
	}
	
	//로그인 처리
	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public String loginProcess(LoginVO lVO, Model model) {
		
		int memberNum= 0;
		
		memberNum =  loginService.searchLoginInfo(lVO);
		
		if(memberNum != 0) {
			model.addAttribute("memberNum", memberNum);
			return "post/post";
		}else {
			model.addAttribute("loginSucYn","N");
			return "login/form";
		}

	}//loginProcess
	
}
