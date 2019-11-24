<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layout/header.jsp" />



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
                            <div class="sparkline9-graph">
                                <div class="static-table-list">
                                    <table class="table sparkle-table">
								<thead>
									<tr>
										<th>#</th>
										<th>Fullname</th>
										<th>Department</th>
										<th>Jobtype</th>
										<th>Mobileno</th>
										<th>Gender</th>
										<th>Country</th>
										<th>City</th>
										<th>Acetion</th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach var="emp" items="${employee}">
										<tr>
											<td>${emp.id }</td>
											<td>${emp.fullname }</td>
											<td>${emp.department }</td>
											<td>${emp.jobtype }</td>
											<td>${emp.mobileno }</td>
											<td>${emp.gender }</td>
											<td>${emp.country }</td>
											<td>${emp.city }</td>
											<td><a class="btn btn-success"
												href="/employee/edit/${emp.id}"><i class="fa fa-edit"></i></a>
												<a class="btn btn-success"
												href="/user/delete/${emp.id}"><i
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





