package com.login.project.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import com.login.project.vo.MemberVO;
import com.login.project.vo.SignupVO;


@Repository
public class SignupDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	 
	//아이디 중복체크
	 public String selectId(String id) throws PersistenceException, IOException{
		 
		 String resultId="";
		 
		 resultId = sqlSessionTemplate.selectOne("mapper.login.signupMapper.selectId", id);
		
		 System.out.println(resultId+"=============================");
		 
		 return resultId;
	 }
	 
	 //회원 신규등록
	 public int insertNewMember(SignupVO sVO) throws PersistenceException, IOException{
		 
		 int cnt=0;
		 
		 cnt = sqlSessionTemplate.insert("mapper.login.signupMapper.insertMember", sVO);
		 
		 return cnt;
	 }
	 
}
