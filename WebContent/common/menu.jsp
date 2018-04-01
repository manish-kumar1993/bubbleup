<%@ include file="/common/taglibs.jsp"%>

<!-- Main navigation -->
		<ul id="side-nav" class="main-menu navbar-collapse collapse">
		<sec:authorize access="hasRole('ROLE_REPORT')">
			<li class=""><a href="${ctx}/dashboard"><i class="icon-gauge"></i><span class="title">Dashboard</span></a>	</li>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_USER_ROLE')">
			<li class="has-sub"><a href="#"><i class="fa fa-users"></i><span class="title">Users</span></a>
				<ul class="nav collapse">
					<li class=""><a href="${ctx}/listUser"><i class="fa fa-users"></i><span class="title">User List</span></a></li>
					<li class=""><a href="${ctx}/addUser"><i class="fa fa-user-plus"></i><span class="title">Add User</span></a></li>
				</ul>
			</li>
		</sec:authorize>
		<sec:authorize access="hasRole('ROLE_USER_ROLE')">
			<li class="has-sub"><a href="#"><i class="fa fa-wrench"></i><span class="title">Service</span></a>
				<ul class="nav collapse">
					<li class=""><a href="${ctx}/serviceList"><i class="fa fa-cogs"></i><span class="title">Service List</span></a></li>
					<li class=""><a href="${ctx}/addService"><i class="fa fa-cog"></i><span class="title">Add Service</span></a></li>
				</ul>
			</li>
		</sec:authorize>
		</ul>
<!-- /main navigation -->	
 