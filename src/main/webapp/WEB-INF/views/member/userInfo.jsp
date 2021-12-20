<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<h1> userInfo.jsp </h1>

<img src="/resources/member/img/${memberDTO.img}" width="100" height="100" />
<input type="button" value="프로필 사진 변경" onclick="window.location='/member/imgUpdate'" />

<br/>

id : ${memberDTO.id} <br/>
pw : ${memberDTO.pw } <br/>
name : ${memberDTO.name } <br/>
birth : <fmt:formatDate value="${memberDTO.birth}" type="date" /> <br/>
regdate : <fmt:formatDate value="${memberDTO.regdate}" type="date" /> <br/>

<input type="button" value="탈퇴" onclick="window.location='/member/delete'" />
<input type="button" value="정보 수정" onclick="window.location='/member/update?id=${sessionScope.memId}'" />