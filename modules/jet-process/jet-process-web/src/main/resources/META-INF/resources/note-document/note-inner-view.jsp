<%@ include file="../init.jsp"%>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	
	<liferay-util:include page="/note-document/note-document-navigation.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="home" />
		</liferay-util:include>
</div>
