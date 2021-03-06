package org.mvc.service;

import org.mvc.mybatis.Sample1Mapper;
import org.mvc.mybatis.Sample2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SampleTxServiceImpl implements SampleTxService {

	@Setter(onMethod_=@Autowired)
	private Sample1Mapper mapper1;
	
	@Setter(onMethod_=@Autowired)
	private Sample2Mapper mapper2;
	
	@Transactional
	@Override
	public void addData(String value) {
		log.info("=======/mapper1/=======");
		mapper1.insertCol1(value);
		
		log.info("=======/mapper2/=======");
		mapper2.insertCol2(value);
	}

}
