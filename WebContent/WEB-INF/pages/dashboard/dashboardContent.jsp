<%@ include file="/common/taglibs.jsp"%>
<h1 class="page-title">Dashboard</h1>
	<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading clearfix">
				<h3 class="panel-title">Company List</h3>
				<div align="right">
					<a  href="addCompany" title="Add Company" class="btn btn-info">Add Company</a>
				</div>
			</div>
			<div class="panel-body" style="padding: 10px; font-size: 10px;">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th style="font-weight: bold;">Name</th>
								<th style="font-weight: bold;">Country</th>
								<th style="font-weight: bold;">State</th>
								<th style="font-weight: bold;">Town</th>
								<th style="font-weight: bold;">Address</th>
								<th style="font-weight: bold;">Payment</th>
								<th style="font-weight: bold;">Assigned To</th>
								<th style="font-weight: bold;">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${requestScope.companyList!=null}">
								<c:forEach var="company" items="${requestScope.companyList}">
									<tr class="gradeX">
										<td><c:out value="${company.name}" /> </td>
										<td><c:out value="${company.country}" /></td>
										<td><c:out value="${company.state}" /></td>
										<td><c:out value="${company.town}" /></td>
										<td><c:out value="${company.address}" /></td>
										<td><c:out value="${company.paymentStatus}" /></td>
										<td><c:out value="${company.assignedTo}" /></td>
										<td><a style="cursor: pointer;" title="Edit" href="${ctx}/editUser?userId=${company.id}">
										        <i class="fa fa-pencil-square-o"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										        <a style="cursor: pointer;" title="Edit" href="${ctx}/editUser?userId=${company.id}">
										        <i class="fa fa-trash-o"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										        <a style="cursor: pointer;" title="Edit" href="${ctx}/editUser?userId=${company.id}">
										        <i class="fa fa-circle"></i></a>
										</td>
									</tr>
							</c:forEach>
						</c:if>
					</tbody>
						<c:if test="${requestScope.companyList.size()<=0}">
							<tr>
								<td colspan="4">No Company available.</td>
							</tr>
						</c:if>
					</table>
					
				</div>
			</div>
		</div>
	</div>
</div>