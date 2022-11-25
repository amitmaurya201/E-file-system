<%@ include file="../init.jsp"%>
<%@ page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@ page
	import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>
<%-- <%	
ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
String setURl = serviceContext.getPortalURL();
		String pdfUrl = renderRequest.getParameter("pdfUrl");
		String url = setURl+pdfUrl;
		out.print("test"+url);
  
      
		/*String userPostId = renderRequest.getParameter("userPostId");*/
	%> --%>
	
	<%
		String pdfUrl = renderRequest.getParameter("pdfUrl");
		
	%>

<div>
	<%-- <iframe src="<%=url%>" width="800" height="500"> </iframe> --%>
	 <embed id="pdfurl" src="<%=pdfUrl%>" type="application/pdf" width="100%" height="500"  /> 
</div>

