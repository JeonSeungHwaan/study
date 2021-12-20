<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<h1> uploadForm.jsp </h1>

<form action="/file/uploadPro" method="post" enctype="multipart/form-data">
	작성자 : <input type="text" name="name" /> <br/>
	파 일 : <input type="file" name="save" /> <br/>
		   <input type="submit" value="작성" />
</form>