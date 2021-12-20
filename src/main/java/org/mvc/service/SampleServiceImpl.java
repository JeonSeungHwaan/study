package org.mvc.service;

import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService{

	@Override
	public Integer doAdd(String str1, String st2) throws Exception {
		return Integer.parseInt(str1) + Integer.parseInt(st2);
	}

	@Override
	public String doMsg() throws Exception {
		return "hello taget";
	}

	@Override
	public Integer aaa() {
		return 100;
	}

}
