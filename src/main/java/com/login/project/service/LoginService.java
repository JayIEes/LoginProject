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
	
	public int searchLoginInfo(LoginVO lVO) {
		int num = 0;
		
		try {
			if(lDAO.select(lVO) != null) {
				num = lDAO.select(lVO);
			}
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return num;
	}//searchLoginInfo
	
}
