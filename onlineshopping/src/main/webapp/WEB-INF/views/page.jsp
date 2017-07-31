
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - ${title}</title>

<!-- Bootstrap Core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- bootstrap theme CSS -->
<link href="${css}/bootstrap-redable-theme.css" rel="stylesheet">




</head>

<body>

	<div class="wrapper">
		<script type="text/javascript">
			window.menu = '${title}';
		</script>

		<!-- Navigator comes here -->

		<%@ include file="./shared/navigator.jsp"%>

		<!-- Page Content -->
		<div class="content">

			<!-- Home page come here -->

			<!-- Display home only if user has clicked on home page -->
			<c:if test="${userClickedHome==true}">
				<%@ include file="home.jsp"%>
			</c:if>

			<!-- Display about only if user has clicked on about page -->
			<c:if test="${userClickedAbout==true}">
				<%@ include file="about.jsp"%>
			</c:if>

			<!-- Display contact only if user has clicked on contact page -->
			<c:if test="${userClickedContact==true}">
				<%@ include file="contact.jsp"%>
			</c:if>
		</div>
		<!-- Footer comes here -->
		<%@ include file="./shared/footer.jsp"%>
		<!-- /.container -->

		<!-- jQuery -->
		<script src="${js}/jquery.js"></script>

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>


		<!-- My App  JavaScript -->
		<script src="${js}/myapp.js"></script>

	</div>
</body>

</html>
