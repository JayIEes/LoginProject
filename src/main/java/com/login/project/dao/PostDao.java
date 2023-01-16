package com.login.project.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.login.project.vo.LoginVO;
import com.login.project.vo.PostVO;
import com.login.project.vo.SignupVO;


@Repository
public class PostDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	 
	
	//게시글 등록 
	public int insertPost(PostVO pVO) throws PersistenceException, IOException{
		 
		 int resultCnt = 0 ;
		 
		 resultCnt = sqlSessionTemplate.insert("mapper.post.postMapper.insertPost", pVO);
		
		 return resultCnt;
	 }
	 
}
