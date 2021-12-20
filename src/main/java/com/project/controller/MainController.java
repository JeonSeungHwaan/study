package com.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.MainDTO;

@Controller
@RequestMapping("/com/")
public class MainController {
	
	@RequestMapping("main")
	public String main(MainDTO dto, String id, HttpServletRequest request, HttpSession session) {
		String rid = request.getParameter("id");
		System.out.println("====[ dto ] = " + dto.getId());
		System.out.println("====[ String id ] = " + id);
		System.out.println("====[ request ] = " + rid);
		
		return "1215/main";
	}
}
