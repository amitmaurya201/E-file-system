<%@ include file="../init.jsp" %>
<%@ include file="../navigation.jsp" %>



<liferay-util:include page="/file/file-view-nav.jsp" servletContext="<%= application %>">
	<liferay-util:param name="selectedNav" value="sendback" />
</liferay-util:include>
<%-- <%@ include file="file-view.jsp" %> --%>

<div class="m-2 border boredr border-dark">
	<h1 class="text-warning">This is senback page Inside file.</h1>
</div>

