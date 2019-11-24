<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	
<jsp:include page="../layout/header.jsp" />

<!--content -->
		      <div class="single-pro-review-area mt-t-30 mg-b-15" style="margin-left: 200px;">
               <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        <div class="product-payment-inner-st">
                            <ul id="myTabedu1" class="tab-review-design">
                                <li class="active"><a href="#description">Pay Salary</a></li>
                               
                                
                            </ul>
                            <div id="myTabContent" class="tab-content custom-product-edit">
							     <!--start-->
                                <div class="product-tab-list tab-pane fade active in" id="description">
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
                                                    <form action="/savesalary" class="dropzone dropzone-custom needsclick add-professors" id="demo1-upload" method="post">
                                                        <div class="row">
														
                                                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
															
															<div class="form-group">
                                                                    <select name="empName" class="form-control">
																		<option value="none" selected="" disabled="">Select Employee Name</option>
																		<c:forEach items="${employee}" var="emp">
                                                                       <option value="${emp.fullname}">${emp.fullname}</option>
                                                                          </c:forEach>
																		
																	</select>
                                                                </div>
                                                                <div class="form-group">
                                                                    <select name="username" class="form-control">
																		<option value="none" selected="" disabled="">Select Employee uId</option>
																		<c:forEach items="${User}" var="user">
                                                                         <option value="${user.username}">${user.userId}</option>
                                                                       </c:forEach>
																	</select>
                                                                </div>
																<div class="form-group">
                                                                    <select name="month" class="form-control">
																		<option value="none" selected="" disabled="">Select Month</option>
																		<option value="January">January</option>
																		<option value="February">February</option>
																		<option value="Mearch">Mearch</option>
																		<option value="April">April</option>
																		<option value="May">May</option>
																		<option value="Jun">Jun</option>
																		<option value="July">July</option>
																		<option value="Augest">Augest</option>
																		<option value="September">September</option>
																		
																	</select>
                                                                </div>
																<div class="form-group">
                                                                    <select name="year" class="form-control">
																		<option value="none" selected="" disabled="">Select Year</option>
																		<option value="2014">2014</option>
																		<option value="2015">2015</option>
																		<option value="2016">2016</option>
																		<option value="2017">2017</option>
																		<option value="2018">2018</option>
																		<option value="2019">2019</option>
																		
																		
																	</select>
                                                                </div>
                                                                    
															<div class="form-group">
                                                                    <input name="amount" type="number" class="form-control" placeholder="Amount">
                                                                </div>
                                                                
                                                                
																<div class="payment-adress">
                                                                    <button type="submit" class="btn btn-primary waves-effect waves-light">Submit</button>
                                                                </div>
                                                                
                                                            </div>
                                                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
														
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-lg-12">
                                                                <
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div><!--end-->
                               
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
		
		<!--content end-->
        

<jsp:include page="../layout/footer.jsp" />