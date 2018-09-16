<%@ include file="/common/taglibs.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading clearfix">
				<h3 class="panel-title">Add New Company Details</h3>
			</div>
			<div class="panel-body" style="padding: 10px">
				<form method="POST" id="formId" action="statusUpdate" onsubmit="return Validate()"autocomplete="off">
				<div class="row">
					<div class="col-md-4 col-sm-4 col-xs-12">
					<input type="hidden" id="id" name="id" value="${requestScope.company.id}" />
						<label> Company Name</label> <input type="text" name="name"
							id="name" placeholder="Company Name" class="form-control"
							maxlength="50" value="${requestScope.company.name}" readonly="readonly"/>
<!-- 							<label id="cnId" class="errormsg">Please enter company Name</label> -->
<!-- 							<label id="cnId1" class="errormsg">Please enter valid company Name</label> -->
						<br>
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>Select User</label> <select id="assignedUsers" name="assignedUsers"
							class="selectCss form-control" multiple="multiple">
							<c:if test="${requestScope.users.size()>0}">
									<c:forEach var="user" items="${requestScope.users}">
										<option value="${user.username}"
											${fn:contains(company.assignedTo,user.username)  ? 'selected="selected"' : ''}><c:out
												value="${user.username}" /></option>
									</c:forEach>
							</c:if>
						</select>
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