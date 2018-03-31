<%@ include file="/common/taglibs.jsp"%>
<%
if (request.getSession(false) != null) {
    session.invalidate();
}
%>
<c:redirect url="/login?logout=true"/>