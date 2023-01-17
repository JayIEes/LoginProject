package com.login.project.vo;

public class LoginVO {
	private String name, id, birthday,del_yn, password;
	private int member_seq;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getBirthday() {
		return birthday;
	}
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getDel_yn() {
		return del_yn;
	}
	
	public void setDel_yn(String del_yn) {
		this.del_yn = del_yn;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getMember_seq() {
		return member_seq;
	}
	
	public void setMember_seq(int member_seq) {
		this.member_seq = member_seq;
	}
	
	
	
}
