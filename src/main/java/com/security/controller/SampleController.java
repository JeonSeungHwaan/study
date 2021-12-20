package com.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/security/")
public class SampleController {
	
	@RequestMapping("all")
	public String all() {
		log.info("all -- all user access");
		return "sample/all";
	}
	
	@RequestMapping("member")
	public String member() {
		log.info("member -- login user access");
		return "sample/member";
	}
	
	@RequestMapping("admin")
	public String admin() {
		log.info("admin -- admin access");
		return "sample/admin";
	}
	
	@RequestMapping("error403")
	public String error403(Authentication auth, Model model) {
		log.info("error403 access" + auth);
		return "sample/error403";
	}
	
	@RequestMapping("login")
	public String login() {
		log.info("login -- loginForm access");
		return "sample/loginForm";
	}
	
	@RequestMapping("logout")
	public String logout() {
		log.info("logout -- logout access");
		return "sample/logout";
	}
	
}
