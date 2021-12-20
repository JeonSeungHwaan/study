<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1> updatePro.jsp </h1>    

<c:if test="${result == 1}">
	<script>
		alert("수정 완료");
		window.location="/board/content?bno=${boardDTO.bno}";
	</script>
</c:if>