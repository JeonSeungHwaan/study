package com.project.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.bean.BoardDataBean;
import com.project.service.JspBoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/jspBoard/")
public class JspBoardController {

	@Autowired
	private JspBoardService service;
	
	@RequestMapping("list")
	public String list(String pageNum, Model model) {
		log.info("=========/list/=========");
		
		int pageSize = 10;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		if (pageNum == null) {
		       pageNum = "1";
		}

	    int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		int count = 0;
		int number=0;
		
		count = service.count();
		List articleList = null;
		if(count > 0) {
			articleList = service.getList(startRow, endRow);
		}
		
		number=count-(currentPage-1)*pageSize;
		
		model.addAttribute("articleList", articleList);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("startRow", startRow);
		model.addAttribute("endRow", endRow);
		model.addAttribute("count", count);
		model.addAttribute("number", number);
		
		return "jspBoard/list";
	}
	
	@RequestMapping("writeForm")
	public String writeForm(BoardDataBean dto) {
		return "jspBoard/writeForm";
	}
	
	@RequestMapping("writePro")
	public String writePro(BoardDataBean article, HttpServletRequest request) {
		
		article.setReg_date(new Timestamp(System.currentTimeMillis()) );
		article.setIp(request.getRemoteAddr());
		
		int number = 0;
		int maxNum = service.maxNum();
		
		if (maxNum > 0) { 
			number = maxNum+1;	
		}else {
			number=1; 
		}
		
		if(article.getNum() != 0) {
			service.stepUpdate(article);
			article.setRe_step(article.getRe_step() + 1);
			article.setRe_level(article.getRe_level() + 1);
		} else {
			article.setRef(number);
			article.setRe_step(0);
			article.setRe_level(0);
		}
		
		service.insert(article);
		
		return "jspBoard/writePro";
	}
	
	@RequestMapping("content")
	public String content(int num, String pageNum, Model model) {
		
		service.readUpdate(num);
		
		model.addAttribute("article",service.getContent(num));
		model.addAttribute("pageNum",pageNum);
		
		return "jspBoard/content";
	}
	
	@RequestMapping("updateForm")
	public String updateForm(int num, String pageNum, Model model) {
		
		model.addAttribute("article",service.getContent(num));
		model.addAttribute("pageNum",pageNum);
		
		return "jspBoard/updateForm";
	}
	
	@RequestMapping("updatePro")
	public String updatePro(BoardDataBean article, String pageNum, Model model) {
		
		String DBpasswd = service.passwdCheck(article.getNum());
		
		int check = 0;
		
		if(article.getPasswd().equals(DBpasswd)) {
			check = service.updateArticle(article);
		}
		
		model.addAttribute("check", check);
		model.addAttribute("pageNum",pageNum);
		
		return "jspBoard/updatePro";
	}
	
	@RequestMapping("deleteForm")
	public String deleteForm(int num, String pageNum, Model model) {
		
		model.addAttribute("num", num);
		model.addAttribute("pageNum",pageNum);
		
		return "jspBoard/deleteForm";
	}
	
	@RequestMapping("deletePro")
	public String deletePro(BoardDataBean article, String pageNum, Model model) {
		log.info("===========================================");
		String DBpasswd = service.passwdCheck(article.getNum());
		
		int check = 0;
		
		if(article.getPasswd().equals(DBpasswd)) {
			check = service.deleteArticle(article.getNum());
		}
		
		model.addAttribute("check", check);
		model.addAttribute("pageNum",pageNum);
		
		return "jspBoard/deletePro";
	}
}
