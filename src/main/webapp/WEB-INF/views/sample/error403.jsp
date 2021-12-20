<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1> error403.jsp </h1>

<h3> 해당 페이지에 접근할 권한이 없습니다. </h3>
<h3> ${SPRING_SECURITY_403_EXCEPTION.message}</h3>

<a href="/security/all">돌아가기</a>