package org.mvc.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mvc.service.SampleTxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTxTest {
	
	@Setter(onMethod_=@Autowired)
	private SampleTxService service;
	
	@Test
	public void testTx() {
		String value="asdfasdfasdfasdfasdfasdfasdfsafasfdsafasdfdasfasdfasdfasdfasdfsadsfasdfasdfasdfasdfasdfasdfasdfsafasfdsafasdfdasfasdfasdfasdfasdfsadsf";
		log.info("========value byte = " + value.getBytes().length);
		
		service.addData(value);
	}
}
