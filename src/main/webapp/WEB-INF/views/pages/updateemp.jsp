<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>	
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
                                                  
                                                
                                                    <form action="/addemployee" class="dropzone dropzone-custom needsclick add-professors" id="demo1-upload" method="post" enctype="multipart/form-data">
                                                        <div class="row">
                                                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
															    <div class="form-group">
                                                                    <select name="JobType" class="form-control">
																		<option value="${employeeEntity.jobtype}" selected="" disabled="">${employeeEntity.jobtype}</option>
																	</select>
                                                                </div>
                                                                <div class="form-group">
                                                                    <input name="firstname" type="text" class="form-control" placeholder="Full Name" value="${employeeEntity.fullname}">
                                                                </div>
                                                                <div class="form-group">
                                                                    <input name="email" type="email" class="form-control" placeholder="Email" value="${employeeEntity.fullname}">
                                                                </div>
                                                                <div class="form-group">
                                                                    <input name="mobileno" type="number" class="form-control" placeholder="Mobile no." value="${employeeEntity.mobileno}">
                                                                </div>
                                                                <div class="form-group">
                                                                    <input name="text" id="finish" type="date" class="form-control" placeholder="Date of Birth" value="${employeeEntity.dateofbirth}">
                                                                </div>
                                                                <div class="form-group">
                                                                    <input name="postcode" id="postcode" type="text" class="form-control" placeholder="Postcode" value="${employeeEntity.postCode}">
                                                                </div>
                                                                <div class="form-group alert-up-pd">
                                                                <label class="control-label" for="email">choose
																image</label>
                                                                    <input type="file" id="myFile" name="filename">
                                                                </div>
                                                            </div>
                                                            <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12" class="form-control">
                                                                <div class="form-group">
                                                                    <select name="department" class="form-control">
																		<option value="${employeeEntity.department}" selected="" disabled="">${employeeEntity.department}</option>
																	</select>
                                                                </div>
                                                                <div class="form-group res-mg-t-15">
                                                                     <textarea name="description" placeholder="Description"></textarea>
                                                                </div>
                                                                <div class="form-group">
                                                                    <select name="gender" class="form-control">
																		<option value="${employeeEntity.gender}" selected="" disabled="">${employeeEntity.gender}</option>
																		<option value="Male">Male</option>
																		<option value="Female">Female</option>
																	</select>
                                                                </div>
                                                                <div class="form-group">
                                                                    <select name="country" class="form-control">
																			<option value="${employeeEntity.country}" selected="" disabled="">${employeeEntity.country}</option>
																			<option value="Bangladesh">Bangladesh</option>
																			<option value="Pakistan">Pakistan</option>
																			<option value="Pakistan">Amerika</option>
																			<option value="Pakistan">China</option>
																			<option value="Pakistan">Dubai</option>
																			<option value="Pakistan">Nepal</option>
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
                                                                <div class="form-group">
                                                                    <input name="salary" type="number" class="form-control" placeholder="Salary" value="${employeeEntity.salary}">
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="row">
                                                            <div class="col-lg-12">
                                                                <div class="payment-adress">
                                                                    <button type="submit" class="btn btn-primary waves-effect waves-light">update</button>
                                                                </div>
                                                                <!-- testing -->
                                                                <!-- <form>
                                                                <div class="form-group alert-up-pd">
                                                                <label class="control-label" for="email">choose
																image</label>
                                                                <input type="file" id="myFile" name="filename">
                                                                <button type="submit" >Submit</button>
                                                                </div>
                                                                </form> -->
                                                             
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
                                                        <form id="acount-infor" action="/register" class="acount-infor"  method="post">
                                                            <div class="devit-card-custom">
                                                                 <div class="form-group">
                                                                    <input type="text" class="form-control" name="fullname" placeholder="UserName" value="${empname}" >
                                                                </div>
                                                                <div class="form-group">
                                                                    <input type="text" class="form-control" name="username" placeholder="UserName">
                                                                </div>
                                                                <div class="form-group">
                                                                    <input type="text" class="form-control" name="email" placeholder="Email" value="${email}">
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

