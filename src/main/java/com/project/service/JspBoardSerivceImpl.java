package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bean.BoardDataBean;
import com.project.mybatis.JspBoardMapper;

import lombok.Setter;

@Service
public class JspBoardSerivceImpl implements JspBoardService{

	@Setter(onMethod_=@Autowired)
	private JspBoardMapper mapper;
	
	@Override
	public int count() {
		return mapper.getArticleCount();
	}

	@Override
	public List<BoardDataBean> getList(int startRow, int endRow) {
		return mapper.getArticles(startRow, endRow);
	}

	@Override
	public int maxNum() {
		return mapper.maxNum();
	}

	@Override
	public void stepUpdate(BoardDataBean dto) {
		mapper.stepUpdate(dto);
	}

	@Override
	public void insert(BoardDataBean dto) {
		mapper.insertArticle(dto);
	}

	@Override
	public void readUpdate(int num) {
		mapper.readcountUpdate(num);
	}

	@Override
	public BoardDataBean getContent(int num) {
		return mapper.getArticle(num);
	}

	@Override
	public String passwdCheck(int num) {
		return mapper.passwdCheck(num);
	}

	@Override
	public int updateArticle(BoardDataBean dto) {
		return mapper.updateArticle(dto);
	}

	@Override
	public int deleteArticle(int num) {
		return mapper.deleteArticle(num);
	}

	
}
