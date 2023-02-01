package com.login.project.dao;

import java.io.IOException;

import org.apache.ibatis.exceptions.PersistenceException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.login.project.vo.MemberVO;


@Repository
public class SignupDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	 
	 /**
	 * 아이디 중복체크
	 * @methodName selectId
	 * @param String id
	 * @return String
	 */
	public String selectId(String id) throws PersistenceException, IOException{
		 
		 String resultId="";
		
		 resultId = sqlSessionTemplate.selectOne("mapper.login.signupMapper.selectId", id);
		
		 return resultId;
	 }
	 
	 
	 /**
	 * 회원 신규등록
	 * @methodName insertNewMember
	 * @param MemberVO mVO
	 * @return int
	 */
	public int insertNewMember(MemberVO mVO) throws PersistenceException, IOException{
		 
		 int cnt=0;
		 
		 try {
			 
			 cnt = sqlSessionTemplate.insert("mapper.login.signupMapper.insertMember", mVO);
		 } catch (DataIntegrityViolationException e) {
			
			return 0;
		 }
		 
		 return cnt;
	 }
	 
}
