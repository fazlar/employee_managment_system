<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="../../layout/header.jsp" />
<div class="breadcome-area" style="margin-left: 200px;">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                            <div class="breadcome-list">
                                <div class="row">
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <div class="breadcome-heading">
                                            <form role="search" class="sr-input-func">
									<input type="text" placeholder="Search..."
										class="search-int form-control"> <a href="#"><i class="fa fa-search"></i></a>
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
 <div class="single-pro-review-area mt-t-30 mg-b-15" style="margin-left: 237px;">
 <div class="container-fluid">
  <div class="row">
<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
<form action="/pdfbyattendance" method="post">
	<div class="form-group">
	<label>Attendance Report</label>
		<input type="date" class="form-control" name="date"
			placeholder="Enter month Name" style="width: 40%">
	</div>
	<button type="submit" class="btn btn-primary waves-effect waves-light">Submit</button>
	</form>
	</div>
	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
    <form action="/pdfbyyearlysalary" method="post">
      <label>Yearly Report</label>
	 <div class="form-group">
		<input type="text" class="form-control" name="year"
			placeholder="Enter year Name" style="width: 40%">
	</div>
	<button type="submit" class="btn btn-primary waves-effect waves-light">Submit</button>
	</form>
	</div>
	</div>
	</div>
	</div>
	<jsp:include page="../../layout/footer.jsp" />
