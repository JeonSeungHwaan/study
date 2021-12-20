package com.project.service;

import java.util.List;

import com.project.bean.BoardDataBean;

public interface JspBoardService {

	public int count();
	
	public List<BoardDataBean> getList(int startRow, int endRow);
	
	public int maxNum();
	
	public void stepUpdate(BoardDataBean dto);
	
	public void insert(BoardDataBean dto);
	
	public void readUpdate(int num);
	
	public BoardDataBean getContent(int num);
	
	public String passwdCheck(int num);
	
	public int updateArticle(BoardDataBean dto);
	
	public int deleteArticle(int num);
}
