<%@ include file="../navigation.jsp" %>


<liferay-util:include page="/file/file-view.jsp" servletContext="<%= application %>">
	<liferay-util:param name="selectedNav" value="option1" />
</liferay-util:include>


<div class="m-2 border boredr border-dark">
	

	<h1 class="text-info">This is options page Inside file.</h1>
</div>
