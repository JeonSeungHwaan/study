<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1> update.jsp </h1>

<form action="/member/updatePro" method="post">
	<input type="hidden" name="id" value="${sessionScope.memId}" />
	pw : <input type="password" name="pw" value="${memberDTO.pw}" /> <br/>
	name : <input type="text" name="name" value="${memberDTO.name}" /> <br/>
	birth : <input type="date" name="birth" value="${memberDTO.birth}" /> <br/>
	<input type="submit" value="정보 수정" />
</form>    