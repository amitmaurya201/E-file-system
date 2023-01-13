<%@ include file="../init.jsp"%>
<%
	String pdfUrl = renderRequest.getParameter("pdfUrl");
%>
<div>
	<embed id="pdfurl" src="<%=pdfUrl%>" type="application/pdf"
		width="100%" height="500" />
</div>