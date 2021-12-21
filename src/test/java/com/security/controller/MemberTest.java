package com.security.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
		"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/security-context.xml"
		})
@Log4j
public class MemberTest {

	@Setter(onMethod_=@Autowired)
	private PasswordEncoder pwencoder;
	
	@Setter(onMethod_=@Autowired)
	private DataSource dataSource;
	
	// @Test
	public void testInsert() {
		String sql = "insert into security_member(id, pw, name) values(?, ?, ?)";
		
		for(int i = 0; i < 30; i++) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				
				conn = dataSource.getConnection();
				pstmt  =  conn.prepareStatement(sql);
				pstmt.setString(2, pwencoder.encode("pw" + i));
				
				if(i < 10) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(3, "일반" + i);
				} else if(i < 20) {
					pstmt.setString(1, "member" + i);
					pstmt.setString(3, "회원" + i);
				} else {
					pstmt.setString(1, "admin" + i);
					pstmt.setString(3, "관리자" + i);
				}
				
				pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) {try{pstmt.close();}catch(Exception e) {} }
				if(conn != null) {try{conn.close();}catch(Exception e) {} }
			}
		}
	}
	
	@Test
	public void testAuth() {
		String sql = "insert into security_auth(id, auth) values(?, ?)";
		
		for(int i = 0; i < 30; i++) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				
				conn = dataSource.getConnection();
				pstmt  =  conn.prepareStatement(sql);
				
				if(i < 10) {
					pstmt.setString(1, "user" + i);
					pstmt.setString(2, "ROLE_USER");
				} else if(i < 20) {
					pstmt.setString(1, "member" + i);
					pstmt.setString(2, "ROLE_MEMBER");
				} else {
					pstmt.setString(1, "admin" + i);
					pstmt.setString(2, "ROLE_ADMIN");
				}
				
				pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				if(pstmt != null) {try{pstmt.close();}catch(Exception e) {} }
				if(conn != null) {try{conn.close();}catch(Exception e) {} }
			}
		}
	}
}
