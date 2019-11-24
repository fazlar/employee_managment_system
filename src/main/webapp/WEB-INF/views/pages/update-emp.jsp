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
                                <li class="active"><a href="#description">Basic Information</a></li>
                                <li><a href="#reviews"> Account Information</a></li>
                                
                            </ul>
                            <div id="myTabContent" class="tab-content custom-product-edit">
							     <!--start-->
                                <div class="product-tab-list tab-pane fade active in" id="description">
                                    <div class="row">
                                           <c:if test='${Boolean.parseBoolean(success)}'>
		                                           <div class="alert alert-success">${message}<a href="/addemp"><i class="fa fa-trash" style="margin-left: 1062px;"></i></a></div>
	                                               </c:if>
	                                               <c:if test='${Boolean.parseBoolean(error)}'>
		                                           <div class="alert alert-danger">${message}</div>
	                                                           </c:if>
                                                
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="review-content-section">
                                                <div id="dropzone1" class="pro-ad">
                                                  
                                                
                                                    <form action="/addemployee" class="dropzone dropzone-custom needsclick add-professors" id="demo1-upload" method="post">
                                                        <div class="row">
                                                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
															    <div class="form-group">
                                                                    <select name="JobType" class="form-control">
																		<option value="${employeeEntity.jobType}" selected="" disabled="">${employeeEntity.jobType}</option>
																		     
																	</select>
                                                                </div>
                                                                <div class="form-group">
                                                                    <input name="firstname" type="text" class="form-control" placeholder="Full Name" value="${employeeEntity.fullname}">
                                                                </div>
                                                                <div class="form-group">
                                                                    <input name="address" type="text" class="form-control" placeholder="Address" value="${employeeEntity.fullname}">
                                                                </div>
                                                                <div class="form-group">
                                                                    <input name="mobileno" type="number" class="form-control" placeholder="Mobile no."  value="${employeeEntity.mobileno}">
                                                                </div>
                                                                <div class="form-group">
                                                                    <input name="text" id="finish" type="date" class="form-control" placeholder="Date of Birth" value="${employeeEntity.mobileno}">
                                                                </div>
                                                                <div class="form-group">
                                                                    <input name="postcode" id="postcode" type="text" class="form-control" placeholder="Postcode" value="${employeeEntity.postCode}">
                                                                </div>
                                                                <div class="form-group alert-up-pd">
                                                                    <div class="dz-message needsclick download-custom">
                                                                        <i class="fa fa-download edudropnone" aria-hidden="true"></i>
                                                                        <h2 class="edudropnone">Drop image here or click to upload.</h2>
                                                                        <p class="edudropnone"><span class="note needsclick">(This is just a demo dropzone. Selected image is <strong>not</strong> actually uploaded.)</span>
                                                                        </p>
                                                                        <input name="imageico" class="hd-pro-img" type="text" />
                                                                    </div>
                                                                </div>
                                                            </div>
                                                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                                                <div class="form-group">
                                                                    <select name="department" class="form-control">
																		
																		
                                                                              <option value="${employeeEntity.department}" selected="" disabled="">${employeeEntity.department}</option>
                                                                             
																	</select>
                                                                </div>
                                                                <div class="form-group res-mg-t-15">
                                                                    <textarea name="description" placeholder="Description">${employeeEntity.description}</textarea>
                                                                </div>
                                                                <div class="form-group">
                                                                    <select name="gender" class="form-control">
																		<option value="${employeeEntity.gender}" selected="" disabled="">${employeeEntity.gender}</option>
																		
																	</select>
                                                                </div>
                                                                <div class="form-group">
                                                                    <select name="country" class="form-control">
																			<option value="${employeeEntity.country}" selected="" disabled="">${employeeEntity.country}</option>
																			
																		</select>
                                                                </div>
                                                                <div class="form-group">
                                                                    <select name="state" class="form-control">
																			<option value="${employeeEntity.state}" selected="" >${employeeEntity.state}</option>
																			<option value="Gujarat">Gujarat</option>
																			<option value="Maharastra">Maharastra</option>
																			<option value="Rajastan">Rajastan</option>
																			<option value="Maharastra">Maharastra</option>
																			<option value="Rajastan">Rajastan</option>
																			<option value="Gujarat">Gujarat</option>
																		</select>
                                                                </div>
                                                                <div class="form-group">
                                                                    <select name="city" class="form-control">
																			<option value="${employeeEntity.city}" selected="" disabled="">${employeeEntity.city}</option>
																			<option value="Dhaka">Dhaka</option>
																			<option value="Islamabadh">Islamabadh</option>
																			<option value="Navsari">Navsari</option>
																			<option value="Baroda">Baroda</option>
																			<option value="Surat">Surat</option>
																		</select>
                                                                </div>
                                                               
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-lg-12">
                                                                <div class="payment-adress">
                                                                    <button type="submit" class="btn btn-primary waves-effect waves-light">Submit</button>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div><!--end-->
                                <div class="product-tab-list tab-pane fade" id="reviews">
                                    <div class="row">
                                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                            <div class="review-content-section">
                                                <div class="row">
                                                    <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
                                                        <form id="acount-infor" action="/api/user/save" class="acount-infor"  method="post">
                                                            <div class="devit-card-custom">
                                                                <div class="form-group">
                                                                    <input type="text" class="form-control" name="username" placeholder="UserName">
                                                                </div>
                                                                <div class="form-group">
                                                                    <input type="text" class="form-control" name="email" placeholder="Email">
                                                                </div>
                                                                <div class="form-group">
                                                                    <input name="role" type="text" class="form-control" placeholder="Role">
                                                                </div>
                                                                <div class="form-group">
                                                                    <input name="password" type="password" class="form-control" placeholder="Password">
                                                                </div>
                                                                
                                                                <button type="submit" class="btn btn-primary waves-effect waves-light">Submit</button>
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

