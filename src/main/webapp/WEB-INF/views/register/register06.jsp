<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>File</title>
</head>
<body>
	<form action="/board/registerFile01" method="post" enctype="multipart/form-data">
		<p><input type="file" name="picture"></p>
		<p><input type="submit" value="업로드"></p>
	</form>
	<hr>
	<form action="/board/registerFile02" method="post" enctype="multipart/form-data">
		<p>userId : <input type="text" name="userId" value="개똥이"> </p>
		<p>password : <input type="text" name="password" value="java"> </p>
		<p><input type="file" name="picture"></p>
		<p><input type="submit" value="업로드"></p>
	</form>
	<hr>
	<form action="/board/registerFile03" method="post" enctype="multipart/form-data">
		<p>userId : <input type="text" name="userId" value="개똥이"> </p>
		<p>password : <input type="text" name="password" value="java"> </p>
		<p><input type="file" name="picture"></p>
		
		<p><input type="submit" value="업로드"></p>
	</form>
	<hr>
	<form action="/board/registerFile04" method="post" enctype="multipart/form-data">
		<p>userId : <input type="text" name="userId" value="개똥이"> </p>
		<p>password : <input type="text" name="password" value="java"> </p>
		<p><input type="file" name="picture"></p>
		<p><input type="file" name="picture2"></p>
		<p><input type="submit" value="업로드"></p>
	</form>
	<hr>
	<form action="/board/registerFile05" method="post" enctype="multipart/form-data">
		<p>userId : <input type="text" name="userId" value="개똥이"> </p>
		<p>password : <input type="text" name="password" value="java"> </p>
		<p><input type="file" name="pictureList[0]"></p>
		<p><input type="file" name="pictureList[1]"></p>
		<p><input type="submit" value="업로드"></p>
	</form>
	<form action="/board/registerFile06" method="post" enctype="multipart/form-data">
		<p>userId : <input type="text" name="userId" value="개똥이"> </p>
		<p>password : <input type="text" name="password" value="java"> </p>
		<p><input type="file" name="pictureArray" multiple="multiple"></p>
		
		<p><input type="submit" value="업로드"></p>
	</form>
</body>
</html>