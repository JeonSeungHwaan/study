<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<h1> imgUpdate.jsp </h1>

<form action="/member/imgUpdatePro" method="post" enctype="multipart/form-data">
	사진 : <input type="file" name="save" /> <br/>
	<input type="hidden" name="id" value="${sessionScope.memId}" />
	<input type="submit" value="사진 변경" />
</form>