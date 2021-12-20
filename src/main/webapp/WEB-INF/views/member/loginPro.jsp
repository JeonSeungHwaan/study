<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1> loginPro.jsp </h1>

<c:if test="${sessionScope.memId != null}">
	<script>
		alert("로그인 되었습니다.");
		window.location="/member/main";
	</script>
</c:if>

<c:if test="${sessionScope.memId == null}">
	<script>
		alert("아이디 / 비밀번호를 확인하세요.");
		history.go(-1);
	</script>
</c:if>


