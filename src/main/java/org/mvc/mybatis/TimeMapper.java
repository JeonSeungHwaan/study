package org.mvc.mybatis;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	// @select 어노테이션으로 DB의 sq	l문을 실행하고 String으로 값을 리턴받는다
	@Select("select sysdate from dual")
	public String getTime();
	
	public String getTime2();
}
