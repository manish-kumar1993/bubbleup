<%@ include file="/common/taglibs.jsp"%>

	
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading clearfix">
				<h3 class="panel-title">Role Access for <c:out value="${requestScope.masterRoleName }"></c:out></h3>
				&nbsp;&nbsp;&nbsp;&nbsp;  <span> 
				         <c:if test="${requestScope.masterRoleList.size()>0}">
						(   ${requestScope.masterRoleList.size()} Roles )
							</c:if> 
				</span>
			</div>
			<div class="panel-body" style="padding: 10px; font-size: 10px;">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th style="font-weight: bold;">Select Access</th>
								<th style="font-weight: bold;">Role</th>
							</tr>
						</thead>
						 
<tbody>

<form method="GET" id="formId" action="viewPermission" onsubmit="return Validate()"autocomplete="off">
						<input type="hidden" value="${requestScope.masterRoleId}" name="masterRoleId"/>
						<input type="hidden" value="${requestScope.masterRoleName}" name="masterRoleName"/>
						 <input type="hidden" value="SUBMIT" name="page"/>
						<c:forEach var="roleList" items="${requestScope.roleList}"> 
						<c:if test="${roleList.roleDescription!=null && roleList.roleDescription!=''}">
						<c:set var="refreshSent" value="false"/>
							<c:forEach var="roleAccessList" items="${requestScope.roleAccessList}"> 
								<c:if test="${roleList.roleId==roleAccessList.roleId}">
									<c:set var="refreshSent" value="true"/>
								 </c:if>
							</c:forEach>
							<tr>
							<td>
								 <c:if test="${refreshSent eq true}">
								 <input type="checkbox" name="roleIds" value="${roleList.roleId}" checked>
								 </c:if>
								  <c:if test="${refreshSent eq false}">
								 <input type="checkbox" name="roleIds" value="${roleList.roleId}">
								 </c:if>
						   </td>
								 <td>
								 ${roleList.roleDescription}<br>
								 </td>
							</tr>
							</c:if>
						</c:forEach>
				<tbody>
						<div class="row">
					<div align="center">
						<button type="submit" onclick="fieldValidation();" title="Submit"
							class="btn btn-primary">Submit</button>
						<a onClick="JavaScript:window.location='masterRole'" title="Cancel" class="btn btn-info">Cancel</a>
						</div></div>
						</form>
						







					</table>
					
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Body Content Ends -->












<script>
	function goBack() {
		location.href = document.referrer;
	}
</script>
