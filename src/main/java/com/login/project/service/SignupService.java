package com.login.project.service;

import java.io.IOException;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.project.dao.LoginDao;
import com.login.project.dao.SignupDao;
import com.login.project.vo.MemberVO;
import com.login.project.vo.SignupVO;

@Service
public class SignupService {
	
	@Autowired
	private SignupDao sDAO;
	
	
	//아이디 중복체크
	public String searchId(String id) throws IOException {
		
		
		String resultId = "";
		
		try {
			resultId = sDAO.selectId(id); 
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return resultId;
	}
	
	
	//회원가입 회원 신규 등록
	public int insertMember(MemberVO mVO) throws IOException {
		
		int resultCnt = 0;
		
		try {
			resultCnt = sDAO.insertNewMember(mVO); 
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return resultCnt;
	}
	
}
