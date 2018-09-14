<%@ include file="/common/taglibs.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading clearfix">
				<h3 class="panel-title">Set Password for-- <c:out value="${requestScope.user.username}"></c:out></h3>
			</div>
			<div class="panel-body" style="padding: 10px">
			
			<form action="savePassword" method="POST" role="changePassword" id="changePassword" class="form-horizontal">
						<input type="hidden" name="userId" value='<c:out value="${requestScope.user.userId}" />'> 
						<div class="row">
							<div class="col-md-4 col-sm-6 col-xs-12">
								<label>* Password</label> 
								<input type="password" class="form-control" name="password" placeholder="Password" 	id="password"  maxlength="50">
							</div>
							<div class="col-md-4 col-sm-6 col-xs-12">
								<label>* Confirm Password</label> 
								<input type="password"  class="form-control" placeholder="Confirm Password" name="conPassword" id="conPassword"  maxlength="50">
							</div>
						</div>
						<br />

						<div class="row">
							<div align="center">
								<button type="button" id="setPassword" title="SetPassword"
									class="btn btn-primary btnCSS">Set password</button>
								<a onclick="goBack();" title="Cancel"
									class="btn btn-info btnCSS">Cancel</a>
							</div>
						</div>
					</form>
					</div>
					</div>
					
					
					
					<div class="panel panel-default">
			<div class="panel-heading clearfix">
				<h3 class="panel-title">Edit User -- <c:out value="${requestScope.user.username}"></c:out></h3>
			</div>
			<div class="panel-body" style="padding: 10px">
					
			
					<form action="saveUser" method="POST" role="form" id="formId"
						class="form-horizontal">
						<input type="hidden" name="userId" value='<c:out value="${requestScope.user.userId}" />'> 
						<input type="hidden" name="saltedPass" id="passId" value='<c:out value="${requestScope.user.password}" />'> 
						<input type="hidden" name="check" value="editUser" />
						<div id="selectedRoleId">
							<input type="hidden" id="selectedId" value="${requestScope.user.masterRoleId}" />
						</div>
						<div class="row">
							<div class="col-md-4 col-sm-4 col-xs-12">
						<label>* Select Role</label>
						<div class="col-md-12" style="padding: 0px;">
							<select id="role_id" name="roleId" onchange="selectedRole(this);"
								class="form-control">
								<c:if test="${requestScope.roleList.size()>0}">
									<c:forEach var="roleList" items="${requestScope.roleList}">
										<option value="${roleList.roleId}"
											${fn:contains(roleId,roleList.roleId)  ? 'selected="selected"' : ''}><c:out
												value="${roleList.roleName}" /></option>
									</c:forEach>
								</c:if>
							</select>
							<button class="downArrowBtn btn form-control-feedback">
								<i class="downArrow form-control-feedback fa fa-chevron-down"></i>
							</button>
						</div>
						<label id="rId" class="errormsg">Please select role</label>
					</div>
							<div class="col-md-4 col-sm-6 col-xs-12">
								<label>* First Name</label> <input type="text" name="firstName"
									id="fname" placeholder="First Name" class="form-control"
									value="${requestScope.user.firstName}" maxlength="50"><label
									id="fnId" class="errormsg">Please enter First Name</label><label
									id="fnId1" class="errormsg">Please enter valid First
									Name</label> <br>
							</div>
							<div class="col-md-4 col-sm-6 col-xs-12">
								<label>* Last Name</label> <input type="text" name="lastName"
									id="lname" placeholder="Last Name" class="form-control"
									value="${requestScope.user.lastName}" maxlength="50"><label
									id="lnId" class="errormsg">Please enter Last Name</label><label
									id="lnId1" class="errormsg">Please enter valid Last
									Name</label> <br>
							</div>
						</div>
						 
						<div class="row">
							<div class="col-md-4 col-sm-6 col-xs-12">
								<label>Mobile Number</label> <input type="text"
									class="form-control" placeholder="Mobile Number"
									name="mobileNo" id="mobileNo" value="${requestScope.user.mobile}"
									maxlength="15"><label id="mnId" class="errormsg">Please
									enter valid Mobile Number</label>
							</div>
							<div class="col-md-4 col-sm-6 col-xs-12">
								<label>Select Status</label><select id="status" name="status"
									class="selectCss form-control">
									<c:choose>
										<c:when test="${requestScope.user.status == 'ACTIVE'}">
											<option value="ACTIVE" selected>ACTIVE</option>
											<option value="INACTIVE">INACTIVE</option>
										</c:when>
										<c:otherwise>
											<option value="ACTIVE">ACTIVE</option>
											<option value="INACTIVE" selected>INACTIVE</option>
										</c:otherwise>
									</c:choose>
								</select>
							</div>
						</div>
						<br />

						<c:choose>
							<c:when test="${user.enabled == 1}">
								<div class="row">
									<div class="col-md-3 col-sm-3 col-xs-3">
										<input type="checkbox" name="enabled" value="1" checked /> <label>Enable</label>
										<input type="hidden" name="enabled" value="0" />
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="row">
									<div class="col-md-3 col-sm-3 col-xs-3">
										<input type="checkbox" name="enabled" value="1" /> <label>Enable</label>
										<input type="hidden" name="enabled" value="0" />
									</div>
								</div>
							</c:otherwise>
						</c:choose>

						<div class="row">
							<div align="center">
								<button type="button" id="updateButton" title="Update"
									class="btn btn-primary btnCSS">Update</button>
								<a onclick="goBack();" title="Cancel"
									class="btn btn-info btnCSS">Cancel</a>
							</div>
						</div>
					</form>
			</div>
		</div>
	</div>
</div>





 

<script>
	function Validate() {
		var username = $('#uname').val();
		var saltedPass = $('#passId').val();
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
		}
		if (saltedPass != password && saltedPass != confirmPassword) {
			if (!regularExpression.test(password)) {
				alert("Password should have minimum 8 characters at least 1 Alphabet, 1 Number and 1 Special Character:");
				return false;
			} else {
				return true;
			}
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
		} else if (('${role_userId}' == $('#selectedId').val() || '${role_userId}' == $('#role_id').val())) {
			$('#tId').show();
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
		} else if (($('#region').val() == null || $('#region').val() == "")) {
			$('#tId').show();
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


<script>
	var form_modified = false;
	$(document).on('change', 'select', function() {
		form_modified = true;
	});
	$("form :input").change(function() {
		$(this).closest('form').data('changed', true);
	});
	$('#updateButton').click(function() {
		if (form_modified) {
			fieldValidation();
		} else {
			if ($(this).closest('form').data('changed')) {
				fieldValidation();
			} else {
				alert("Nothing is edited to save");
				return false;
			}
		}
	});
</script>