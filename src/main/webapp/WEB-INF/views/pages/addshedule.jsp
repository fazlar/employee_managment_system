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
                                            <form role="search" class="sr-input-func" action="/search-assignproject" method="post">
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
<div class="single-pro-review-area mt-t-30 mg-b-15"
	style="margin-left: 200px;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
				<div class="product-payment-inner-st">
					<ul id="myTabedu1" class="tab-review-design">
						<li class="active"><a href="#description">Schedule
								Information</a></li>
					</ul>
					<div id="myTabContent" class="tab-content custom-product-edit">
						<!--start-->
						<div class="product-tab-list tab-pane fade active in"
							id="description">
							<div class="row">
							 <c:if test='${Boolean.parseBoolean(success)}'>
		                                           <div class="alert alert-success">${message}<a href="/addshedule"><i class="fa fa-trash" style="margin-left: 1062px;"></i></a></div>
	                                               </c:if>
	                                               <c:if test='${Boolean.parseBoolean(error)}'>
		                                           <div class="alert alert-danger">${message}</div>
	                                                           </c:if>
								<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
									<div class="review-content-section">
										<div id="dropzone1" class="pro-ad">
											<form action="/add-schedul" method="post"
												class="dropzone dropzone-custom needsclick add-professors"
												id="demo1-upload">
												<div class="row">
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
														<div class="form-group">

															<select name="employee" class="form-control">
																<option value="none" selected="" disabled="">Select
																	EmployeeName</option>
																<c:forEach items="${employee}" var="emp">
                                                                   <option value="${emp.fullname}">${emp.fullname}</option>
                                                                 </c:forEach>
															</select>
														</div>
														<div class="form-group">
                                                                    <select name="username" class="form-control">
																		<option value="none" selected="" disabled="">Select Employee UserId</option>
																		<c:forEach items="${User}" var="user">
                                                                         <option value="${user.username}">${user.userId}</option>
                                                                       </c:forEach>
																	</select>
                                                                </div>
														<div class="form-group">
															<input name="title" type="text" class="form-control"
																placeholder="Title">
														</div>

														<div class="form-group">
															<input type="date" class="form-control"
																name="date" placeholder="Date">
														</div>


													</div>
													<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
														<div class="form-group">
															<input name="company" type="text" class="form-control"
																placeholder="Companay name">
														</div>
														<div class="form-group res-mg-t-15">
															<textarea name="description" placeholder="Description"></textarea>
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


					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!--content end-->

<jsp:include page="../layout/footer.jsp" />