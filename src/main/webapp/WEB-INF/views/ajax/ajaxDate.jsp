<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<script src="/resources/jQuery/jquery-3.6.0.min.js"></script>

<script>

	$(document).ready(function(){
		$('#btn').click(function(){
			day = window.setInterval('myDate()', 1000);
		});
		
		$('#btn2').click(function(){
			window.clearInterval(day);
		});
	});
	
	function myDate(){
		$.ajax({
			type : "post" ,
			url : "/test/test" ,
			success : function(data){
				$("#result").html(data);
			}
		});
	}
	
</script>
<h1> ajaxDate.jsp </h1>

<input type="button" id="btn" value="시작" />
<input type="button" id="btn2" value="종료" />

<div id="result">
	
</div>