package org.mvc.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.mvc.bean.BoardDTO;

public interface BoardMapper {
	
	// 게시판 전체 글 목록 리턴용 메소드
//	@Select("select * from tbl_board where bno > 0")
	public List<BoardDTO> getList();
	
	// 게시글 작성
	public int insert (BoardDTO board);
	
	// 하나의 게시글 불러오기
	public BoardDTO read(Long bno);
	
	// 게시글 삭제
	public int delete (Long bno);
	
	// 게시글 수정
	public int update (BoardDTO board);
	
	// 조회수 증가
	public int readCount(Long bno);
	
}
