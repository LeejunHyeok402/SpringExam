<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/resources/js/jquery.min.js"></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script>
	$(function(){
		$("#aSubmit").on("click", function(){
			$("#frm").submit();
		});
		
		$("#merriaged").on("click",function(){
			$("#merriaged").val(!JSON.parse($("#merriaged").val()));
		});
		
	});
		function openHomeSeach(){
			new daum.Postcode({
				oncomplete:function(data){
					$("[name='addressVO.postCode']").val(data.zonecode);
					$("[name='addressVO.address']").val(data.address);
					$("[name='addressVO.addressDetail']").val(data.buildingName);
				}
			}).open();
		};

</script>
<div class="card shadow mb-4">
     <!-- Card Header - Accordion -->
     <a href="#collapseCardExample" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCardExample">
         <h6 class="m-0 font-weight-bold text-primary">요청 파라미터</h6>
     </a>
     <!-- Card Content - Collapse -->
     <div class="collapse show" id="collapseCardExample">
         <div class="card-body">
         <form id="frm" action="/board/insert" method="post" enctype="multipart/form-data">
            <div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">userId</label>
				  <input type="text" class="form-control" name="memId" id="exampleFormControlInput1" placeholder="userId" value="" required>
				</div>
				  <div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">user name</label>
				  <input type="text" class="form-control" name="memName" id="exampleFormControlInput1" placeholder="user name" value="" required>
				</div>		
				<div class="mb-3">
				  <label for="exampleFormControlTextarea1" class="form-label">birth</label>
				 <input type="date" class="form-control" name="memBir" id="birth" placeholder="birth" value="2022-11-01" required>
				</div>
				 <div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">memJob</label>
				  <input type="text" class="form-control" name="memJob" id="exampleFormControlInput1" placeholder="user job" value="" required>
				</div>
				 <div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">memLike</label>
				  <input type="text" class="form-control" name="memLike" id="exampleFormControlInput1" placeholder="user like" value="" required>
				</div>
				<div class="form-group row">
				<label class="col-sm-2">사진</label>
				<div class="col-sm-5">
					<input type="file" id="memberImage" name="memberImage" class="form-control" multiple>
				</div>
			</div>
			<div class="form-group row">
				<div class="imgs_wrap">
					
				</div>
			</div>
				</form>
				<div class="mb-3">
					 <a href="#" id="aSubmit" class="btn btn-primary btn-icon-split">
	                    <span class="icon text-white-50">
	                        <i class="fas fa-flag"></i>
	                    </span>
	                    <span class="text">요청파라미터</span>
	                </a>
				</div>
         </div>
     </div>
 </div>
