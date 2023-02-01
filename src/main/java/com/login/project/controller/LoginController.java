package com.login.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.login.project.service.LoginService;
import com.login.project.vo.MemberVO;

/**
 * 
 * @controllerName LoginController.java
 * @package com.login.project.controller
 * @date 2023. 1. 20.
 */
@Controller
@SessionAttributes("memberInfo")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	/**
	 * 로그인 페이지
	 * @methodName loginForm
	 * @param 
	 * @return String
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginForm() {
		
		return "login/form";
	}
	
	
	/**
	 * 로그인 처리
	 * @methodName loginProcess
	 * @param MemberVO mVO, Model model
	 * @return String
	 */
	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public String loginProcess(MemberVO mVO, Model model) {
		
		
		MemberVO memberVO = loginService.searchLoginId(mVO);
		
		if(memberVO != null) { //아이디가 있으면 비밀번호 찾기
			
			memberVO = loginService.searchLoginPass(mVO);
			
			if(memberVO!= null) {
				
				model.addAttribute("memberInfo", memberVO); 
				return "redirect:/postlist"; 
			}else {//비번 틀림
				
				model.addAttribute("loginSucYn","패스워드를 확인하세요."); 
				return "login/form";
			}
			
		}else {
			 
			 model.addAttribute("loginSucYn","아이디를 확인하세요."); 
			 return "login/form"; 
		}

	}
	
	
	/**
	 * 로그아웃 페이지
	 * @methodName signout
	 * @param SessionStatus ss
	 * @return String
	 */
	@RequestMapping(value = "/signout", method = RequestMethod.GET)
	public String signout(SessionStatus ss) {
		
		ss.setComplete();
		
		return "login/form";
	}
	
}
