package org.mvc.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // AOP 기능
public class ExceptionAdvice {
	
	@ExceptionHandler(Exception.class)
	public String excet(Exception e, Model model) {
		
		return "/error/error_page";
	}
}
