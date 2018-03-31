<%@ include file="/common/taglibs.jsp"%>

	
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading clearfix">
				<h3 class="panel-title">Role List</h3>
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
								<th style="font-weight: bold;">Role</th>
								<th style="font-weight: bold;">Status</th>
								<th style="font-weight: bold;">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${requestScope.masterRoleList!=null}">
								<c:forEach var="role" items="${requestScope.masterRoleList}">
									<tr class="gradeX">
										<td><c:out value="${role.masterRoleName}" /></td>
										<td><c:out value="${role.status}" /></td>
										<td>
											<a style="cursor: pointer;" title="View Permission" href="${ctx}/viewPermission?masterRoleId=${role.masterRoleId}&masterRoleName=${role.masterRoleName}" >
											<i class="fa fa-eye aria-hidden="true"></i></a>
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
												<c:if test="${role.status=='INACTIVE'}">
												<a style="cursor: pointer;" title="Activate" href="${ctx}/masterRole?masterRoleId=${role.masterRoleId}&status=ACTIVE" ><i class="fa fa-check" aria-hidden="true"></i></a>
												</c:if>
												<c:if test="${role.status=='ACTIVE'}">
												<a style="cursor: pointer;" title="Deactivate" href="${ctx}/masterRole?masterRoleId=${role.masterRoleId}&status=INACTIVE" ><i class="fa fa-times" aria-hidden="true"></i></a>
												</c:if>
											</td>
									</tr>
						</tbody>
						</c:forEach>
						</c:if>
						<c:if test="${requestScope.masterRoleList.size()<=0}">
							<tr>
								<td colspan="4">No roles available.</td>
							</tr>
						</c:if>
					</table>
					
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Body Content Ends -->

