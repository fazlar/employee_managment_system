<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	
<jsp:include page="../../layout/user-header.jsp" />
   <div class="breadcome-area" style="margin-left: 50px;">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="breadcome-list">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <div class="breadcome-heading">
                                            <form role="search" class="sr-input-func" action="/search-byusername/${pageContext.request.remoteUser}" method="post">
                                            <table>
                                            <tr>
                                                <td>
                                                <input name="serch" type="text" placeholder="Search..." class="search-int form-control">
                                                </td>
                                                 <td>
                                                 <button type="submit" class="btn btn-primary waves-effect waves-light"><i class="fa fa-search"></i></button>
                                                  </td>
                                              </tr>
                                               </table>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <ul class="breadcome-menu">
                                            <li><a href="#">Home</a> <span class="bread-slash">/</span>
                                            </li>
                                            <li><span class="bread-blod">Show Schedule</span>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
     

            <!--content -->
		      <div class="single-pro-review-area mt-t-30 mg-b-15" style="margin-left: 50px;">
               <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-6 col-xs-12">
                        <div class="sparkline9-list mt-b-30 res-mg-t-30 analysis-progrebar-ctn">
                            <div class="sparkline9-hd">
                                <div class="main-sparkline9-hd">
                                    <h1>My Salary</h1>
                                </div>
                            </div>
                            <div class="sparkline9-graph">
                                <div class="static-table-list">
                                    <table class="table sparkle-table">
								<thead>
									<tr>
										<th>#</th>
										<th>Fullname</th>
										<th>Month</th>
										<th>Year</th>
										<th>Salary</th>
										
										
									</tr>
								</thead>
								<tbody>
									<c:forEach var="sal" items="${SalaruByUserName}">
										<tr>
											<td>${sal.id }</td>
											<td>${sal.empName }</td>
											<td>${sal.month }</td>
											<td>${sal.year }</td>
											<td>${sal.amount }</td>
											
											
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

<jsp:include page="../../layout/user-footer.jsp" />