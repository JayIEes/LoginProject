package com.login.project.service;

import java.io.IOException;

import org.apache.ibatis.exceptions.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.project.dao.PostDao;
import com.login.project.domain.PostDomain;
import com.login.project.vo.PostVO;
import com.login.project.vo.SearchVO;

import java.util.List;
import java.util.function.IntBinaryOperator;

@Service
public class PostService {
	
	@Autowired
	private PostDao pDAO;
	
	
	/**
	 * 게시글 등록 서비스
	 * @methodName insertPost
	 * @param PostVO pVO
	 * @return int
	 */
	public int insertPost(PostVO pVO) throws IOException {
		
		int resultCnt = 0;
		
		try {
			resultCnt = pDAO.insertPost(pVO); 
		}catch(PersistenceException pe) {
			pe.printStackTrace();
		}
		
		return resultCnt;
	}
	
	
	/**
	 * 게시글 목록조회
	 * @methodName selectPosts
	 * @param 
	 * @return List<PostDomain>
	 */
	public List<PostDomain> selectPosts(){
		
		List<PostDomain> list = null;
		
		list = pDAO.selectPosts(); 
		
		return list;
	}
	
	
	
	/**
	 * 게시글 상세 
	 * @methodName selectPostDetail
	 * @param 
	 * @return PostDomain
	 */
	public PostDomain selectPostDetail(int post_seq){
		
		PostDomain postDomain = null;
		
		postDomain = pDAO.selectPostDetail(post_seq); 
		
		return postDomain;
	}
	
	
	/**
	 * 게시글 수정
	 * @methodName updatePost
	 * @param PostVO pVO
	 * @return int
	 */
	public int updatePost(PostVO pVO){
		
		int resultCnt = 0;
		
		resultCnt = pDAO.updatePostDetail(pVO); 
		
		return resultCnt;
	}
	
	
	public List<PostDomain> searchPostsByWord(SearchVO sVO){
		
		List<PostDomain> list = null;
		
		list = pDAO.selectPostsForSearch(sVO); 
		
		return list;
	}
	
	
	
}
