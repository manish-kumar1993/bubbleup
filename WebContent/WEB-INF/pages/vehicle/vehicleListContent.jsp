<%@ include file="/common/taglibs.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading clearfix">
				<h3 class="panel-title">List of Vehicles</h3>
				&nbsp;&nbsp;&nbsp;&nbsp;  <span> 
				         <c:if test="${requestScope.vehicles.size()>0}">
						(   ${requestScope.totalCount} Services )
							</c:if> 
				</span>
			</div>
			<div class="panel-body" style="padding: 10px; font-size: 10px;">
				<div class="table-responsive">
					<table class="table table-striped table-bordered table-hover">
						<thead>
							<tr>
								<th style="font-weight: bold;">Name</th>
								<th style="font-weight: bold;">Charges</th>
								<th style="font-weight: bold;">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${requestScope.vehicles!=null}">
								<c:forEach var="vehicle" items="${requestScope.vehicles}">
									<tr class="gradeX">
										<td><c:out value="${vehicle.name}" /></td>
										<td><c:out value="${vehicle.charges}" /></td>
										<td><a style="cursor: pointer;" title="Edit" href="${ctx}/editVehicle?dd=${vehicle.id}">
										        <i class="fa fa-pencil-square-o"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										        <a style="cursor: pointer;" title="Edit" href="${ctx}/editVehicle?dd=${vehicle.id}">
										        <i class="fa fa-trash-o"></i></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										        <a style="cursor: pointer;" title="Edit" href="${ctx}/editVehicle?dd=${vehicle.id}">
										        <i class="fa fa-circle"></i></a>
										</td>
									</tr>
								</c:forEach>
						</c:if>
					</tbody>
						<c:if test="${requestScope.vehicles.size()<=0}">
							<tr>
								<td colspan="4">No Services available.</td>
							</tr>
						</c:if>
					</table>
					
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Body Content Ends -->



















