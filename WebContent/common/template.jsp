<%@ include file="/common/taglibs.jsp"%>
<!DOCTYPE html>
<head>
<jsp:include page="/common/resources.jsp" />
<title>${param.title} | Bubble Up</title>
</head>
<body>
	<!-- Page container -->
	<div class="page-container">
		<!-- Page sidebar -->
		<div class="page-sidebar">
			<!-- Site header  -->
			<header class="site-header">
				<div class="site-logo">
					<a href="${ctx}/">
							<h1>Bubble Up</h1>
					</a>
				</div>
				<div class="sidebar-collapse hidden-xs">
					<a class="sidebar-collapse-icon" href="#">
						<i class="icon-menu"></i>
					</a>
				</div>
				<div class="sidebar-mobile-menu visible-xs">
					<a data-target="#side-nav" data-toggle="collapse" class="mobile-menu-icon" href="#">
						<i class="icon-menu"></i>
					</a>
				</div>
			</header>
			<!-- /site header -->
			<jsp:include page="/common/menu.jsp" />
		</div>
		<!-- /page sidebar -->
		<!-- Main container -->
		<div class="main-container">
			<jsp:include page="/common/header.jsp" />
			<!-- Main content -->
			<div class="main-content" style="padding: 15px 10px;">
				<jsp:include page="/common/messages.jsp" />
				<jsp:include page="/WEB-INF/pages/${param.content}.jsp" />
				<jsp:include page="/common/footer.jsp" />
			</div>
			<!-- /main content -->
		</div>
		<!-- /main container -->
	</div>
	<!-- /page container -->
	<script src="${ctx}/static/js/functions.js"></script>
	<script>
		$(document).ready(function() {
	      $('.dataTables-example').DataTable({
	         dom : '<"html5buttons" B>lTfgitp',
	         buttons : [ {
	            extend : 'copyHtml5',
	            exportOptions : {
		            columns : [ 0, ':visible' ]
	            }
	         }, {
	            extend : 'excelHtml5',
	            exportOptions : {
		            columns : ':visible'
	            }
	         }, {
	            extend : 'pdfHtml5',
	            exportOptions : {
		            columns : [ 0, 1, 2, 3, 4 ]
	            }
	         }, 'colvis' ]
	      });
	      $('.datepicker').datepicker({
	      	format: 'yyyy-mm-dd',
	      	endDate: new Date(),
	      	autoclose: true
	      });
	      $('.select2-single').select2({
	      	allowClear: true
	      });
	      
	      /*Setting Side bar as active*/
	      $SIDEBAR_MENU = $('#side-nav');
	      var CURRENT_URL = window.location.pathname;
	      $SIDEBAR_MENU.find('a[href="' + CURRENT_URL + '"]').parent('li').addClass('active');
	      if($SIDEBAR_MENU.find('a[href="' + CURRENT_URL + '"]').parent('li').parent().parent('.has-sub')){
	      	$SIDEBAR_MENU.find('a[href="' + CURRENT_URL + '"]').parent('li').parent().addClass('in');
	      	$SIDEBAR_MENU.find('a[href="' + CURRENT_URL + '"]').parent('li').parent().parent('.has-sub').addClass('active');
	      }
	      
	      
      });
      
	</script>
</body>
</html>
