package org.mvc.service;

import org.mvc.bean.MemberDTO;
import org.mvc.mybatis.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService{

	@Setter(onMethod_=@Autowired)
	private MemberMapper mapper;
	
	@Override
	public int memberInsert(MemberDTO member) {
		log.info("========/memberInsert/=========");
		return mapper.input(member);
	}

	@Override
	public int memberImgUpdate(MemberDTO member) {
		log.info("========/memberImgUpdate/=========");
		return mapper.imgUpdate(member);
	}

	@Override
	public int memberLogin(MemberDTO member) {
		log.info("========/memberLogin/=========");
		return mapper.loginCheck(member);
	}

	@Override
	public MemberDTO memberInfo(String id) {
		log.info("========/memberInfo/=========");
		return mapper.userInfo(id);
	}

	@Override
	public int memberDelete(String id) {
		log.info("========/memberDelete/=========");
		return mapper.statusChange(id);
	}

	@Override
	public int memberUpdate(MemberDTO member) {
		log.info("========/memberUpdate/=========");
		return mapper.userUpdate(member);
	}

	@Override
	public int memberCount() {
		log.info("========/memberUpdate/=========");
		return mapper.memberCount();
	}

	@Override
	public int idCheck(String id) {
		log.info("========/idCheck/=========");
		return mapper.idCheck(id);
	}

}
