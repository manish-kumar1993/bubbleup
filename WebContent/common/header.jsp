<%@ include file="/common/taglibs.jsp"%>
<!-- Main header -->
	<div class="main-header row">
		  <div class="col-sm-6 col-xs-7">
		  
			<!-- User info -->
			<ul class="user-info pull-left">          
			  <li class="profile-info dropdown"><a data-toggle="dropdown" class="dropdown-toggle" href="#" aria-expanded="false"> <img width="44" class="img-circle avatar" alt="" src="${ctx}/static/images/man.jpg"><input type="hidden" value='<c:out value="${requestScope.username}" />'><span class="caret"></span></a>
			  
				<!-- User action menu -->
				<ul class="dropdown-menu">
				  
				  <li><a href="${ctx}/logout"><i class="icon-logout"></i>Logout</a></li>
				</ul>
				<!-- /user action menu -->
				
			  </li>
			</ul>
			<!-- /user info -->
		  </div>
    </div>
	 <!-- /main header -->
	 
 