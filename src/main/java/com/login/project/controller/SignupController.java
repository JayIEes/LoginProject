package com.login.project.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.login.project.service.SignupService;
import com.login.project.vo.SignupVO;


@Controller
public class SignupController {
	
	@Autowired
	SignupService signupService;
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupForm() {
		
		return "login/signup";
	}
	
	
	
	@RequestMapping(value = "/signupform", method = RequestMethod.GET)
	public String signupProcess(String id) throws IOException { //아이디 중복
		
		String resultId = "";
		
		resultId =  signupService.searchId(id);
		
		return resultId;
	}//loginProcess
	
	
	
	@RequestMapping(value = "/signupComplete", method = RequestMethod.POST)
	public String signupResult(SignupVO sVO, Model model) throws IOException {
		int cnt=0;
		
		cnt=signupService.insertMember(sVO);
		
		if(cnt==0) {//회원가입 실패
			
			model.addAttribute("signupSucYn","N");
			
			return "login/signup";
		}else { //회원가입 성공
			model.addAttribute("signupSucYn","Y");
			return "signup/signup_result";
		}
		
	}
	
}
