<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/header.jsp" />

<!--content -->
<div class="single-pro-review-area mt-t-30 mg-b-15"
	style="margin-left: 230px;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="product-payment-inner-st">
					<ul id="myTabedu1" class="tab-review-design">
						<li class="active"><a href="#description">Mail info</a></li>


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
											<form action="/sendEmail"
												class="dropzone dropzone-custom needsclick add-professors"
												id="demo1-upload" method="post">
												<div class="row">

													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">

														<div class="form-group">
															<label>To</label> <input type="text" name="email"
																class="form-control" />
														</div>

														<div class="form-group">
															<label>Subject</label> <input type="text" name="sub"
																class="form-control" />
														</div>
														<div class="form-group">
															<label>Message</label>
															<textarea rows="10" cols="50" name="body"></textarea>
														</div>
														
														<div class="payment-adress">
															<button type="submit"
																class="btn btn-primary waves-effect waves-light">Submit</button>
														</div>

													</div>
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12"></div>
												</div>
												<div class="row">
													<div class="col-lg-12"><</div>
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


<jsp:include page="../layout/footer.jsp" />