<%@ include file="/common/taglibs.jsp" %>
<!-- Pass the content page name (pages should be available under WEB-INF/pages folder.) and the title value in the parameters. -->
<jsp:include page="/common/template.jsp">
	<jsp:param name="content" value="/service/addServiceContent"/>
	<jsp:param name="title" value="Add Services"/>
</jsp:include>
