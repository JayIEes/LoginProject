package com.login.project.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.login.project.service.PostService;
import com.login.project.vo.LoginVO;
import com.login.project.vo.PostVO;
import com.mysql.cj.Session;

@Controller
public class PostController {
	
	@Autowired
	PostService postService;
	
	
	//게시판 목록 페이지 (메인페이지)
	@RequestMapping(value = "post", method = RequestMethod.GET)
	public String post() {
		return "/post/post";
	}
	
	
	//게시글 등록 페이지
	@RequestMapping(value = "postwrite", method = RequestMethod.GET)
	public String postPage() {
		
		
		
		return "/post/post_write";
	}
	
	
	//게시글 등록 
	@RequestMapping(value = "putuppost", method = RequestMethod.POST)
	public String postPutUp(PostVO pVO, HttpSession session) throws IOException {
		
		int cnt=0;
		
		LoginVO loginVO = (LoginVO) session.getAttribute("memberInfo");
		
		pVO.setMember_seq(loginVO.getMember_seq());
		
		cnt=postService.insertPost(pVO);
		
		if(cnt!=0) {//게시판 등록 성공시
			return "/post/post";
		}else {
			return "/login/login_fail";
		}//if else
		
	}
	
}
