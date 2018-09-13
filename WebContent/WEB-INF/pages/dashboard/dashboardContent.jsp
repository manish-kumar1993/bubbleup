<%@ include file="/common/taglibs.jsp"%>
<h1 class="page-title">Dashboard</h1>
	<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading clearfix row">
				<div class="topnav">
					<div class="col-md-6 col-sm-6 col-xs-12 col-lg-6">
						<h3 class="panel-title marginTop8px">Company List</h3>
					</div>
					<div class="col-md-4 col-sm-4 col-xs-12 col-lg-4">
							<div class="search-container">
							    <form action="${ctx}/dashboard" method="post">
							      <input type="text" placeholder="Search.." name="query" id="query">
							      <button type="submit"><i class="fa fa-search"></i></button>
							    </form>
							</div>
						</div>
					<div class="col-md-2 col-sm-2 col-xs-12 col-lg-2 marginTop8px">
						<div align="right">
							<a  href="addCompany" title="Add Company" class="btn btn-info">Add Company</a>
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
								<th style="font-weight: bold;">Country</th>
								<th style="font-weight: bold;">State</th>
								<th style="font-weight: bold;">Town</th>
								<th style="font-weight: bold;">Village</th>
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
										<td><c:out value="${company.village}" /></td>
										<td><c:out value="${company.address}" /></td>
										<td><c:out value="${company.paymentStatus}" /></td>
										<td><c:out value="${company.assignedTo}" /></td>
										<td><a style="cursor: pointer;" title="Edit" href="${ctx}/editCompany?id=${company.id}">
										        <i class="fa fa-pencil-square-o"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										        <a style="cursor: pointer;" title="Delete" href="${ctx}/deleteCompany?id=${company.id}">
										        <i class="fa fa-trash-o"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										        <c:if test="${company.status=='ACTIVE'}">
											        <a style="cursor: pointer;" title="Active" href="${ctx}/statusUpdate?id=${company.id}&status=INACTIVE">
											        <i class="fa fa-check"></i></a>
										        </c:if>
										        <c:if test="${company.status=='INACTIVE'}">
											        <a style="cursor: pointer;" title="Inactive" href="${ctx}/statusUpdate?id=${company.id}&status=ACTIVE">
											        <i class="fa fa-times"></i></a>
										        </c:if>
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
