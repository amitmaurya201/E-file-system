<%@page import="io.jetprocess.web.constants.MVCCommandNames"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:renderURL var="home">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_FILE_LIST_RENDER_COMMAND %>" />					
</portlet:renderURL> 	

<aui:script>
	 window.location.href='<%=home %>'; 
</aui:script>