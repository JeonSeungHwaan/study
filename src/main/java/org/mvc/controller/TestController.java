package org.mvc.controller;

import org.mvc.bean.TestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller // servlet-context.xml 의 <conponent-scan> 에 등록
//@RequestMapping("/test/")
public class TestController {
	
	@Autowired // servlet-context.xml 로 부터 객채를 주입 받음
	private TestDTO testDTO;
	
	@Autowired // servlet-context.xml 로 부터 객채를 주입 받음
	private TestDTO testDTO5;
	
	@RequestMapping("main")
	public String main() {
		System.out.println(testDTO);
		System.out.println(testDTO.getName());
		
		System.out.println(testDTO);
		System.out.println(testDTO.getName());
	
		return "member/main";
	}
	
}
