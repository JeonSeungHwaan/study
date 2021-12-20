package org.mvc.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {
	
	@Setter(onMethod_=@Autowired)
	private Academy academy;
	
	@Test
	public void textAcademy() {
		assertNotNull(academy); // Junit에서 제공 - 객체가 null이 아닌 경우에만 테스트에 성공한다는 것을 의미
		log.info(academy);
		log.info("-------------------");
		log.info(academy.getStudent());
	}
}
