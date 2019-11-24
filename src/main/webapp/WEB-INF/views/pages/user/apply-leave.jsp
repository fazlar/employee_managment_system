<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	
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
                                                <input type="text" placeholder="Search..." class="search-int form-control">
                                                <a href="#"><i class="fa fa-search"></i></a>
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
<div class="single-pro-review-area mt-t-30 mg-b-15"
	style="margin-left: 200px;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="product-payment-inner-st">
					<ul id="myTabedu1" class="tab-review-design">
						<li class="active"><a href="#description">Leave
								Information</a></li>


					</ul>
					<div id="myTabContent" class="tab-content custom-product-edit">
						<!--start-->
						<div class="product-tab-list tab-pane fade active in"
							id="description">
							<div class="row">
							 <c:if test='${Boolean.parseBoolean(success)}'>
		                                           <div class="alert alert-success">${message} <a href="/applyleave"><i class="fa fa-trash" style="margin-left: 1235px;"></i></a></div>
	                                               </c:if>
	                                               <c:if test='${Boolean.parseBoolean(error)}'>
		                                           <div class="alert alert-danger">${message}<a href="/applyleave"><i class="fa fa-trash" style="margin-left: 1235px;"></i></a></div>
	                                                           </c:if>
                                                
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div class="review-content-section">
										<div id="dropzone1" class="pro-ad">
											<form action="/applyLeave"
												class="dropzone dropzone-custom needsclick add-professors"
												id="demo1-upload" method="post">
												<div class="row">
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
														<div class="form-group">
															<input name="empname" type="text" class="form-control"
																placeholder="Enter your Name">
																<input name="userName" type="hidden" class="form-control"
																value="${pageContext.request.remoteUser}">
														</div>

														

														<div class="form-group">
															<input name="toDate" type="date" class="form-control"
																placeholder="Frontend Technology">
														</div>

														<div class="form-group res-mg-t-15">
															<textarea name="description" placeholder="Description"></textarea>
														</div>

													</div>
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
														<div class="form-group">
															<input name="reason" type="text" class="form-control"
																placeholder="reason for Leave" required="required">
														</div>
														
														<div class="form-group">
															<input name="fromdate" type="date" class="form-control"
																placeholder="Database Technology">
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
  





<jsp:include page="../../layout/user-footer.jsp" />