<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	
<jsp:include page="../layout/header.jsp" />

<!--content -->
<div class="single-pro-review-area mt-t-30 mg-b-15"
	style="margin-left: 200px;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="product-payment-inner-st">
					<ul id="myTabedu1" class="tab-review-design">
						<li class="active"><a href="#description">Project
								Information</a></li>


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
											<form action="/addproject"
												class="dropzone dropzone-custom needsclick add-professors"
												id="demo1-upload" method="post">
												<div class="row">
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
														<div class="form-group">
															<input name="projectName" type="text" class="form-control"
																placeholder="project Name">
														</div>

														<div class="form-group">
															<select name="projectType" class="form-control">
																<option value="none" selected="" disabled="">Select
																	project Type</option>
																<option value="0">New project</option>
																<option value="1">existing project</option>

															</select>
														</div>

														<div class="form-group">
															<input name="frontend" type="number" class="form-control"
																placeholder="Frontend Technology">
														</div>

														<div class="form-group res-mg-t-15">
															<textarea name="description" placeholder="Description"></textarea>
														</div>

													</div>
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
														<div class="form-group">
															<input name="clientName" type="text" class="form-control"
																placeholder="Client Name">
														</div>
														<div class="form-group">
															<select name="projectManager" class="form-control">
																<option value="none" selected="" disabled="">Select
																	project MANAGER</option>
																<c:forEach items="${projectManager}" var="pm">
                                                                    <option value="${pm.fullname}">${pm.fullname}</option>
                                                                   </c:forEach>
															</select>
														</div>
														<div class="form-group">
															<input name="database" type="text" class="form-control"
																placeholder="Database Technology">
														</div>

														<div class="form-group">
															<input name="date" id="finish" type="text"
																class="form-control" placeholder="Date">
														</div>
													</div>
												</div>
												<div class="row">
													<div class="col-lg-12">
														<div class="payment-adress">
															<button type="submit"
																class="btn btn-primary waves-effect waves-light">Submit</button>
														</div>
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!--end-->
						<div class="product-tab-list tab-pane fade" id="reviews">
							<div class="row">
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div class="review-content-section">
										<div class="row">
											<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
												<form id="acount-infor" action="#" class="acount-infor">
													<div class="devit-card-custom">
														<div class="form-group">
															<input type="text" class="form-control" name="email"
																placeholder="Email">
														</div>
														<div class="form-group">
															<input name="phoneno" type="number" class="form-control"
																placeholder="Phone">
														</div>
														<div class="form-group">
															<input name="password" type="password"
																class="form-control" placeholder="Password">
														</div>
														<div class="form-group">
															<input name="confarmpassword" type="password"
																class="form-control" placeholder="Confirm Password">
														</div>
														<a href="#"
															class="btn btn-primary waves-effect waves-light">Submit</a>
													</div>
												</form>
											</div>
										</div>
									</div>
								</div>
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
