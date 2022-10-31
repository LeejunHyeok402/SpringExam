<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/resources/js/jquery.min.js"></script>
<script>
	$(function(){
		$("#aSubmit").on("click", function(){
			$("#frm").submit();
		});
	});

</script>
<div class="card shadow mb-4">
     <!-- Card Header - Accordion -->
     <a href="#collapseCardExample" class="d-block card-header py-3" data-toggle="collapse" role="button" aria-expanded="true" aria-controls="collapseCardExample">
         <h6 class="m-0 font-weight-bold text-primary">요청 파라미터</h6>
     </a>
     <!-- Card Content - Collapse -->
     <div class="collapse show" id="collapseCardExample">
         <div class="card-body">
         <form id="frm" action="/register/register04" method="post">
            <div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">userId</label>
				  <input type="text" class="form-control" name="userId" id="exampleFormControlInput1" placeholder="userId" required>
				</div>
				<div class="mb-3">
				  <label for="exampleFormControlTextarea1" class="form-label">password</label>
				 <input type="password" class="form-control" name="password" id="exampleFormControlInput1" placeholder="password" required>
				</div>
				<div class="mb-3">
				  <label for="exampleFormControlTextarea1" class="form-label">password</label>
				 <input type="text" class="form-control" name="coin" id="exampleFormControlInput1" placeholder="coin" required>
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
