<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1> loginForm.jsp </h1>

<form action="/login" method="post">
	
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	
	id : <input type="text" name="username" />
	pw : <input type="password" name="password" />
	<input type="submit" value="로그인" />
</form>