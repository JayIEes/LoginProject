package com.login.project.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.login.project.domain.PostDomain;
import com.login.project.service.PostService;
import com.login.project.vo.MemberVO;
import com.login.project.vo.PostVO;

@Controller
public class PostController {
	
	@Autowired
	PostService postService;
	
	
	//게시판 목록 페이지 (메인페이지)
	@RequestMapping(value = "post", method = RequestMethod.GET)
	public String post(Model model, SessionStatus ss) {
		
		List<PostDomain> list =null;
		
		list = postService.selectPosts();
		model.addAttribute("postList", list);
		
		return "/post/post";
	}
	
	
	//게시글 등록 페이지
	@RequestMapping(value = "postwrite", method = RequestMethod.GET)
	public String postPage(Model model) {
		
		return "/post/post_write";
	}
	
	
	//게시글 등록 
	@RequestMapping(value = "putuppost", method = RequestMethod.POST)
	public String postPutUp(PostVO pVO, HttpSession session) throws IOException {
		
		int cnt=0;
		
		MemberVO mVO = (MemberVO) session.getAttribute("memberInfo");
		
		pVO.setId(mVO.getId());
		
		//등록 시간
		/*
		 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); Date date
		 * = new Date(); String dateString = sdf.format(date); pVO.setDate(dateString);
		 */
		
		cnt=postService.insertPost(pVO);
		
		if(cnt!=0) {//게시판 등록 성공시
			
			//성공 메시지 넣기 model로
			return "redirect:/post";
		}else {
			
			return "/post/post_write";
		}//if else
		
	}
	
}
