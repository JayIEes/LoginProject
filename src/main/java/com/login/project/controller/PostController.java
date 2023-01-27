package com.login.project.controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.login.project.domain.PostDomain;
import com.login.project.service.PostService;
import com.login.project.vo.MemberVO;
import com.login.project.vo.PostVO;
import com.login.project.vo.SearchVO;

@Controller
public class PostController {
	
	@Autowired
	PostService postService;
	
	
	/**
	 * 게시판 목록 페이지 
	 * @methodName post
	 * @param Model model, SessionStatus ss
	 * @return String
	 */
	@RequestMapping(value = "postlist", method = RequestMethod.GET)
	public String post(Model model, SessionStatus ss) {
		
		List<PostDomain> list =null;
		
		list = postService.selectPosts();
		model.addAttribute("postList", list);
		
		return "/post/post_list";
	}
	
	
	/**
	 * 게시글 등록 페이지
	 * @methodName postPage
	 * @param Model model
	 * @return String
	 */
	@RequestMapping(value = "postwrite", method = RequestMethod.GET)
	public String postPage(Model model) {
		
		return "/post/post";
	}
	
	
	/**
	 * 게시글 등록 
	 * @methodName postPutUp
	 * @param PostVO pVO, HttpSession session
	 * @return String
	 */
	@RequestMapping(value = "putuppost", method = RequestMethod.POST)
	public String postPutUp(PostVO pVO, HttpSession session) throws IOException {
		
		int cnt=0;
		
		MemberVO mVO = (MemberVO)session.getAttribute("memberInfo");
		
		pVO.setId(mVO.getId());
		
		
		cnt=postService.insertPost(pVO);
		
		if(cnt!=0) {//게시판 등록 성공시
			
			//성공 메시지 넣기 model로
			session.setAttribute("postuploaded", "Y");
			return "redirect:/postlist";
		}else {
			
			return "/post/post";
		}//if else
		
	}
	
	
	/**
	 * 게시글 상세페이지
	 * @methodName postDetail
	 * @param int post_seq
	 * @return String
	 */
	@RequestMapping(value = "post/{post_seq}", method = RequestMethod.GET)
	public String postDetail(@PathVariable int post_seq, Model model) {
		
		PostDomain pDomain = postService.selectPostDetail(post_seq);
		//System.out.println(session.getAttribute("modifyYn")+"---------------");
		
		model.addAttribute("postDetail", pDomain);
		
		return "/post/post";
	}
	
	
	/**
	 * 게시글 수정
	 * @methodName postModify
	 * @param PostVO pVO, Model model
	 * @return String
	 */
	@RequestMapping(value = "postmodify", method = RequestMethod.POST)
	public String postModify(PostVO pVO, Model model, HttpSession session) {
		
		postService.updatePost(pVO);
		
		String adr = "redirect:/post/"+pVO.getPost_seq();
		
		session.setAttribute("modifyYn","Y");
		
		return adr;
	}
	
	
	/**
	 * 게시글 검색(제목, 게시자)
	 * @methodName postSearch
	 * @param SearchVO sVO, Model model
	 * @return String
	 */
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String postSearch(SearchVO sVO, Model model) {
		
		List<PostDomain> list =null;
		list = postService.searchPostsByWord(sVO);
		
		model.addAttribute("postList", list);
		model.addAttribute("searchword",sVO.getSearchword());
		model.addAttribute("condition",sVO.getCondition());
		
		return "/post/post_list";
	}
}
