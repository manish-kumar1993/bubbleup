<%@ include file="/common/taglibs.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading clearfix">
				<div class="topnav">
					<div class="col-lg-8 marginTop8px">
						<h3 class="panel-title">Worker List 
							<span> 
						         <c:if test="${requestScope.users.size()>0}">
								(   ${requestScope.totalCount} Users )
									</c:if> 
							</span>
						</h3>
					</div>
					<div class="col-lg-4">
						<div class="search-container">
						    <form action="${ctx}/listUser" method="post">
						      <input type="text" placeholder="Search.." name="query" id="query">
						      <button type="submit"><i class="fa fa-search"></i></button>
						    </form>
						</div>
					</div>
				</div>
			</div>
			<div class="panel-body" style="padding: 10px; font-size: 10px;">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th style="font-weight: bold;">Name</th>
								<th style="font-weight: bold;">User Name</th>
								<th style="font-weight: bold;">Mobile</th>
								<th style="font-weight: bold;">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${requestScope.users!=null}">
								<c:forEach var="user" items="${requestScope.users}">
									<tr class="gradeX">
										<td><c:out value="${user.firstName}" /> <c:out value="${user.lastName}" /></td>
										<td><c:out value="${user.username}" /></td>
										<td><c:out value="${user.mobileNo}" /></td>
										<td><a style="cursor: pointer;" title="Edit" href="${ctx}/editUser?userId=${user.userId}">
										        <i class="fa fa-pencil-square-o"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										        <a style="cursor: pointer;" title="Edit" href="${ctx}/editUser?userId=${user.userId}">
										        <i class="fa fa-trash-o"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										        <a style="cursor: pointer;" title="Edit" href="${ctx}/editUser?userId=${user.userId}">
										        <i class="fa fa-circle"></i></a>
										</td>
									</tr>
								</c:forEach>
						</c:if>
					</tbody>
						<c:if test="${requestScope.users.size()<=0}">
							<tr>
								<td colspan="4">No Users available.</td>
							</tr>
						</c:if>
					</table>
					
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Body Content Ends -->



















