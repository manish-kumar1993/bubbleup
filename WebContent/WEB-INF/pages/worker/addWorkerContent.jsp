<%@ include file="/common/taglibs.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading clearfix">
				<h3 class="panel-title">Add New Worker Details</h3>
			</div>
			<div class="panel-body" style="padding: 10px">
				<form method="POST" id="formId" action="saveWorkers" onsubmit="return Validate()"autocomplete="off">
				<div class="row">
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>*Name</label> <input type="text" name="firstName"
							id="fname" placeholder="Name" class="form-control"
							maxlength="50" value="${requestScope.firstName}" />
<!-- 							<label id="fnId" class="errormsg">Please enter Name</label> -->
<!-- 							<label id="fnId1" class="errormsg">Please enter valid Name</label> -->
<!-- 						<br> -->
					</div>
					<input type="email" style="display: none;" id="email-breaker" />
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>* Username</label> <input type="email" name="username"
							id='uname' placeholder="Username" class="form-control"
							maxlength="50" pattern="^[a-zA-Z0-9@-_'.]+$" autocomplete="Off"
							value='<c:out value="${requestScope.username}" />' />
<!-- 							<label id="uId" class="errormsg">Please enter Username</label> -->
<!-- 							<label id="uId1" class="errormsg">Please enter valid Username</label> -->

					</div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>* Password</label> <input type="password"
							placeholder="Password" class="form-control" name="password"
							id="password" maxlength="50">
<!-- 							<label id="passId" class="errormsg">Please enter Password</label> -->
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>* Confirm Password</label> <input type="password"
							placeholder="Confirm Password" class="form-control"
							name="conPassword" id="conPassword" maxlength="50">
<!-- 							<label id="cpassId" class="errormsg">Please enter Confirm Password</label> -->
					</div>
				<input type="password" style="display: none;" id="password-breaker" />
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>Mobile Number</label> <input type="text"
							placeholder="Mobile Number" class="form-control" name="mobileNo"
							id="mobileNo" maxlength="15" value='<c:out value="${requestScope.mobileNo}" />' >
<!-- 							<label id="mnId" class="errormsg">Please enter valid Mobile Number</label> -->
					</div>
				</div>
				<br />
				<div class="row">
					<div align="center">
						<button type="submit"  title="Save" class="btn btn-primary">Save</button>
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
	}
	function goBack() {
		location.href = document.referrer;
	}
</script>