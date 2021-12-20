package com.project.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.project.bean.BoardDataBean;

public interface JspBoardMapper {

	public int getArticleCount();
	
	public List<BoardDataBean> getArticles(@Param("startRow") int startRow, @Param("endRow") int endRow);
	
	public int maxNum();
	
	public void stepUpdate(BoardDataBean dto);
	
	public void insertArticle(BoardDataBean dto);
	
	public void readcountUpdate(int num);
	
	public BoardDataBean getArticle(int num);
	
	public String passwdCheck(int num);
	
	public int updateArticle(BoardDataBean dto);
	
	public int deleteArticle(int num);
}
