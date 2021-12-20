<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<script src="/resources/jQuery/jquery-3.6.0.min.js"></script>

<script>
	$(document).ready(function(){
		window.setInterval('myDate()', 10000);
	});
	
	function myDate(){
		$.ajax({
			type : "post",
			url : "/test/realTime",
			success : function(data){
				$("#result").html(data);
			}
		});
	}
</script>

<h1> /ajax/main.jsp </h1>

<H2> 전체 회원 수 : <label id="result"> ${memCount} </label> </H2>