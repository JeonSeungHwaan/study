<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<h1> login.jsp </h1>

<form action="/member/loginPro" method="post">
	id : <input type="text" name="id" /> <br/>
	pw : <input type="password" name="pw" /> <br/>
	<input type="submit" value="로그인" />
</form>    