package com.login.project.service;

import java.io.IOException;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.project.dao.LoginDao;
import com.login.project.vo.LoginVO;

@Service
public class LoginService {
	
	@Autowired
	private LoginDao lDAO;
	
	public LoginVO searchLoginInfo(LoginVO lVO) {
		LoginVO loginVO = null;
		
		try {
			loginVO = lDAO.select(lVO);
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return loginVO;
	}//searchLoginInfo
	
}
