<%-- <%@ include file="receipt-view-nav.jsp"%> --%>

<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<liferay-util:include page="/receipt/receipt-view-nav.jsp" servletContext="<%= application %>">
<liferay-util:param name="selectedNav" value="putFile" />
</liferay-util:include>

<h1>this is put in a file page</h1>
