<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<title>책 수정하기</title>
<script type="text/javascript">
	//jQuery 시작
	$(function(){
		let bookId = "${param.bookId}";
	$("#btnList").on("click",function(){
		//BookController의 /list URI에 매핑된 메소드를 실행
		location.href="/list";
		});
	$("#btnCancel").on("click",function(){
		//http://localhost/update?bookId=1
		//param => bookId = 1
		location.href="/detail?bookId="+bookId;
		})
	});
</script>
</head>
<body>
	<h1>책 수정</h1>
	<form action="/update" method="post">
		<input type="hidden" name="bookId" value="${data.bookId}">
		<p>제목: <input type="text" name="title" value="${data.title}" required="required"></p>
		<p>카테고리: <input type="text" name="category" value="${data.category}" required="required"></p>
		<p>가격: <input type="text" name="price" value="${data.price}" required="required"></p>
		<p>
			<input type="submit" value="수정">
			<input type="button" value="취소" id="btnCancel">
			<button type="button" id="btnList">목록</button>
		</p>
	</form>
</body>
</html>