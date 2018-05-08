<%@ include file="/common/taglibs.jsp"%>
<c:if test="${pageContext.request.userPrincipal.name != null}">
		<c:redirect url="/dashboard" />	
</c:if>
<jsp:include page="/common/resources.jsp" />
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>BubbleUp | Login</title>
</head>
<body class="login-page">
	<div class="login-container">
		<div class="login-content">
			<h2>
				<strong>Welcome</strong>, please login
			</h2>
			<form name="frmLogin" method="POST" class="form-signin" autocomplete="off" action="<c:url value='/j_spring_security_check' />">
				<c:if test="${param.error != null}">
					<div class="alert alert-danger alert-dismissable">
						<fmt:message key="errors.password.mismatch" />
					</div>
				</c:if>
				<c:if test="${param.logout != null}">
					<div class="alert alert-success alert-dismissable">
						<fmt:message key="logout.success.message" />
					</div>
				</c:if>
				<div class="form-group">
					<input type="text" placeholder="Username" name="username" id="userName" class="form-control" autofocus="autofocus" tabindex="1" />
				</div>
				<div class="form-group">
					<input type="password" placeholder="Password" name="password" id="password" tabindex="2" class="form-control" />
				</div>
				<div class="form-group">
					<button class="btn btn-primary btn-block" type="submit" name="login" tabindex="3">
						Login</> <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</div>
				<p class="text-center">
					<a href="forgotPassword">Forgot your password? Click Here.</a>
				</p>
			</form>
		</div>
	</div>
</body>
</html>
