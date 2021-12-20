package org.mvc.bean;

import java.util.Date;

import lombok.Data;

@Data // lombok - 생성자, set, get, toString 자동 생성
public class BoardDTO {
	
	private Long bno; // 객체지향 변수
	private String title;
	private String content;
	private String writer;
	private Date regdate;
	private Date updateDate;
	private Long readcount;
}
