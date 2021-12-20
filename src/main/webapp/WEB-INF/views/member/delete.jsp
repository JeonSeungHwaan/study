<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1> delete.jsp </h1>

<form action="/member/deletePro" method="post">
	pw : <input type="password" name="pw" /> <br/>
	<input type="hidden" name="id" value="${sessionScope.memId}" />
	<input type="submit" value="탈퇴" />
</form>