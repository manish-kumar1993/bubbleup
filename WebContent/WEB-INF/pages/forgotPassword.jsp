<%@ include file="/common/taglibs.jsp"%>
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
	<div class="login-branding">
	</div>
	<div class="login-content">
		<h2>Forgot your password?</h2>
		<p>Don't worry, we'll send you an email to reset your password.</p>
		<form name="formForgotPassword" method="POST" class="form-signin" autocomplete="off"  action="sendForgotPassword' />">
		<c:if test="${param.error != null}">
							<div class="alert alert-danger alert-dismissable">
								<fmt:message key="errors.email.notFound" />
							</div>
		</c:if>
		<c:if test="${param.success != null}">
							<div class="alert alert-success alert-dismissable">
								<fmt:message key="forgotPasswrod.email.success" />
							</div>
		</c:if>
			<div class="form-group">
				<input type="text" placeholder="email" name="email" id="email"  tabindex="1" class="form-control"/>
			</div>                        
			
			<div class="form-group">
				<button class="btn btn-primary btn-block" type="submit"	name="login" tabindex="2" >Send</>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</div>
			  <p class="text-center"><a href="${ctx}/login">Go to login.</a></p>                      
		</form>
	</div>
	
</div> 
</body>
</html>

 
