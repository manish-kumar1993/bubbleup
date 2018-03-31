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
	padding: 5px 10px 0px 10px;
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
		var status = '${status}';
		if (status == 'error') {
			$("#messageId").css('color', 'red');
		} else {
			$("#messageId").css('color', 'green');
		}
	});
</script>
<div class="container-fluid">
<c:if test="${not empty messages}">
	<div align="center" class="col-xs-12 messageCss" style="height: 40px;">

		<c:forEach var="msg" items="${messages}">
			<p id="messageId">
				<c:out value="${msg}" />
			</p>

			<br />
		</c:forEach>
		<c:remove var="messages" scope="session" />
	</div>
</c:if>
</div>
<body id="login-pageCss">
	<div class="container">
		<div id="wrapper">
			<div id="login" class="form">
				<form action="validateEmail" onsubmit="return validation();"
					name="frmLogin" method="POST">
					<h2 align="center">Forgotten your password ?</h2>
					<h2 align="center">Please enter your email address below and submit and we will be in touch with further instructions</h2>
					<br>
					<h2 align="center">Enter Email Address</h2>
					<div>
						<input type="text" name="emailAddress" id="userName"
							class="form-control" placeholder="Email Address" required
							tabindex="1" autocomplete="off" >
					</div>
					<br>
					<div align="center">
						<button type="submit" class="btn btn-primary" name="Send"
							tabindex="4">Send</button>
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
		var email = $('#userName').val();
		var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		if(!re.test(email)){
			alert("Please Enter an Email");
			return re.test(email);
		}
	}
</script>
