<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<h1> input.jsp </h1>

<form action="/member/inputPro" method="post" enctype="multipart/form-data">
	
	* id : <input type="text" name="id" /> <br/>
	* pw : <input type="password" name="pw" /> <br/>
	* name : <input type="text" name="name" /> <br/>
	* birth : <input type="date" name="birth" /> <br/>
	img : <input type="file" name="save" /> <br/>
		<input type="submit" value="회원가입" />
	
</form>    