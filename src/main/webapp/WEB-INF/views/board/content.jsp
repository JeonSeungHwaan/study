<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<h1> content.jsp </h1>

작성자 : ${boardDTO.writer} <br/>
제목 : ${boardDTO.title} <br/>
내용 : ${boardDTO.content} <br/>
조회수 : ${boardDTO.readcount} <br/>
<input type="button" value="글 수정" onclick="window.location='/board/update?bno=${boardDTO.bno}&writer=${boardDTO.writer}&title=${boardDTO.title}&content=${boardDTO.content}'" />
<input type="button" value="글 삭제" onclick="window.location='/board/delete?bno=${boardDTO.bno}'" />
<input type="button" value="글 목록" onclick="window.location='/board/list'" />

	