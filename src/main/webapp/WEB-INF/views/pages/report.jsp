<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="../layout/header.jsp" />
 <div class="single-pro-review-area mt-t-30 mg-b-15" style="margin-left: 250px;">
<form action="/pdfbyusername" method="post">
	<div class="form-group">
		<input type="text" class="form-control" name="username"
			placeholder="UserName" style="width: 40%">
	</div>
	<button type="submit" class="btn btn-primary waves-effect waves-light">Submit</button>
	</form>
	</div>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>