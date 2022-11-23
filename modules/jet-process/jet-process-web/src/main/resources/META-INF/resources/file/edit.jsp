<%@ include file="../navigation.jsp" %>


<liferay-util:include page="/file/file-view-nav.jsp" servletContext="<%= application %>">
	<liferay-util:param name="selectedNav" value="edit" />
</liferay-util:include>

<div class="m-2 border boredr border-dark">
	

	<h1 class="text-primarry">This is edit page Inside file.</h1>
</div>
