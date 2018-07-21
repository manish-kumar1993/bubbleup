<%@ include file="/common/taglibs.jsp"%>
<h1 class="page-title">Dashboard</h1>
	<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading clearfix">
				<h3 class="panel-title">Customer List</h3>
				<!-- <div align="right">
					<a  href="addCompany" title="Add Company" class="btn btn-info">Add Company</a>
				</div> -->
			</div>
			<div class="panel-body" style="padding: 10px; font-size: 10px;">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th style="font-weight: bold;">Name</th>
								<th style="font-weight: bold;">Address</th>
								<th style="font-weight: bold;">Request Date</th>
								<th style="font-weight: bold;">Vehicle Number</th>
								<th style="font-weight: bold;">Vehicle Name</th>
								<th style="font-weight: bold;">Repair Type</th>
								<th style="font-weight: bold;">Service Type</th>
								<th style="font-weight: bold;">Assigned to Worker</th>
								<th style="font-weight: bold;">Payment</th>
								<th style="font-weight: bold;">Action</th>
							</tr>
						</thead>
						<tbody>
							<%-- <c:if test="${requestScope.companyList!=null}">
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
						</c:if> --%>
							<tr class="gradeX">
								<td><c:out value="Manish" /> </td>
								<td><c:out value="Banglore" /></td>
								<td><c:out value="21-07-2018" /></td>
								<td><c:out value="9898" /></td>
								<td><c:out value="Honda" /></td>
								<td><c:out value="Engine" /></td>
								<td><c:out value="Washing" /></td>
								<td><c:out value="Shami" /></td>
								<td><c:out value="Paid" /></td>
								<td><a style="cursor: pointer;" title="Download bill" href="${ctx}/downloadBill?id=">
								        <i class="fa fa-download"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								        <a style="cursor: pointer;" title="More" href="${ctx}/moreDetails?id=">
								        <i class="fa fa-ellipsis-h"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</tr>
							<tr class="gradeX">
								<td><c:out value="Manish" /> </td>
								<td><c:out value="Banglore" /></td>
								<td><c:out value="21-07-2018" /></td>
								<td><c:out value="9898" /></td>
								<td><c:out value="Honda" /></td>
								<td><c:out value="Engine" /></td>
								<td><c:out value="Washing" /></td>
								<td><c:out value="Shami" /></td>
								<td><c:out value="Paid" /></td>
								<td><a style="cursor: pointer;" title="Download bill" href="${ctx}/downloadBill?id=">
								        <i class="fa fa-download"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								        <a style="cursor: pointer;" title="More" href="${ctx}/moreDetails?id=">
								        <i class="fa fa-ellipsis-h"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</tr>
							<tr class="gradeX">
								<td><c:out value="Manish" /> </td>
								<td><c:out value="Banglore" /></td>
								<td><c:out value="21-07-2018" /></td>
								<td><c:out value="9898" /></td>
								<td><c:out value="Honda" /></td>
								<td><c:out value="Engine" /></td>
								<td><c:out value="Washing" /></td>
								<td><c:out value="Shami" /></td>
								<td><c:out value="Paid" /></td>
								<td><a style="cursor: pointer;" title="Download bill" href="${ctx}/downloadBill?id=">
								        <i class="fa fa-download"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								        <a style="cursor: pointer;" title="More" href="${ctx}/moreDetails?id=">
								        <i class="fa fa-ellipsis-h"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</tr>
							<tr class="gradeX">
								<td><c:out value="Manish" /> </td>
								<td><c:out value="Banglore" /></td>
								<td><c:out value="21-07-2018" /></td>
								<td><c:out value="9898" /></td>
								<td><c:out value="Honda" /></td>
								<td><c:out value="Engine" /></td>
								<td><c:out value="Washing" /></td>
								<td><c:out value="Shami" /></td>
								<td><c:out value="Paid" /></td>
								<td><a style="cursor: pointer;" title="Download bill" href="${ctx}/downloadBill?id=">
								        <i class="fa fa-download"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								        <a style="cursor: pointer;" title="More" href="${ctx}/moreDetails?id=">
								        <i class="fa fa-ellipsis-h"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</tr>
							<tr class="gradeX">
								<td><c:out value="Manish" /> </td>
								<td><c:out value="Banglore" /></td>
								<td><c:out value="21-07-2018" /></td>
								<td><c:out value="9898" /></td>
								<td><c:out value="Honda" /></td>
								<td><c:out value="Engine" /></td>
								<td><c:out value="Washing" /></td>
								<td><c:out value="Shami" /></td>
								<td><c:out value="Paid" /></td>
								<td><a style="cursor: pointer;" title="Download bill" href="${ctx}/downloadBill?id=">
								        <i class="fa fa-download"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								        <a style="cursor: pointer;" title="More" href="${ctx}/moreDetails?id=">
								        <i class="fa fa-ellipsis-h"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</tr>
							
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
