package com.login.project.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.login.project.service.SignupService;
import com.login.project.vo.MemberVO;


/**
 * 
 * @controllerName SignupController.java
 * @package com.login.project.controller
 * @date 2023. 1. 20.
 */
@Controller
public class SignupController {
	
	
	@Autowired
	SignupService signupService;
	
	
	/**
	 * 회원가입 페이지
	 * @methodName signupForm
	 * @param 
	 * @return String
	 */
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupForm() {
		
		return "login/signup";
	}
	
	
	/**
	 * 아이디 중복체크
	 * @methodName signupProcess
	 * @param String id
	 * @return String
	 */
	@ResponseBody
	@RequestMapping(value = "/signupform", method = RequestMethod.GET)
	public String signupProcess(String id) throws IOException {
		
		String resultId = "";
		
		resultId =  signupService.searchId(id);
		
		return resultId;
	}//loginProcess
	
	
	
	/**
	 * 회원가입 프로세스
	 * @methodName signupResult
	 * @param MemberVO mVO, Model model
	 * @return String
	 */
	@RequestMapping(value = "/signupprocess", method = RequestMethod.POST)
	public String signupProcess(MemberVO mVO, Model model) throws IOException {
		
		String id, password, name, birthday, gender;
		
		id = mVO.getId();
		password = mVO.getPassword();
		name = mVO.getName();
		birthday = mVO.getBirthday();
		gender = mVO.getGender();
		
		//id 검증
		if(id.equals("") || id.length() < 8 || id.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*") ) {
			
			model.addAttribute("msg","아이디를 확인하세요.");
			return "login/signup";
		}
		    
		//패스워드 검증
		if(password.equals("") || password.length() < 8 ) {
			
			model.addAttribute("msg","패스워드를 확인하세요.");
			return "login/signup";
		}
		
		if(name.equals("") || name.length() < 2 ) {
			
			model.addAttribute("msg","이름을 확인하세요.");
			return "login/signup";
		}
		
		if(birthday.equals("") || birthday.length() != 8 || !birthday.matches("^[0-9]*$")) {
			
			model.addAttribute("msg","생년월일을 확인하세요.");
			return "login/signup";
		}
		
		if( gender == null) {
			
			model.addAttribute("msg","성별을 확인하세요.");
			return "login/signup";
		}
		
		signupService.insertMember(mVO);
		
		model.addAttribute("signupSucYn","Y");
			
		return "login/signup";
	}
	
}
