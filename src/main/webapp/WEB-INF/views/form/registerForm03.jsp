<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
	.ck.ck-editor {
    	max-width: 500px;
	}
	.ck-editor__editable {
	    min-height: 300px;
	}

</style>
<script type="text/javascript" src="/resources/ckeditor/ckeditor.js"></script>
<script type="text/javascript" src="/resources/js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		 CKEDITOR.replace('introduction'); 
	});
</script>
</head>
<body>
<!-- modelAttribute 속성에 폼객체의 속성명 지정함 -->
<!-- 폼 객체의 속성 명 (model.addAttribute("member",new BoardMemberVO());)
	과 스프링 폼 태그의 modelAttribute 속성 값은 일치해야함 -->
	<form:form modelAttribute="boardMemberVO" method="post" action="/form/register">
		<table>
			<tr>
				<!-- <input type="text" name="memId" id="memId" /> -->
				<th><form:label path="memId"> 유저ID</form:label> </th>
				<td>
					<form:hidden path="memId"/>
						<font color="red"><form:errors path="memId"/></font>
				</td>
			</tr>
			<tr>
				<!-- <input type="text" name="memName" id="memName" /> -->
				<th><form:label path="memName">이름</form:label></th>
				<td>
					<form:input path="memName"/>
						<font color="red"><form:errors path="memName"/></font>
				</td>
			</tr>
			<tr>
				<!-- <input type="text" name="memName" id="memName" /> -->
				<th><form:label path="password">비밀번호</form:label></th>
				<td>
					<form:password path="password"/>
						<font color="red"><form:errors path="password"/></font>
				</td>
			</tr>
			<tr>
				<!-- <input type="text" name="memName" id="memName" /> -->
				<th>자기소개</th>
				<td>
					<form:textarea path="introduction"/>
						<font color="red"><form:errors path="introduction"/></font>
				</td>
			</tr>
			<tr>
				<!-- <input type="text" name="memName" id="memName" /> -->
				<th>취미(hobbyList)</th>
				<td>
<%-- 					<form:checkboxes path="hobbyList" items="${hobbyMap}"/> --%>
				</td>
			</tr>
			<tr>
				<th>개발자여부</th>
				<td>
					<form:checkbox  path="developer" value="Y"/>
				</td>
			</tr>
			<tr>
				<th>외국인여부</th>
				<td>
					<form:checkbox  path="foreigner" value="false"/>
				</td>
			</tr>
<!-- 			<tr> -->
<!-- 				<th>성별</th> -->
<!-- 				<td> -->
<!-- 				private gender -->
<%-- 					<form:radiobuttons  path="gender" items="${gender}"/> --%>
<!-- 				</td> -->
<!-- 			</tr> -->
			<tr>
				<th>성별</th>
				<td>
					<form:radiobutton  path="gender" value="male" label="male"/>
					<form:radiobutton  path="gender" value="female" label="female"/>
					<form:radiobutton  path="gender" value="other" label="other"/>
				</td>
			</tr>
<!-- 			<tr> -->
<!-- 				<th>국적</th> -->
<!-- 				<td> -->
<%-- 					<form:select path="nationality" items="${nationalityMap}"/> --%>
<!-- 				</td> -->
<!-- 			</tr> -->
			<tr>
				<th>국적</th>
				<td>
					<select id="nationality" name="nationality">
						<option value="korea">korea</option>
						<option value="germany">germany</option>
						<option value="australia">australia</option>
					</select>
				</td>
			</tr>
		</table>
		<form:button name="register">등록</form:button>
	</form:form>
</body>
</html>