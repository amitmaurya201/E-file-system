<%@ include file="../init.jsp" %>
<%@ include file="../navigation.jsp" %>



<liferay-util:include page="/file/file-view.jsp" servletContext="<%= application %>">
	<liferay-util:param name="selectedNav" value="movement" />
</liferay-util:include>
<%-- <%@ include file="file-view.jsp" %> --%>

<div class="m-2 border boredr border-dark">
	<h1 class="text-warning">This is Movement page Inside file.</h1>
</div>

