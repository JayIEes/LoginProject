package com.login.project;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class mysqlTest1 {

	 private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	 private static final String URL = "jdbc:mysql://127.0.0.1:3306/project_one?useSSL=false"; // jdbc:mysql://127.0.0.1:3306/여러분이 만드신 스키마이름
	 private static final String USER = "root"; //DB 사용자명
	 private static final String PW = "kyobo11!";   //DB 사용자 비밀번호
	
	@Test
	public void test() throws Exception{
		Class.forName(DRIVER);
		
			 Connection con = DriverManager.getConnection(URL, USER, PW);
			   System.out.println("성공");
			   System.out.println(con);

	}
}
