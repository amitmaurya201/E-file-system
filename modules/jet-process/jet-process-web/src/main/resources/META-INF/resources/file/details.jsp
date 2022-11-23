<%@ include file="../navigation.jsp" %>


<liferay-util:include page="/file/file-view-nav.jsp" servletContext="<%= application %>">
	<liferay-util:param name="selectedNav" value="details" />
</liferay-util:include>

<div class="m-2 border boredr border-dark">
	<span><i class="fa-solid fa-book"></i></span>
	<div>
		<label>File No. :</label><aui:input name="fileno" value""></aui:input>
	
	</div>
	
	
	
</div>
