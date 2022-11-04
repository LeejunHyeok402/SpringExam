<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
 <link href="/resources/sbadmin2/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/resources/sbadmin2/css/sb-admin-2.min.css" rel="stylesheet">
	<script src="/resources/js/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#show").on("change",function(){

			let val = $(this).val();
			
			
			location.href= "<%=request.getContextPath()%>/board/boards?currentPage=1&show="+val;
		});
	})
</script>
</head>
<body>
	<div class="card-body">
                            <div class="table-responsive">
			<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
				<form action="/board/boards" name="frm" id="frm" method="get">
					<input type="hidden" name="currentPage" value="${param.currentPage}"/>
					<div class="row">
						<div class="col-sm-12 col-md-6">
							<div class="dataTables_length" id="dataTable_length">
								<label>Show <select id="show" name="show"
									aria-controls="dataTable"
									class="custom-select custom-select-sm form-control form-control-sm">
										<option value="10"
											<c:if test="${param.show eq 10}">selected</c:if>>10</option>
										<option value="25"
											<c:if test="${param.show eq 25}">selected</c:if>>25</option>
										<option value="50"
											<c:if test="${param.show eq 50}">selected</c:if>>50</option>
										<option value="100"
											<c:if test="${param.show eq 100}">selected</c:if>>100</option>

								</select> entries
								</label>
							</div>
						</div>
						<div class="col-sm-12 col-md-6">
							<div id="dataTable_filter" class="dataTables_filter">
								<label>Search:<input type="text" name="keyword"
									class="form-control form-control-sm" placeholder=""
									aria-controls="검색어를 입력해주세요" 
									value="${param.keyword}"/>
								</label>
								 <label>
									<button type="submit"
										class="btn btn-primary btn-icon-split btn-sm">
										<span class="icon text-white-50"> <i
											class="fas fa-flag"></i>
										</span> <span class="text">검색</span>
									</button>
								</label>
							</div>
						</div>
					</div>
				</form>
				<div class="row">
					<div class="col-sm-12">
						<table class="table table-bordered dataTable table-striped table-hover"
							id="dataTable" width="100%" cellspacing="0" role="grid"
							aria-describedby="dataTable_info" style="width: 100%;">
							<thead>
								<tr role="row">
									<th class="sorting sorting_asc" tabindex="0"
										aria-controls="dataTable" rowspan="1" colspan="1"
										aria-sort="ascending"
										aria-label="Name: activate to sort column descending"
										style="width: 64px;">회원아이디</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable"
										rowspan="1" colspan="1"
										aria-label="Position: activate to sort column ascending"
										style="width: 76px;">회원명</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable"
										rowspan="1" colspan="1"
										aria-label="Office: activate to sort column ascending"
										style="width: 53px;">직업</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable"
										rowspan="1" colspan="1"
										aria-label="Age: activate to sort column ascending"
										style="width: 31px;">취미</th>
									<th class="sorting" tabindex="0" aria-controls="dataTable"
										rowspan="1" colspan="1"
										aria-label="Start date: activate to sort column ascending"
										style="width: 69px;">생일</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<th rowspan="1" colspan="1">회원아이디</th>
									<th rowspan="1" colspan="1">회원명</th>
									<th rowspan="1" colspan="1">직업</th>
									<th rowspan="1" colspan="1">취미</th>
									<th rowspan="1" colspan="1">생일</th>
								</tr>
							</tfoot>
							<tbody>
								<!-- before => data : List<BoardMemberVO> / row : MemVO
                                   		after 페이징 처리후 => data : data.content 해야 리스트가 나옴
                                   		stat.count : 행번호(1,2,3,4,5)
                                   		stat.index: 인덱스번호(0,1,2,3,4)
                                    -->
								<c:forEach var="row" items="${data.content}" varStatus="stat">
									<fmt:formatDate var="resultRegDt" value="${row.memBir}"
										pattern="yyyy-MM-dd" />
									<c:if test="${stat.count % 2 != 0}">
										<tr class="table-info" onclick="location.href='/board/memdetail?memId=${row.memId}'">
									</c:if>
									<c:if test="${stat.count % 2 == 0}">
										<tr class="odd"  onclick="location.href='/board/memdetail?memId=${row.memId}'">
									</c:if>
									<td class="sorting_1">${row.memId}</td>
									<td>${row.memName}</td>
									<td>${row.memJob}</td>
									<td>${row.memLike}</td>
									<td>${resultRegDt}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12 col-md-5">
						<div class="dataTables_info" id="dataTable_info" role="status"
							aria-live="polite">
							<!-- /board/list 보정해보자 -->
							<c:if test="${param.show==null}">
								<c:set var="show" value="10" />
							</c:if>
							<c:if test="${param.show!=null}">
								<c:set var="show" value="${param.show}" />
							</c:if>
							<c:if test="${param.currentPage==null}">
								<c:set var="currentPage" value="1" />
							</c:if>
							<c:if test="${param.currentPage!=null}">
								<c:set var="currentPage" value="${param.currentPage}" />
							</c:if>
							<!-- 한 화면에 보여지는 행 수 : show -->
							<c:set var="show" value="${show}" />
							<!-- 종료행번호 : currentPage * 10행 -->
							<c:set var="endRow" value="${currentPage * show}" />
							<!-- 시작행번호 : 종료행번호 - (10 - 1) -->
							<c:set var="startRow" value="${endRow-(show-1)}" />
							<!-- Showing 351 to 400 of 360 entries 보정 -->
							<c:if test="${endRow>data.total}">
								<c:set var="endRow" value="${data.total}" />
							</c:if>
							Showing ${startRow} to ${endRow} of ${data.total} entries
						
						</div>
					</div>
					<div class="col-sm-12 col-md-7">
						<div class="dataTables_paginate paging_simple_numbers"
							id="dataTable_paginate">
							<ul class="pagination">
								<li
									class="paginate_button page-item previous 
                                <c:if test='${data.startPage lt 6}'>disabled</c:if>"
									id="dataTable_previous"><a
									href="/board/boards?currentPage=${data.startPage-5}&show=${show}"
									aria-controls="dataTable" data-dt-idx="0" tabindex="0"
									class="page-link">Previous</a> <c:forEach var="pNo"
										begin="${data.startPage}" end="${data.endPage}">
										<li
											class="paginate_button page-item
                                <c:if test="${pNo eq data.currentPage}">active</c:if>
                                
                                "><a
											href="/board/boards?currentPage=${pNo}&show=${show}"
											aria-controls="dataTable" data-dt-idx="1" tabindex="0"
											class="page-link">${pNo}</a></li>
									</c:forEach> <c:if test="${data.endPage lt data.totalPages}">
										<a
											href="/board/boards?currentPage=${data.startPage+5}&show=${show}"
											aria-controls="dataTable" data-dt-idx="0" tabindex="0"
											class="page-link">Next</a>
									</c:if>
							</ul>
							<a href="/board/insertBoard" class="btn btn-primary float-right">회원
								추가</a>
						</div>
					</div>

				</div>
			</div></body>
</html>