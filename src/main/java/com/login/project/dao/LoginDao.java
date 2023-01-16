package com.login.project.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.login.project.vo.LoginVO;


@Repository
public class LoginDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	 
	//로그인 
	 public Integer select(LoginVO lVO) throws PersistenceException, IOException{
		 
		 Integer num = 0;
		 
		 //1. 설정용 XML에 스트림 연결
		 num = sqlSessionTemplate.selectOne("mapper.login.loginMapper.selectMemberInfo", lVO);
		
		 return num;
	 }
	 
}
