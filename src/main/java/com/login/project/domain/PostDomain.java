package com.login.project.domain;

public class PostDomain {

	private String post_seq, title, content, del_yn;
	private int member_seq;
	
	public String getPost_seq() {
		return post_seq;
	}
	public void setPost_seq(String post_seq) {
		this.post_seq = post_seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDel_yn() {
		return del_yn;
	}
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	public int getMember_seq() {
		return member_seq;
	}
	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}
	
	
	
}
