<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layout/header.jsp" />

<div class="breadcome-area">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="breadcome-list">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <div class="breadcome-heading">
                                            <form role="search" class="sr-input-func">
									<input type="text" placeholder="Search..."
										class="search-int form-control"> <a href="#"><i class="fa fa-search"></i></a>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <ul class="breadcome-menu">
                                            <li><a href="#">Home</a> <span class="bread-slash">/</span>
                                            </li>
                                            <li><span class="bread-blod">project</span>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
            <!--content -->
		      <div class="single-pro-review-area mt-t-30 mg-b-15" style="margin-left: 200px;">
               <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-6 col-xs-12">
                        <div class="sparkline9-list mt-b-30 res-mg-t-30 analysis-progrebar-ctn">
                            <div class="sparkline9-hd">
                                <div class="main-sparkline9-hd">
                                    <h1>Sparkle Table</h1>
                                </div>
                            </div>
                            <div class="sparkline9-graph" style="overflow: x-auto;">
                                <div class="static-table-list">
                                    <table class="table sparkle-table">
								<thead>
									<tr>
										<th>#</th>
										<th>empName</th>
										<th>reason</th>
										<th>todate</th>
										<th>fromdate</th>
										<th>descripation</th>
										<th>status</th>
										<th>Acetion</th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach var="leave" items="${leaveList}">
										<tr>
											<td>${leave.id }</td>
											<td>${leave.empName}</td>
											<td>${leave.reason}</td>
											<td>${leave.todate}</td>
											<td>${leave.fromdate}</td>
											<td>${leave.descripation }</td>
											<td>${leave.status }</td>
											<td>
											<c:if test="${leave.status == 'Approve'}">
											<a class="btn btn-success" id="ok"
												href="/leave-update/${leave.id}" disabled="disabled"><i class="fa fa-check"></i></a>
												</c:if>
												<c:if test="${leave.status == 'Pending'}">
											     <a class="btn btn-success" id="ok"
												href="/leave-update/${leave.id}"><i class="fa fa-check"></i></a>
												</c:if>
												<a class="btn btn-success"
												href="/user/delete/${user.leave}"><i
													class="fa fa-trash"></i></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
            </div>
        </div>
		
		<!--content end-->
<jsp:include page="../layout/footer.jsp" />