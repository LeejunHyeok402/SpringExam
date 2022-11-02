<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/resources/js/jquery.min.js"></script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<style type="text/css">
	.imgs_wrap{
		width:300px;
		margin-top:50px;
	}
	.imgs_wrap img{
		max-width: 100%;
	}
</style>
<script>
   
	$(function(){
		
		
		let sel_file=[];
		
		$("#memberImage").on("change",handleImgFileSelect);
		//파라미터 e: onchange 이벤트 객체
		function handleImgFileSelect(e){
			//change이벤트가 발생된 타겟안에 이미지들을 가져와 보자
			let files = e.target.files;
			let fileArr = Array.prototype.slice.call(files);
			console.log(fileArr);
			//파일 타입의 배열 반복 f: 파일 배열 안에 들어있는 각각의 이미지 파일 객체
			fileArr.forEach(function(f){
					if(!f.type.match("image.*")){
						alert("이미지 확장자만 가능합니다");
						return;
					}
					//이미지 객체를 (f) 전역 배열타입 변수(sel_file)에 넣자
					sel_file.push(f);
					//이미지 객체를 읽을 자바스크립트의 reader 객체 생성
					let reader = new FileReader();
					//e: reader가 이미지 객체를 읽는 이벤트
					reader.onload = function(e){
						//e.target :이미지 객체
						//e.target.result : reader가 이미지를 다 읽은 결과
						let img_html = "<img src=\""+e.target.result+"\" />";
						//div 사이에 이미지가 렌더링 되어 화면에 보임
						//객체.append : 누적 , .html : 새로고침 ,innerHtml : J/S
						$(".imgs_wrap").append(img_html);
					}
						reader.readAsDataURL(f);
			});
		};
		$("#aSubmit").on("click", function(){
			
			
				
			
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
	
		function fn_idCheck(){
			let user_id = $("#memId").val();
			$.ajax({
				  url: "/board/idCheck", // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
				    data: JSON.stringify({"memId" :user_id}),  // HTTP 요청과 함께 서버로 보낼 데이터
				    method: "POST",   // HTTP 요청 메소드(GET, POST 등)
				    contentType: 'application/json',
				    dataType: "json",// 서버에서 보내줄 데이터의 타입
				    success: function (data) {
			           console.log(data.result);
			           if(data.result == 'true'){
			        	   alert("사용하실수 없는 아이디 입니다");
			           }
			           if(data.result == 'false'){
			        	   alert("사용하실수 있는 아이디 입니다");
			           }
			        }
			});
		}	
		
		
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
				  <input type="text" class="form-control" name="memId" id="memId" placeholder="userId" value="" required>
				  <button type="button" id="idCheck" onclick="fn_idCheck()">중복 체크</button>
				</div>
				  <div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">user name</label>
				  <input type="text" class="form-control" name="memName" id="exampleFormControlInput1" placeholder="user name" value="" required>
				</div>		
				<div class="mb-3">
				  <label for="exampleFormControlTextarea1" class="form-label">birth</label>
				 <input type="date" class="form-control" name="memBir" id="birth" placeholder="birth" value="2022-11-01" >
				</div>
				 <div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">memJob</label>
				  <input type="text" class="form-control" name="memJob" id="exampleFormControlInput1" placeholder="user job" value="" >
				</div>
				 <div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">memLike</label>
				  <input type="text" class="form-control" name="memLike" id="exampleFormControlInput1" placeholder="user like" value="" >
				</div>
				 <div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">전화번호</label>
				  <input type="text" class="form-control" name="memHp" id="memHp" placeholder="user phone" value="" pattern="/^[0-9]{2,3}[0-9]{3,4}[0-9]{4}/">
				</div>
				<div class="form-group row">
				<label class="col-sm-2">사진</label>
				<div class="col-sm-5">
					<input type="file" id="memberImage" name="memberImage" class="form-control" multiple required>
				</div>
			</div>
			<div class="form-group row">
				<div class="imgs_wrap">
					
				</div>
			</div>
			<div class="mb-3">
					 <input type="submit" id="aSubmit" class="btn btn-primary btn-icon-split" onsubmit="return false;" value="요청파라미터">
	             
	                    
	                </div>
				</form>
				
				
         </div>
     </div>
 </div>
