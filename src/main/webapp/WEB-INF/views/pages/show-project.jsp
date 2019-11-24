<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../layout/header.jsp" />
     <div class="breadcome-area" style="margin-left: 200px;">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="breadcome-list">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <div class="breadcome-heading">
                                            <form role="search" class="sr-input-func" action="/show-searchproject" method="post">
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
		      <div class="single-pro-review-area mt-t-30 mg-b-15" style="margin-left: 190px;">
               <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-6 col-xs-12">
                        <div class="sparkline9-list mt-b-30 res-mg-t-30 analysis-progrebar-ctn">
                            <div class="sparkline9-hd">
						<c:if test='${Boolean.parseBoolean(success)}'>
							<div class="alert alert-success">${message}<a
									href="/show-project"><i class="fa fa-times"
									style="margin-left: 1062px;"></i></a>
							</div>
						</c:if>
						<c:if test='${Boolean.parseBoolean(error)}'>
							<div class="alert alert-danger">${message}</div>
						</c:if>
						<div class="main-sparkline9-hd">
                                    <h1>Project Table</h1>
                                </div>
                            </div>
                            <div class="sparkline9-graph">
                                <div class="static-table-list">
                                    <table class="table sparkle-table">
								<thead>
									<tr>
										<th>#</th>
										<th>projectName</th>
										<th>ProjectManager</th>
										<th>clientName</th>
										<th>projectType</th>
										<th>databaseTech</th>
										<th>forntTech</th>
										<th>desCripation</th>
										<th>date</th>
										<th>Acetion</th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach var="proj" items="${projectList}">
										<tr>
											<td>${proj.id}</td>
											<td>${proj.projectName}</td>
											<td>${proj.projectManager}</td>
											<td>${proj.clientName}</td>
											<td>${proj.projectType}</td>
											<td>${proj.databaseTech}</td>
											<td>${proj.forntTech}</td>
											<td>${proj.desCripation}</td>
											<td>${proj.date}</td>
											
											<td><a class="btn btn-success"
												href="/project/edit/${proj.id}"><i class="fa fa-edit"></i></a>
												<a class="btn btn-success"
												href="/project/delete/${proj.id}">
												<i class="fa fa-trash"></i></a>
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
        


<jsp:include page="../layout/footer.jsp" />





