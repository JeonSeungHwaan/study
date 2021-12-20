package org.mvc.service;

import java.util.List;

import org.mvc.bean.BoardDTO;

public interface BoardService {
	
	// tbl_board 테이블의 전체 목록
	public List<BoardDTO> getList();
	
	// tbl_board 테이블에 데이터 추가
	public int boardWrite(BoardDTO board);
	
	// 하나의 개시글 읽어오는 메소드
	public BoardDTO getBnoRead(Long bno);
	
	// 글 수정 메소드
	public int updateContent(BoardDTO board);

	// 글 삭제 메소드
	public int deleteContent(Long bno);
	
	// 조회수 증가 메소드
	public int boardReadCount(Long bno);
}
