package org.mvc.aop;

import org.aspectj.lang.ProceedingJoinPoint;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogXmlAdvice {
	
	public void before() {
		log.info("====[ aop before ]====");
	}
	
	public void after() {
		log.info("====[ aop after ]====");
	}
	
	// around 는 진행의 흐름에 영향을 준다
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		log.info("====[ aop around - before ]====");
		
		log.info("==/Target = " + jp.getTarget());
		log.info("==/Kind = " + jp.getKind());
		log.info("==/Signature = " + jp.getSignature());
		log.info("==/SourceLocation = " + jp.getSourceLocation());
		log.info("==/StaticPart = " + jp.getStaticPart());
		log.info("==/This = " + jp.getThis());
		log.info("==/Args = " + jp.getArgs());
		
		// 흐름을 이어주는 역할을 함 / 타겟 메소드로 이동
		Object obj = jp.proceed();
		
		log.info("====[ aop around - after ]====");
		return "1214/form";
	}
}
