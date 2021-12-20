<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<h1> list.jsp </h1>

<input type="button" value="글 작성" onclick="window.location='/board/write'" />

<br/>

<c:forEach items = "${list}" var = "boardDTO">
	글 번호 : ${boardDTO.bno} |
	제목 : <a href="/board/readcount?bno=${boardDTO.bno}">${boardDTO.title}</a> |
	작성자 : ${boardDTO.writer} |
	작성날짜 : ${boardDTO.regdate} |
	조회수 : ${boardDTO.readcount}
	<br/>
</c:forEach>

