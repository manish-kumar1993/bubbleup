<%@ include file="/common/taglibs.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading clearfix">
				<h3 class="panel-title">Add New Company Details</h3>
			</div>
			<div class="panel-body" style="padding: 10px">
				<form method="POST" id="formId" action="saveCompany" onsubmit="return Validate()"autocomplete="off">
				<div class="row">
					<div class="col-md-4 col-sm-4 col-xs-12">
					<input type="hidden" id="id" name="id" value="${requestScope.id}" />
						<label>* Company Name</label> <input type="text" name="name"
							id="name" placeholder="Company Name" class="form-control"
							maxlength="50" value="${requestScope.name}" />
<!-- 							<label id="cnId" class="errormsg">Please enter company Name</label> -->
<!-- 							<label id="cnId1" class="errormsg">Please enter valid company Name</label> -->
						<br>
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>* Address</label> <input type="text" id="address"
							name="address" placeholder="Address"
							class="form-control" value="${requestScope.address}" maxlength="50" />
<!-- 							<label id="ccId" class="errormsg">Please enter Address</label> -->
<!-- 							<label id="ccId1" class="errormsg">Please enter valid address</label> <br> -->
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>* Country</label> <input type="text" id="country"
							name="country" placeholder="Country"
							class="form-control" value="${requestScope.country}" maxlength="50" />
<!-- 							<label id="ccId" class="errormsg">Please enter country</label> -->
<!-- 							<label id="ccId1" class="errormsg">Please enter valid country</label> <br> -->
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>* Village</label> <input type="text" id="village"
							name="village" placeholder="Village"
							class="form-control" value="${requestScope.village}" maxlength="50" />
<!-- 							<label id="ccId" class="errormsg">Please enter village</label> -->
<!-- 							<label id="ccId1" class="errormsg">Please enter valid village</label> <br> -->
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>* Town</label> <input type="text" id="town"
							name="town" placeholder="Town"
							class="form-control" value="${requestScope.town}" maxlength="50" />
<!-- 							<label id="ccId" class="errormsg">Please enter town</label> -->
<!-- 							<label id="ccId1" class="errormsg">Please enter valid town</label> <br> -->
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>* State</label> <input type="text" id="state"
							name="state" placeholder="State"
							class="form-control" value="${requestScope.state}" maxlength="50" />
<!-- 							<label id="ccId" class="errormsg">Please enter state</label> -->
<!-- 							<label id="ccId1" class="errormsg">Please enter valid state</label> <br> -->
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>Service Type</label> <select id="serviceType" name="serviceType"
							class="selectCss form-control">
							<option value="ACTIVE" selected>ACTIVE</option>
							<option value="INACTIVE">INACTIVE</option>
						</select>
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>Payment Status</label><select id="paymentStatus" name="paymentStatus"
							class="selectCss form-control">
							<c:choose>
								<c:when test="${requestScope.payment == 'UNPAID'}">
									<option value="PAID">PAID</option>
									<option value="UNPAID" selected>UNPAID</option>
								</c:when>
								<c:otherwise>
									<option value="PAID" selected>PAID</option>
									<option value="UNPAID">UNPAID</option>
								</c:otherwise>
							</c:choose>
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