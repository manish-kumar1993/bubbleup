<%@ include file="/common/taglibs.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading clearfix">
				<h3 class="panel-title">Add New User</h3>
			</div>
			<div class="panel-body" style="padding: 10px">
				<form method="POST" id="formId" action="saveUser" onsubmit="return Validate()"autocomplete="off">
				<div class="row">
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>* Select Role</label>
						<div class="col-md-12" style="padding: 0px;">
							<select id="role_id" name="roleId" onchange="selectedRole(this);"
								class="form-control">
								<c:if test="${requestScope.roleList.size()>0}">
									<c:forEach var="role" items="${requestScope.roleList}">
										<option value="${role.roleId}"
											${fn:contains(roleId,role.roleId)  ? 'selected="selected"' : ''}><c:out
												value="${role.roleName}" /></option>
									</c:forEach>
								</c:if>
							</select>
						</div>
						<label id="rId" class="errormsg">Please select role</label>
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>* First Name</label> <input type="text" name="firstName"
							id="fname" placeholder="First Name" class="form-control"
							maxlength="50" value="${requestScope.firstName}" /><label
							id="fnId" class="errormsg">Please enter First Name</label><label
							id="fnId1" class="errormsg">Please enter valid First Name</label>
						<br>
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>* Last Name</label> <input type="text" id="lname"
							pattern="^[a-zA-Z ]+$" name="lastName" placeholder="Last Name"
							class="form-control" value="${requestScope.lastName}"
							maxlength="50" /><label id="lnId" class="errormsg">Please
							enter Last Name</label><label id="lnId1" class="errormsg">Please
							enter valid Last Name</label> <br>
					</div>
				</div>
				<div class="row">
					<input type="email" style="display: none;" id="email-breaker" />
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>* Username</label> <input type="email" name="username"
							id='uname' placeholder="Username" class="form-control"
							maxlength="50" pattern="^[a-zA-Z0-9@-_'.]+$" autocomplete="Off"
							value='<c:out value="${requestScope.username}" />' /><label
							id="uId" class="errormsg">Please enter Username</label><label
							id="uId1" class="errormsg">Please enter valid Username</label> <br>
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>* Password</label> <input type="password"
							placeholder="Password" class="form-control" name="password"
							id="password" maxlength="50"><label id="passId"
							class="errormsg">Please enter Password</label>
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>* Confirm Password</label> <input type="password"
							placeholder="Confirm Password" class="form-control"
							name="conPassword" id="conPassword" maxlength="50"><label
							id="cpassId" class="errormsg">Please enter Confirm
							Password</label>
					</div>
				</div>
				<input type="password" style="display: none;" id="password-breaker" />
				<div class="row">
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>Mobile Number</label> <input type="text"
							placeholder="Mobile Number" class="form-control" name="mobileNo"
							id="mobileNo" maxlength="15"><label id="mnId"
							class="errormsg">Please enter valid Mobile Number</label>
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>Select Status</label><select id="status" name="status"
							class="selectCss form-control">
							<c:choose>
								<c:when test="${requestScope.status == 'INACTIVE'}">
									<option value="ACTIVE">ACTIVE</option>
									<option value="INACTIVE" selected>INACTIVE</option>
								</c:when>
								<c:otherwise>
									<option value="ACTIVE" selected>ACTIVE</option>
									<option value="INACTIVE">INACTIVE</option>
								</c:otherwise>
							</c:choose>
						</select>
					</div>
				</div>
				<br />
				<div class="row">
					<div class="col-xs-12">
						<c:choose>
							<c:when test="${enabled == 1}">
								<div class="row">
									<div class="col-md-6 col-sm-6 col-xs-6">
										<input type="checkbox" name="enabled" value="1" checked /> <label>
											Enable</label> <input type="hidden" name="enabled" value="0" />
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="row">
									<div class="col-md-6 col-sm-6 col-xs-6">
										<input type="checkbox" name="enabled" value="1" /> <label>Enable</label>
										<input type="hidden" name="enabled" value="0" />
									</div>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>

				<div class="row">
					<div align="center">
						<button type="button" onclick="fieldValidation();" title="Add"
							class="btn btn-primary">Add</button>
						<a onclick="goBack();" title="Cancel" class="btn btn-info">Cancel</a>
					</div>
				</div>
			</form>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	function Validate() {
		var username = $('#uname').val();
		var regularExpression = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$/;
		var password = document.getElementById("password").value;
		var confirmPassword = document.getElementById("conPassword").value;
		if (password == username) {
			alert("Username can't be use as Password");
			return false;
		}
		if (password != confirmPassword) {
			alert("Password/Confirm Password should be same");
			return false;
		} else if (!regularExpression.test(password)) {
			alert("Password should have minimum 8 characters at least 1 Alphabet, 1 Number and 1 Special Character:");
			return false;
		} else {
			return true;
		}
	}
</script>
<script>
	$(document).ready(function() {
		$('#rId').hide();
		$('#tId').hide();
		$('#fnId').hide();
		$('#lnId').hide();
		$('#uId').hide();
		$('#mnId').hide();
		$('#passId').hide();
		$('#cpassId').hide();
		$('#fnId1').hide();
		$('#lnId1').hide();
		$('#uId1').hide();
	});
</script>
<script>
	function fieldValidation() {
		$('#rId').hide();
		$('#tId').hide();
		$('#fnId').hide();
		$('#lnId').hide();
		$('#uId').hide();
		$('#mnId').hide();
		$('#passId').hide();
		$('#cpassId').hide();
		$('#fnId1').hide();
		$('#lnId1').hide();
		$('#uId1').hide();

		var emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
		var regex = /^[0-9]+([,.][0-9]+)?$/g;

		if ($('#role_id').val() == null && $('#fname').val() == ""
				&& $('#lname').val() == "" && $('#uname').val() == ""
				&& $('#password').val() == "" && $('#conPassword').val() == "") {
			$('#rId').show();
			$('#fnId').show();
			$('#lnId').show();
			$('#uId').show();
			$('#passId').show();
			$('#cpassId').show();
		} else if ($('#role_id').val() == null || $('#role_id').val() == "") {
			$('#rId').show();
		} else if ($('#fname').val() == "") {
			$('#fnId').show();
		} else if (!/^[a-zA-Z ]+$/i.test($('#fname').val())) {
			$('#fnId1').show();
		} else if ($('#lname').val() == "") {
			$('#lnId').show();
		} else if (!/^[a-zA-Z ]+$/i.test($('#lname').val())) {
			$('#lnId1').show();
		} else if ($('#uname').val() == "") {
			$('#uId').show();
		} else if (!(emailRegex.test($('#uname').val()))) {
			$('#uId1').show();
		} else if ($('#password').val() == ""
				|| $('#password').val().trim() == "") {
			$('#passId').show();
		} else if ($('#conPassword').val() == ""
				|| $('#conPassword').val().trim() == "") {
			$('#cpassId').show();
		} else if ($('#mobileNo').val() != ""
				&& (!(/^[0-9]+$/i.test($('#mobileNo').val())) || $('#mobileNo')
						.val().length < 7)) {
			$('#mnId').show();
		} else {
			var trueValue = Validate();
			if (trueValue) {
				document.getElementById('formId').submit();
			}
		}
	}
</script>

<script>
	function goBack() {
		location.href = document.referrer;
	}
</script>
