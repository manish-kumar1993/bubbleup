<%@ page language="java" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<%-- <jsp:include page="/common/resources.jsp" /> --%>
<title><fmt:message key="403.title" /></title>
<meta name="heading" content="<fmt:message key='403.title'/>" />
</head>
<body>
	<div class="col-md-12">
		<div class="col-middle">
			<div class="text-center text-center" align="center">
				<h1 class="error-number">Unauthorized Access</h1>
				<h2>Sorry, you are not authorized to view this page.</h2>
				<div class="mid_center">
				</div>
			</div>
		</div>
	</div>
</body>

</body>
</html>