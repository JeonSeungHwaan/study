<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<h1> write.jsp </h1>

<form action="/board/writePro" method="post">
	작성자 : <input type="text" name="writer" /> <br/>
	제목 : <input type="text" name="title" /> <br/>
	내용 : <textarea rows="10" cols="20" name="content" ></textarea> <br/>
	<input type="submit" value="글 쓰기" />
</form>    