<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../../layout/user-header.jsp" />

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
										class="search-int form-control"> <a href="#"><i
										class="fa fa-search"></i></a>
								</form>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<ul class="breadcome-menu">
								<li><a href="#">Home</a> <span class="bread-slash">/</span>
								</li>
								<li><span class="bread-blod">project</span></li>
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
<div class="single-pro-review-area mt-t-30 mg-b-15"
	style="margin-left: 200px;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="product-payment-inner-st">
					<ul id="myTabedu1" class="tab-review-design">
						<li class="active"><a href="#description">Attendance</a></li>


					</ul>
					<div id="myTabContent" class="tab-content custom-product-edit">
						<!--start-->
						<div class="product-tab-list tab-pane fade active in"
							id="description">
							<div class="row">
								<c:if test='${Boolean.parseBoolean(success)}'>
									<div class="alert alert-success">${message}</div>
								</c:if>
								<c:if test='${Boolean.parseBoolean(error)}'>
									<div class="alert alert-danger">${message}</div>
								</c:if>
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div class="review-content-section">
										<div id="dropzone1" class="pro-ad">
											<form action="/stake-attendance"
												class="dropzone dropzone-custom needsclick add-professors"
												id="demo1-upload" method="post">
												<div class="row">

													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">




														<div class="form-group">
															<label class="control-label" for="email">Start
																Attendance</label> <input name="text" type="text"
																class="form-control" value="${startAttendance}"
																disabled="">
														</div>

														<div class="form-group">
															<label class="control-label" for="email">current
																time</label> <input name="cutime" type="text"
																class="form-control" value="${CurrentTime}" disabled="">
														</div>
														<div class="form-group">
															<label class="control-label" for="email">ENTER
																YOUR NAME </label> <input name="fullname" type="text"
																class="form-control" value="${userInfoEntity.fullname}">




															<input name="cutime" type="hidden" class="form-control"
																value="${CurrentHour}">

														</div>

														<div class="payment-adress">
															<button type="submit"
																class="btn btn-primary waves-effect waves-light">Submit</button>
														</div>

													</div>
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
														<div class="sparkline9-hd">
															<div class="main-sparkline9-hd">
																<h1>last Attendance</h1>
															</div>
														</div>
														<div class="sparkline9-graph">
															<div class="static-table-list">
																<table class="table sparkle-table">
																	<thead>
																		<tr>
																			<th>#</th>
																			<th>empName</th>
																			<th>time</th>
																			<th>date</th>

																			<th>Acetion</th>

																		</tr>
																	</thead>
																	<tbody>
																		<c:forEach var="atten" items="${shoattendance}">
																			<tr>
																				<td>${atten.id}</td>
																				<td>${atten.empName}</td>
																				<td>${atten.time}</td>
																				<td>${atten.date}</td>
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
											<div class="col-lg-12"></div>
										</div>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!--end-->


				</div>
			</div>
		</div>
	</div>
</div>
</div>

<!--content end-->




<jsp:include page="../../layout/user-footer.jsp" />