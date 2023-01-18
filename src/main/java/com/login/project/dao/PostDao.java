package com.login.project.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.login.project.domain.PostDomain;
import com.login.project.vo.PostVO;


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
	
	
	//게시글 목록조회
	public List<PostDomain> selectPosts() {
		
		List<PostDomain> postList = null;
		
		//List Java.util로 주의 javac list 아님###
		postList = sqlSessionTemplate.selectList("mapper.post.postMapper.selectPosts");
		
		return postList;
	}
	 
}
