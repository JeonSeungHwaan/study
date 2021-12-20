<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<h1> update.jsp </h1>    

<form action="/board/updatePro" method="post">
	<input type="hidden" name="bno" value="${boardDTO.bno}" />
	작성자 : <input type="text" name="writer" value="${boardDTO.writer}" /> <br/>
	제목 : <input type="text" name="title" value="${boardDTO.title}" /> <br/>
	내용 : <textarea rows="10" cols="20" name="content" >${boardDTO.content}</textarea> <br/>
	<input type="submit" value="글 수정" />
</form>

