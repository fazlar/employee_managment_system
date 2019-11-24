<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../layout/header.jsp" />


					
					

<!--content -->
 <div class="contacts-area mg-b-15"style="margin-left: 200px;">
            <div class="container-fluid">
            
                 <div class="row">
                
                <c:forEach var="emp" items="${employee}">
                    <div class="col-lg-3 col-md-6 col-sm-6 col-xs-12">
                        <div class="student-inner-std res-mg-b-30">
                            <div class="student-img">
                                <img src="img/empImage/${emp.empImage}" alt="" />
                            </div>
                            <div class="student-dtl">
                                <h2>${emp.fullname}</h2>
                                <p class="dp" style="color: #0084ff;">${emp.jobtype}</p>
                                <p class="dp-ag"  style="color: #0084ff;"><b>Country:</b> ${emp.country}</p>
                            </div>
                        </div>
                    </div>
                    </c:forEach>
                    </div>
                    
                </div>
            </div>
       

<!--content end-->



<jsp:include page="../layout/footer.jsp" />





