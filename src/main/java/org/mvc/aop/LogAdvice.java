package org.mvc.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Log4j
@Component
public class LogAdvice {
	
	// 타겟 설정 = poincut
	// 타겟 메소드가 실행 되기 전에 먼저 실행되는 언노테이션
	// @Before("execution(* org.mvc.controller.Sample*.aop*(..))")
	public void before() {
		log.info("===========/before/===========");
	}
	
	@Around("execution(* org.mvc.controller.Sample*.*(..))")
	public Object around(ProceedingJoinPoint jp)throws Throwable{
		log.info("===========/around - before/===========");
		Object obj = jp.proceed();
		log.info("===========/around - after/===========");
		return obj;
	}
}
 