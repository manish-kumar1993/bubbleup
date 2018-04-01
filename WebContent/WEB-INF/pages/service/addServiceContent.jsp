<%@ include file="/common/taglibs.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading clearfix">
				<h3 class="panel-title">Add New Service Details</h3>
			</div>
			<div class="panel-body" style="padding: 10px">
				<form method="POST" id="formId" action="saveServices" onsubmit="return Validate()"autocomplete="off">
				<div class="row">
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>* Service Type</label> <input type="text" id="address"
							name="service" placeholder="Service Type"
							class="form-control" value="${requestScope.serviceType}" maxlength="50" />
<!-- 							<label id="ccId" class="errormsg">Please enter Address</label> -->
<!-- 							<label id="ccId1" class="errormsg">Please enter valid address</label> <br> -->
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12">
						<label>* Description</label> <input type="text" id="description"
							name="description" placeholder="Description"
							class="form-control" value="${requestScope.description}" maxlength="50" />
<!-- 							<label id="ccId" class="errormsg">Please enter country</label> -->
<!-- 							<label id="ccId1" class="errormsg">Please enter valid country</label> <br> -->
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