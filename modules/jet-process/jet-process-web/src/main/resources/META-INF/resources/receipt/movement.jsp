<%@ include file="../init.jsp" %>
<liferay-util:include page="/receipt/receipt-view-nav.jsp" servletContext="<%= application %>">
<liferay-util:param name="selectedNav" value="movement" />
<%-- <liferay-util:param name="portletId" value="<%=themeDisplay.getPortletDisplay().getId()%>" /> --%>
</liferay-util:include>

<%-- <%@ include file="receipt-view-nav.jsp"%> --%>

<h1 class="mt-6  text-danger">this is a movement receipt page</h1>
