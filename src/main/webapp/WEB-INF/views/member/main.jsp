<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<h1> member/main.jsp </h1>    

<c:if test="${sessionScope.memId == null}">
	<script>
		alert("로그인 후 이용해주세요.");
		window.location="/member/login";
	</script>
</c:if>

<c:if test="${sessionScope.memId != null}">
	<h2> ${sessionScope.memId}님 환영합니다. </h2>
	<input type="button" value="로그아웃" onclick="window.location='/member/logout'" />
	<input type="button" value="회원정보" onclick="window.location='/member/userInfo'" />
</c:if>