<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
	// 스크립트를 준비 시킴
	$(document).ready(function(){
		// id="btn"을 가지는 버튼을 클릭 할 때 동작한다
		$("#btn").click(function(){
			// ajax 호출
			$.ajax({
				// 값을 보내는 방식
				type : "post",
				// 호출할 링크(컨트롤과 연결)
				url : "/test/idCheck",
				// 보낼 파라미터
				data : { id : $("#id").val() } ,
				// 값을 성공적으로 가져왔을 때 data에 값을 대입
				success : function(data){
					a = parseInt(data);
					if(a == 1){
						$("#result").html("<font color='red'>사용불가능</font>");
					} else {
						$("#result").html("<font color='green'>사용가능</font>");
					}
				}
			});
		});
	});
	
</script>

<h1> form.jsp </h1>

<form action="/ajax/formPro" method="post">
	id : <input type="text" name="id" id="id" />
	<input type="button" value="중복확인" id="btn" /> 
	<label id="result"></label>
	<br/>
	<input type="submit" value="전송" />
</form>