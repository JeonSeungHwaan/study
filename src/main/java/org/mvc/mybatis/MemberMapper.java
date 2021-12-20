package org.mvc.mybatis;

import org.mvc.bean.MemberDTO;

public interface MemberMapper {
	
	// 회원가입
	public int input(MemberDTO member);
	
	// 사진 업로드
	public int imgUpdate(MemberDTO member);
	
	// 로그인
	public int loginCheck(MemberDTO member);
	
	// 회원 정보 출력
	public MemberDTO userInfo(String id);
	
	// 회원 탈퇴 처리
	public int statusChange(String id);
	
	// 회원 정보 수정
	public int userUpdate(MemberDTO member);
	
	// 전체 회원 수
	public int memberCount();
	
	// 아이디 중복 체그
	public int idCheck(String id);
}
