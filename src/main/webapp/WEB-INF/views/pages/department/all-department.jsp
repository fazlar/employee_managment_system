<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	
<jsp:include page="../../layout/header.jsp" />
    <!--content -->
		      <div class="single-pro-review-area mt-t-30 mg-b-15" style="margin-left: 200px;">
               <div class="container-fluid">
               <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        <div class="sparkline8-list">
                            <div class="sparkline8-hd">
                                <div class="main-sparkline8-hd">
                                    <h1 align="center">ADMINISTRATION DEPARTMENT</h1>
                                </div>
                            </div>
                            <div class="sparkline8-graph">
                                <div class="static-table-list">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Name</th>
                                                <th>Jobtype</th>
												<th>Country</th>
                                            </tr>
                                        </thead>
                                        <tbody>
										<c:forEach var="admin" items="${adminatration}">
                                            <tr>
                                                <td>${admin.id }</td>
                                                <td>${admin.fullname }</td>
                                                <td>${admin.jobtype }</td>
                                                <td>${admin.country }</td>
                                            </tr>
                                         </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        <div class="sparkline9-list mt-b-30 res-mg-t-30 analysis-progrebar-ctn">
                            <div class="sparkline9-hd">
                                <div class="main-sparkline9-hd">
                                    <h1 align="center">DATABASE DESIGNE DEPARTMENT</h1>
                                </div>
                            </div>
                            <div class="sparkline9-graph">
                                <div class="static-table-list">
                                    <table class="table sparkle-table">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Name</th>
                                                <th>Jobtype</th>
												<th>Country</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="data" items="${database}">
                                            <tr>
                                                <td>${data.id }</td>
                                                <td>${data.fullname }</td>
                                                <td>${data.jobtype }</td>
                                                <td>${data.country }</td>
                                            </tr>
                                         </c:forEach>
                                            
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        <div class="sparkline10-list mt-b-30">
                            <div class="sparkline10-hd">
                                <div class="main-sparkline10-hd">
                                    <h1 align="center">WEB DEVELOPMENT DEPARTMENT</h1>
                                </div>
                            </div>
                            <div class="sparkline10-graph">
                                <div class="static-table-list">
                                    <table class="table border-table">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Name</th>
                                                <th>Jobtype</th>
												<th>Country</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="web" items="${webdeprt}">
                                            <tr>
                                                <td>${web.id }</td>
                                                <td>${web.fullname }</td>
                                                <td>${web.jobtype }</td>
                                                <td>${web.country }</td>
                                            </tr>
                                         </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        <div class="sparkline11-list mt-b-30">
                            <div class="sparkline11-hd">
                                <div class="main-sparkline11-hd">
                                    <h1 align="center">NET WORKING DEPARTMENT</h1>
                                </div>
                            </div>
                            <div class="sparkline11-graph">
                                <div class="static-table-list">
                                    <table class="table sparkle-table">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Name</th>
                                                <th>Jobtype</th>
												<th>Country</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="nt" items="${ntdepart}">
                                            <tr>
                                                <td>${nt.id }</td>
                                                <td>${nt.fullname }</td>
                                                <td>${nt.jobtype }</td>
                                                <td>${nt.country }</td>
                                            </tr>
                                         </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        <div class="sparkline12-list mg-b-30">
                            <div class="sparkline12-hd">
                                <div class="main-sparkline12-hd">
                                    <h1 align="center">FINANCE DEPARTMENT</h1>
                                </div>
                            </div>
                            <div class="sparkline12-graph">
                                <div class="static-table-list">
                                    <table class="table hover-table">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Name</th>
                                                <th>Jobtype</th>
												<th>Country</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                           <c:forEach var="fina" items="${finance}">
                                            <tr>
                                                <td>${fina.id }</td>
                                                <td>${fina.fullname }</td>
                                                <td>${fina.jobtype }</td>
                                                <td>${fina.country }</td>
                                            </tr>
                                         </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        <div class="sparkline13-list mg-b-15">
                            <div class="sparkline13-hd">
                                <div class="main-sparkline13-hd">
                                    <h1 align="center">HR DEPARTMENT</h1>
                                </div>
                            </div>
                            <div class="sparkline13-graph">
                                <div class="static-table-list">
                                    <table class="table sparkle-table">
                                        <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>Name</th>
                                                <th>Jobtype</th>
												<th>Country</th>>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="hr" items="${hrdepart}">
                                            <tr>
                                                <td>${hr.id }</td>
                                                <td>${hr.fullname }</td>
                                                <td>${hr.jobtype }</td>
                                                <td>${hr.country }</td>
                                            </tr>
                                         </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
				<!--end-->
            </div>
        </div>
		
		<!--content end-->

  <jsp:include page="../../layout/footer.jsp" />