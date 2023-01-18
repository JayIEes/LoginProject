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
	
	public MemberVO searchLoginInfo(MemberVO mVO) {
		MemberVO memberVO = null;
		
		try {
			memberVO = lDAO.selectMember(mVO);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return memberVO;
	}//searchLoginInfo
	
}
