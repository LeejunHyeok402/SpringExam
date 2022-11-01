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
         <form id="frm" action="/register/register05" method="post">
            <div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">userId</label>
				  <input type="text" class="form-control" name="userId" id="exampleFormControlInput1" placeholder="userId" value="a001" required>
				</div>
				<div class="mb-3">
				  <label for="exampleFormControlTextarea1" class="form-label">password</label>
				 <input type="password" class="form-control" name="password" id="exampleFormControlInput1" placeholder="password" value="java" required>
				</div>
				<div class="mb-3">
				  <label for="exampleFormControlTextarea1" class="form-label">password</label>
				 <input type="text" class="form-control" name="coin" id="exampleFormControlInput1" placeholder="coin" value="100" required>
				</div>
				<div class="mb-3">
				  <label for="exampleFormControlTextarea1" class="form-label">birth</label>
				 <input type="date" class="form-control" name="birth" id="birth" placeholder="birth" value="2022-11-01" required>
				</div>
				<p>성별</p>
				<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="gender" id="gender1" value="male" selected>
					  <label class="form-check-label" for="gender1">male</label>
				</div>
				<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="gender" id="gender2" value="female">
					  <label class="form-check-label" for="gender2">female</label>
				</div>
				
				<div class="form-check form-check-inline">
					  <input class="form-check-input" type="radio" name="gender" id="gender3" value="other" >
					  <label class="form-check-label" for="gender3">other</label>
				</div>
				 <div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">nationality</label>
				  <p>
				  <select class="form-select" name="nationality" aria-label="Default select example">
						  <option selected>Open this select menu</option>
						  <option value="korea" selected>대한민국</option>
						  <option value="america">미국</option>
						  <option value="australia">호주</option>
					</select>
					</p>
				  </div>
				 <div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">cars</label>
				  <p>
				  <select class="form-select" name="cars" multiple aria-label="Default select example">
						  <option selected>Open this select menu</option>
						  <option value="k5">k5</option>
						  <option value="qm6">qm6</option>
						  <option value="audi">audi</option>
					</select>
					</p>
				  </div>
				 <div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">hobby</label>
				 <p>
				  <div class="form-check form-check-inline">
					  <input class="form-check-input" name="hobbyList" type="checkbox" id="hobyList1" value="footsal">
					  <label class="form-check-label" for="hobyList1">footsal</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" name="hobbyList" type="checkbox" id="hobyList2" value="movie">
					  <label class="form-check-label" for="hobyList2">movie</label>
					</div>
					<div class="form-check form-check-inline">
					  <input class="form-check-input" name="hobbyList" type="checkbox" id="hobyList3" value="drama">
					  <label class="form-check-label" for="hobyList3">drama</label>
					</div>
					</p>
				  </div>
				 <div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">merriaged</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					
					  <input class="form-check-input" type="checkbox" name="merriaged" id="merriaged" value="false" aria-label="...">
					
				  </div>
				 <div class="mb-3">
				  <div class="p-5">
                           
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user"  name="addressVO.postCode" id="postCode" placeholder="postCode" />
                                    </div>
                                <a id="btnZipCode" onclick="openHomeSeach()" class="btn btn-primary btn-icon-split">
                                        <span class="icon text-white-50">
                                            <i class="fas fa-flag"></i>
                                        </span>
                                        <span class="text">Search For PostCode</span>
                                    </a>
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control form-control-user" name="addressVO.address" id="address" placeholder="address" />
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control form-control-user" name="addressVO.addressDetail" id="addressDetail" placeholder="addressDetail" />
                                </div>
                               </div>
                               </div>
                               <div class="mb-3">
						           <label for="exampleFormControlInput1" class="form-label">Cards</label>
						           <div class="col-lg-6">
				                    <div class="card mb-4 py-3 border-left-primary">
				                        <div class="card-body">
				                                     번호 : <input type="text" class="form-control form-control-user" 
				                                 name="cardVOList[0].no" id="no1" placeholder="no" />
				                                     유효년월 : <input type="date" class="form-control form-control-user" 
				                                 name="cardVOList[0].validMonth" id="validMonth1" placeholder="validMonth" />
					                        </div>
					                    </div>
				                    <div class="card mb-4 py-3 border-left-primary">
				                        <div class="card-body">
				                                     번호 : <input type="text" class="form-control form-control-user" 
				                                 name="cardVOList[1].no" id="no1" placeholder="no" />
				                                     유효년월 : <input type="date" class="form-control form-control-user" 
				                                 name="cardVOList[1].validMonth" id="validMonth1" placeholder="validMonth" />
					                        </div>
					                    </div>
					              </div>
					         </div>
                            </form>
                        </div>
				  </div>
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
