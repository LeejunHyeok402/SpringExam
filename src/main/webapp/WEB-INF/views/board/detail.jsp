<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="/resources/js/jquery.min.js"></script>
<script src="/resources/js/validation.js"></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<style type="text/css">

</style>
<script>
		
</script>
<div class="card shadow mb-4">
     <!-- Card Header - Accordion -->
     <a href="#collapseCardExample" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCardExample">
         <h6 class="m-0 font-weight-bold text-primary">요청 파라미터</h6>
     </a>
     <!-- Card Content - Collapse -->
     <div class="collapse show" id="collapseCardExample">
         <div class="card-body">
         <form id="frm" name="frm" action="/board/insert" method="post" enctype="multipart/form-data">
				  <label for="exampleFormControlInput1" class="form-label">userId</label>
            <div class="mb-3">
				  <input type="text" class="form-control" name="memId" id="memId" placeholder="userId" value="${data.memId}" required readonly>
				  <button type="button" id="idCheck" class="btn btn-primary" onclick="fn_idCheck()">중복 체크</button>
				  </div>
				
				  <div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">user name</label>
				  <input type="text" class="form-control" name="memName" id="memName" placeholder="user name" value="${data.memName}" required>
				</div>		
				<div class="mb-3">
				  <label for="exampleFormControlTextarea1" class="form-label">birth</label>
				  <fmt:formatDate value='${data.memBir}' pattern='yyyy-MM-dd'/>
				 <input type="date" class="form-control" name="memBir" id="birth" value="${data.memBir}" >
				</div>
				 <div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">memJob</label>
				  <input type="text" class="form-control" name="memJob" id="exampleFormControlInput1" placeholder="user job" value="${data.memJob}" >
				</div>
				 <div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">memLike</label>
				  <input type="text" class="form-control" name="memLike" id="exampleFormControlInput1" placeholder="user like" value="${data.memLike}" >
				</div>
				 <div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">전화번호</label>
				  <input type="text" class="form-control" name="memHp" id="memHp" placeholder="user phone" value="${data.memHp}" pattern="/^(01[016789]{1})-?[0-9]{3,4}-?[0-9]{4}$/">
				</div>
				<div class="form-group row">
				<label class="col-sm-2">이미지</label>
				<div class="col-sm-5">
					<input type="file" id="memberImage" name="memberImage" class="form-control" multiple required>
				</div>
				</div>
			<div class="form-group row">
				<div class="imgs_wrap">
					<c:forEach items="${list}" var="attachList">
						<img src="/resources/upload${attachList.attachName}">
					</c:forEach>
				</div>
			</div>
			<div class="mb-3">
					 <input type="button" id="aSubmit" onclick="checkAddMember()" class="btn btn-primary btn-icon-split" value="요청파라미터" disabled>
					 <a href="/board/boards" class="btn btn-secondary btn-icon-split">취소</a>
	                </div>
				</form>
         </div>
     </div>
 </div>
