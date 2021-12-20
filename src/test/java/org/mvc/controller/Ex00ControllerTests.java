package org.mvc.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

// @RunWith - 현재 테스트 코드가 스프링실행 역할 의미 (이미 완성 된 코드에 영향을 끼치지 않고 테스트를 하기 위함)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class Ex00ControllerTests {
	
	@Test
	public void test() {
		log.info("test-run");
	}
}
