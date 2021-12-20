package org.mvc.controller;

import java.util.Date;

import org.mvc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test/")
public class TestController2 {
	
	@Autowired
	private MemberService service;
	
	@RequestMapping("ajaxDate")
	public String ajaxDate() {
		return "ajax/ajaxDate";
	}
	
	@RequestMapping("test")
	public String test(Model model) {
		model.addAttribute("day", new Date());
		
		return "ajax/test";
	}
	
	@RequestMapping("main")
	public String main(Model model) {
		model.addAttribute("memCount", service.memberCount());
		
		return "ajax/main";
	}
	
	// service.memberCount()의 값을 뷰로 이동하지 않고 바로 리턴
	@RequestMapping("realTime")
	public @ResponseBody int realTime() {
		return service.memberCount();
	}
	
	@RequestMapping("form")
	public String form() {
		return "ajax/form";
	}
	
	@RequestMapping("idCheck")
	public @ResponseBody int idCheck(String id) {
		return service.idCheck(id);
	}
}
