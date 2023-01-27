package com.login.project.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.login.project.vo.MemberVO;


@Repository
public class LoginDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	 
	//로그인 
	 public MemberVO selectId(MemberVO mVO) throws PersistenceException, IOException{
		 MemberVO memberVO;
		 
		 memberVO = sqlSessionTemplate.selectOne("mapper.login.loginMapper.selectId", mVO);
		 
		 return memberVO;
	 }
	 
	 
	 public MemberVO selectPass(MemberVO mVO) throws PersistenceException, IOException{
		 MemberVO memberVO;
		 
		 memberVO = sqlSessionTemplate.selectOne("mapper.login.loginMapper.selectPass", mVO);
		 
		 return memberVO;
	 }
	 
}
