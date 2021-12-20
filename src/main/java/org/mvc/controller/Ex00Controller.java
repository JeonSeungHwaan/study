package org.mvc.controller;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mvc.bean.MemberDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Controller // 스프링 컨트롤과 연결되었다는 표시 (없으면 컨트롤 작용을 안함)
@Slf4j
@Log4j
@RequestMapping("ex00/") // 사용자가 적어야할 주소의 접두사
public class Ex00Controller {
	
	@Autowired // 스프링 컨트롤에서 객체를 주입받음 (의존성 주입)
	private MemberDTO dto;
	
	// http://localhost:8080/ex00/main
	@RequestMapping(value = "main", method=RequestMethod.POST)
	public String main() {
		// MemberDTO dto = new MemberDTO();
		
		System.out.println(dto);
		
		return "1201/main"; // 이동할 views 폴더 안의 경로
	}
	
	// http://localhost:8080/ex00/login
	// @GetMapping get방식으로 값을 전송
	@GetMapping("login")
	public String login() {
		
		return "1201/loginForm";
	}
	
	// @PostMapping post방식으로 값을 전송
	@PostMapping("loginPro")
	/* 파라미터를 받을 땐 컨트롤의 메소드에서 매게변수로 선언 해두면 알아서 받음
	* public String loginPro(String id, String pw, int age) 					 - 변수로 받는 법
	* public String loginPro(MemberDTO dto) 									 - 객체(DTO)로 받는 법
	* public String loginPro(HttpServletRequest request) 					 	 - jsp에서 사용하던 request.getParameter로 받는 법
	* public String loginPro(String [] ch) 									 	 - 배열로 받는 법
	* public String loginPro(@RequestParam("ch") ArrayList<String> ch) 			 - 리스트로 받는 법
	* public String loginPro(MemberDTO dto, @ModelAttribute("name") String name) - 파라미터는 여러 방식을 같이 써서 받을 수도 있음
	*/ 
	public String loginPro(Model model, RedirectAttributes rttr, MemberDTO dto) {
		// DTO를 통해 받은 파라미터는 view 까지 전달됨
		// 메개변수로 받은 파라미터는 view까지 전달되지 않음 - @ModelAttribute("")를 이용해야함
		
		// request.setAttribute, session.setAttribute 와 같은 기능을 함
		model.addAttribute("count", 77); // view로 보내는 값
		rttr.addFlashAttribute("num", 100); // 일회성 데이터 전달방법 - 화면에서 새로고침하면 유지가 안됨
		
		// forward - 파라미터로 받은 값을 그대로 들고 이동 / redirect - 파라미터로 받은 값을 들지 않고 이동
		return "redirect:/ex00/index";
		// return "1201/loginPro";
	}
	
	@RequestMapping("index")
	public String index() {
		
		return "1201/index";
	}
	
	
	// ----------------------------------------12/03---------------------------------------------- //
	
	
	// 리턴값이 void인 경우 RequestMapping에 적어놓은 주소의 jsp 파일로 이동함
	@RequestMapping("example")
	public void example() {
		
	}
	
	// 객체타입 지정 / JSON 라이브러리를 추가해야 출력 가능 
	// 리턴값이 void인 경우와 같지만 @ResponseBody 어노테이션을 붙히면 view로 이동하지 않고 리턴값이 브라우저에 바로 출력됨
	@RequestMapping("example2")
	public @ResponseBody MemberDTO example2() {
		
		System.out.println("example2");
		return dto;
	}
	
	// 객체타입 지정 / 리턴값이 void인 경우와 같지만 @ResponseBody 어노테이션을 붙히면 view로 이동하지 않고 리턴값이 브라우저에 바로 출력됨
	// script에서 사용됨
	@RequestMapping("example3")
	public @ResponseBody String example3() {
		
		System.out.println("example3");
		return "hello spring"; // 한글은 지원하지 않음 (영문, 숫자)
	}
	
	// 웹 시스템 프로그래밍
	// 웹 헤더정보를 활용함
	@RequestMapping("example4")
	public ResponseEntity<String> exmapmle4(){
		
		String msg = "{\"name\" : \"java\" }";
		HttpHeaders header = new HttpHeaders(); // 브라우저 레더 정보
		header.add("Content-Type", "application/json;charset=UTF-8");
		
		return new ResponseEntity<>(msg, header, HttpStatus.OK);
	}
	
}
