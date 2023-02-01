package com.login.project.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.login.project.service.SignupService;
import com.login.project.vo.MemberVO;


/**
 * 
 * @controllerName SignupController.java
 * @package com.login.project.controller
 * @date 2023. 1. 20.
 */
@Controller
@SessionAttributes("signupSucYn")
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
	 * @methodName signupDubChk
	 * @param String id
	 * @return String
	 */
	@ResponseBody
	@RequestMapping(value = "/signupform", method = RequestMethod.GET)
	public String signupDubChk(String id) throws IOException {
		
		String resultId = "";
		
		resultId =  signupService.searchId(id);
		
		return resultId;
	}//loginProcess
	
	

	/**
	 * 회원 신규 등록
	 * @methodName signupProcess
	 * @param MemberVO mVO
	 * @return String
	 */
	@ResponseBody
	@RequestMapping(value = "/signupprocess",produces="application/json;charset=UTF-8", method = RequestMethod.POST)
	public String signupProcess(MemberVO mVO) throws IOException {
		
		String id, password, name, birthday, gender;
		
		id = mVO.getId();
		password = mVO.getPassword();
		name = mVO.getName();
		birthday = mVO.getBirthday();
		gender = mVO.getGender();
		
		//id 검증
		if(id.equals("") || id.length() < 8 || id.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*") ) {
			
			//model.addAttribute("msg","아이디를 확인하세요.");
			return "아이디를 확인하세요.";
		}
		    
		//패스워드 검증
		if(password.equals("") || password.length() < 8 ) {
			
			//model.addAttribute("msg","패스워드를 확인하세요.");
			return "패스워드를 확인하세요.";
		}
		
		if(name.equals("") || name.length() < 2 ) {
			
			//model.addAttribute("msg","이름을 확인하세요.");
			return "이름을 확인하세요.";
		}
		
		
		if(!validationDate(birthday)) {
			
			return "생년월일을 확인하세요.";
		}
		
		if(birthday.equals("") || birthday.length() != 8 || !birthday.matches("^[0-9]*$")) {
			
			//model.addAttribute("msg","생년월일을 확인하세요.");
			return "생년월일을 확인하세요.";
		}
		
		if(gender == null || gender == "") {
			
			return "성별을 확인하세요.";
		}
		
		
		if(signupService.insertMember(mVO) == 0) {//회원 등록
			
			return "N";
		}else {
			
			return "Y";
		}
		
	}
	
	
	/**
	 * 회원가입 성공 후 로그인 페이지로 이동
	 * @methodName signupComplete
	 * @param Model model
	 * @return String
	 */
	@RequestMapping(value = "/signupcomplete", method = RequestMethod.GET)
	public ModelAndView signupComplete() {
		
		ModelAndView mav = new ModelAndView();

		RedirectView redirectView = new RedirectView(); // redirect url 설정
		redirectView.setUrl("/");
		redirectView.setExposeModelAttributes(false);

		mav.setView(redirectView);
		mav.addObject("signupSucYn","Y");
		
		return mav;
	}
	
	
	/**
	 * 생년월일 유효 날짜 체크 
	 * @methodName validationDate
	 * @param String checkDate
	 * @return boolean
	 */
	public boolean validationDate(String checkDate){

		try{
			
			SimpleDateFormat  dateFormat = new  SimpleDateFormat("yyyyMMdd");

			dateFormat.setLenient(false);
			dateFormat.parse(checkDate);
			
			return  true;
		}catch (ParseException  e){
		
			return  false;
		}
		
	}

}
