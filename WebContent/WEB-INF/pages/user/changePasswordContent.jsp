<%@ include file="/common/taglibs.jsp"%>
<html>
<head>
<jsp:include page="/common/resources.jsp" />
<style>
body {
	background-color: transparent;
}

#login-pageCss {
	background-position: center center;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}

#login {
	background-color: #fff;
	padding: 20px;
	border-radius: 5px;
}

.loginPage-logo {
	margin-top: 30px;
}

.loginPage-logo img {
	width: 300px;
	height: 100px;
}

.form {
	margin-top: 10px;
}

.login-footer {
	background-color: #fff;
	width: 100%;
	position: absolute;
	bottom: 0;
}

#wrapper {
	margin-top: 10% !important;
}
.messageCss {
background-color: #fff;
padding: 10px 10px 10px 10px;
margin-top: 10px;
border-radius: 5px;
}
.messageCss p {
font-size: 20px
}
</style>
</head>
<script type="text/javascript">
$(document).ready(function() {
	var status='${status}';
	if(status =='error'){
		$("#messageId").css('color', 'red');
	}else{
		$("#messageId").css('color', 'green');
	}
});
</script>
<div class="container-fluid">
<c:if test="${not empty messages}">
<div align="center"  class="col-xs-12 messageCss" style="height:40px; padding-right:10px">
	
		<c:forEach var="msg" items="${messages}">
			<p id="messageId" >
				<c:out value="${msg}" />
			</p>

			<br/>
		</c:forEach>
		<c:remove var="messages" scope="session" />
	
</div>
</c:if>
</div>
<body id="login-pageCss">
	<div class="container">
		<div id="wrapper">
			<div id="login" class="form">
				<form action="changePassword" id="submitForm" name="changeForm"
					method="POST">
					<h3 align="center">Change Your Password</h3>
					<br>
					<h2 align="center">Enter New Password</h2>
					<input type="hidden" id="uname" name="username" value="${username}">
					<div>
						<input type="password" name="password" id="password"
							class="form-control" placeholder="Password">
					</div>
					<br>
					<div>
						<input type="password" name="conPassword" id="conPassword"
							class="form-control" placeholder="Confirm Password">
					</div>
					<br>
					<div align="center">
						<button type="button" class="btn btn-primary" name="Send"
							tabindex="4" onclick="validation();">Confirm</button>
						<button type="button" class="btn btn-info" onclick="goBack();"
							name="Cancel" tabindex="4">Cancel</button>
					</div>
					<div class="clearfix"></div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
				</form>
			</div>
		</div>
	</div>
	<div class="container login-footer">
		<div class="col-xs-12 col-sm-12 col-md-12">
			<div class="text-center" style="margin-left: -230px;">
				<jsp:include page="/common/footer.jsp" />
			</div>
		</div>
	</div>
</body>

</html>
<script>
	function goBack() {
		window.history.back();
	}
</script>
<script>
	function validation() {
		var username=$('#uname').val();
		var password = document.getElementById("password").value;
		var confirmPassword = document.getElementById("conPassword").value;
		var regularExpression=/^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
		if(password==null || password=="" || confirmPassword==null || confirmPassword==""){
			alert("Password fields are mandatory")
			return false;
		}if (password == username) {
			alert("Username can't be use as Password");
			return false;
		}
		if (password != confirmPassword) {
			alert("Password/Confirm Password should be same");
			return false;
		}else if(!regularExpression.test(password)){
			alert("Minimum 8 characters at least 1 Alphabet, 1 Number and 1 Special Character:");
			return false;
		}
		else {
			$('#submitForm').submit();
		}
	}
</script>
