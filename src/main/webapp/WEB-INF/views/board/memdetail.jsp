<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<div class="row">
         			<c:if test="${data.filename ne null}">
                    <img class="col-lg-5 d-none d-lg-block" src="/resources/upload/${data.filename}">
                    </c:if>
         			<c:if test="${data.filename eq null}">
                   	<div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    </c:if>
                    <div class="col-lg-7">
                        <div class="p-5">
   								<div class="form-group row">                                  
                                       	<h3 class="text-center">아이디: ${data.memId}</h3>
                                </div>
   								<div class="form-group row">
   								<fmt:formatDate var="resultRegDt" value="${data.memBir}"
										pattern="yyyy-MM-dd" />                                  
                                       	<h3 class="text-center">생년월일: ${resultRegDt}</h3>
                                </div>
   								<div class="form-group row">                                  
                                       	<h3 class="text-center">직업: ${data.memJob}</h3>
                                </div>
   								<div class="form-group row">                                  
                                       	<h3 class="text-center">취미: ${data.memLike}</h3>
                                </div>
   								<div class="form-group row">                                  
                                       	<h3 class="text-center">전화번호: ${data.memHp}</h3>
                                </div>
                                </div>
                                <div class="col-lg-3">
                                <a href="/board/update?memId=${data.memId}" class="btn btn-primary btn-user btn-block">
                                   	수정하기
                                </a>
                                <hr>
                                <a href="/board/delete?memId=${data.memId}" class="btn btn-google btn-user btn-block">
                                   	삭제하기
                                </a>
                               </div>
                        </div>
                    </div> 
</body>
</html>