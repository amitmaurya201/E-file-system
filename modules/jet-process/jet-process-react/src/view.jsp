<%@ include file="init.jsp" %>

<div id="<portlet:namespace />-root"></div>

<aui:script require="<%= mainRequire %>">
	main.default('<portlet:namespace />-root');
</aui:script>

<script>
	function getP_Id(){
		return <%= themeDisplay.getPortletDisplay().getId() %>;
	}
</script>

