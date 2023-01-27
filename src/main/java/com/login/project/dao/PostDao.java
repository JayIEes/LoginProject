package com.login.project.dao;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.login.project.domain.PostDomain;
import com.login.project.vo.PostVO;
import com.login.project.vo.SearchVO;


@Repository
public class PostDao {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	 
	
	/**
	 * 게시글 등록 
	 * @methodName insertPost
	 * @param PostVO pVO
	 * @return int
	 */
	public int insertPost(PostVO pVO) throws PersistenceException, IOException{
		 
		 int resultCnt = 0 ;
		 
		 resultCnt = sqlSessionTemplate.insert("mapper.post.postMapper.insertPost", pVO);
		
		 return resultCnt;
	 }
	
	
	/**
	 * 게시글 목록조회
	 * @methodName selectPosts
	 * @param 
	 * @return List<PostDomain>
	 */
	public List<PostDomain> selectPosts() {
		
		List<PostDomain> postList = null;
		
		//List Java.util로 주의 javac list 아님###
		postList = sqlSessionTemplate.selectList("mapper.post.postMapper.selectPosts");
		
		return postList;
	}
	
	
	/**
	 * 게시글 상세조회
	 * @methodName selectPostDetail
	 * @param int post_seq
	 * @return PostDomain
	 */
	public PostDomain selectPostDetail(int post_seq) {
		
		PostDomain postDomain = null;
		
		//List Java.util로 주의 javac list 아님###
		postDomain = sqlSessionTemplate.selectOne("mapper.post.postMapper.selectPostDetail", post_seq);
		
		return postDomain;
	}
	
	
	
	/**
	 * 게시글 수정
	 * @methodName updatePostDetail
	 * @param PostVO pVO
	 * @return int
	 */
	public int updatePostDetail(PostVO pVO) {
		
		int resultCnt = 0;
		
		//List Java.util로 주의 javac list 아님###
		resultCnt = sqlSessionTemplate.update("mapper.post.postMapper.updatePost", pVO);
		
		return resultCnt;
	}
	
	
	
	/**
	 * 게시글 검색 (제목, 게시자) 
	 * @methodName selectPostsForSearch
	 * @param SearchVO sVO
	 * @return List<PostDomain>
	 */
	public List<PostDomain> selectPostsForSearch(SearchVO sVO) {
		
		List<PostDomain> postList = null;
		
		postList = sqlSessionTemplate.selectList("mapper.post.postMapper.selectWriterPosts", sVO);
		
		return postList;
	}
	
	
	
	 
}
