<%@ include file="/common/taglibs.jsp"%>
<%-- Success Messages --%>
<c:if test="${not empty messages}">
	<div class="alert alert-success fade in">
		<a href="#" data-dismiss="alert" class="close">&times;</a>
		<c:forEach var="msg" items="${messages}">
			<c:out value="${msg}" />
			<br />
		</c:forEach>
	</div>
	<c:remove var="messages" scope="session" />
</c:if>

<%-- Error Messages (on JSPs, not through Struts --%>
<c:if test="${not empty sessionScope.errorMessages}">
	<div class="alert alert-danger fade in">
		<a href="#" data-dismiss="alert" class="close">&times;</a>
		<c:forEach var="error" items="${sessionScope.errorMessages}">
			<c:out value="${error}" />
			<br />
		</c:forEach>
	</div>
	<c:remove var="errorMessages" scope="session" />
</c:if>