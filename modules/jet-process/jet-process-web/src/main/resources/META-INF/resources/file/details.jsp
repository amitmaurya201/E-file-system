<%@ include file="../navigation.jsp" %>


<liferay-util:include page="/file/file-view.jsp" servletContext="<%= application %>">
	<liferay-util:param name="selectedNav" value="details" />
</liferay-util:include>

<div class="m-2 border boredr border-dark">
	

	<h1 class="text-danger">This is Details page Inside file.</h1>
</div>
