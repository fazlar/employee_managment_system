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
                                            <form role="search" class="sr-input-func" action="/searchproject-byusername/${pageContext.request.remoteUser}" method="post">
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
                                            <li><span class="bread-blod">Show employee</span>
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
                                    <h1>My Project</h1>
                                </div>
                            </div>
                            <div class="sparkline9-graph">
                                <div class="static-table-list">
                                    <table class="table sparkle-table">
								<thead>
									<tr>
										<th>#</th>
										<th>empName</th>
										<th>projectName</th>
										<th>date</th>
										<th>status</th>
										<th>Acetion</th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach var="apro" items="${assignProjectByUserName}">
										<tr>
											<td>${apro.id }</td>
											<td>${apro.empName }</td>
											<td>${apro.projectName }</td>
											<td>${apro.date }</td>
											<td>${apro.status }</td>
											
											<td>
											<c:if test="${apro.status == 'complete'}">
											<a class="btn btn-success"
												href="/getproject-update/${apro.id}/${pageContext.request.remoteUser}" disabled="disabled"><i class="fa fa-check"></i></a>
												</c:if>
												<c:if test="${apro.status == 'inComplete'}">
											<a class="btn btn-success"
												href="/getproject-update/${apro.id}/${pageContext.request.remoteUser}"><i class="fa fa-check"></i></a>
												</c:if>
												
													</td>
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