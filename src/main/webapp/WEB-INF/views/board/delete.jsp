<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<h1> delete.jsp </h1>

${bno} 글을 삭제하시겠습니까?

<br/>

<form action="/board/deletePro" method="post">
	<input type="hidden" name="bno" value="${bno}" />
	<input type="submit" value="삭제" />
</form>