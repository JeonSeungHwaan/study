package org.mvc.service;

import org.mvc.bean.MemberDTO;

public interface MemberService {
	
	// 회원가입
	public int memberInsert(MemberDTO member);
	
	// 사진 업로드
	public int memberImgUpdate(MemberDTO member);

	// 로그인
	public int memberLogin(MemberDTO member);
	
	//회원 정보 출력
	public MemberDTO memberInfo(String id);
	
	// 회원 탈퇴 처리
	public int memberDelete(String id);
	
	// 회원 정보 수정
	public int memberUpdate(MemberDTO member);
	
	// 전체 회원 수
	public int memberCount();
	
	// 아이디 중복 체그
	public int idCheck(String id);
}
