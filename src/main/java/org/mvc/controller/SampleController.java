package org.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

// @Controller
@Slf4j
// @RequestMapping("/aop/")
public class SampleController {

	@RequestMapping("main")
	public String aopMain() {
		log.info("===========/aopMain/===========");
		return "1214/main";
	}
}
