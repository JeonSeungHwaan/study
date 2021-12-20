package org.mvc.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component
@Data
public class Academy {
	
	@Setter(onMethod_=@Autowired) // Component 설정된 객체를 주입받는 어노테이션 (컨트롤에서 객체를 생성하지 못할 때 쓰는 방법)
	private Student student;
}
