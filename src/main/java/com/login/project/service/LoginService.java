package com.login.project.service;

import java.io.IOException;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.project.dao.LoginDao;
import com.login.project.vo.MemberVO;

@Service
public class LoginService {
	
	@Autowired
	private LoginDao lDAO;
	
	public MemberVO searchLoginId(MemberVO mVO) {
		MemberVO memberVO = null;
		
		try {
			memberVO = lDAO.selectId(mVO); //로그인 (ID)
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return memberVO;
	}//searchLoginInfo
	
	
	
	public MemberVO searchLoginPass(MemberVO mVO) {
		MemberVO memberVO = null;
		
			try {
				memberVO = lDAO.selectPass(mVO);
			} catch (PersistenceException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} //로그인 (ID)
			
		return memberVO;
	}//searchLoginInfo
	
	
}
