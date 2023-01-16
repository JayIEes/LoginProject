package com.login.project.service;

import java.io.IOException;

import org.apache.ibatis.exceptions.PersistenceException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.project.dao.LoginDao;
import com.login.project.dao.PostDao;
import com.login.project.dao.SignupDao;
import com.login.project.vo.LoginVO;
import com.login.project.vo.PostVO;
import com.login.project.vo.SignupVO;

@Service
public class PostService {
	
	@Autowired
	private PostDao pDAO;
	
	//게시글 등록 서비스
	public int insertPost(PostVO pVO) throws IOException {
		
		int resultCnt = 0;
		
		try {
			resultCnt = pDAO.insertPost(pVO); 
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return resultCnt;
	}//searchLoginInfo
	
	
}
