<%@ include file="../init.jsp"%>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>

	<div class="col-10">
		<liferay-util:include
			page="/note-document/note-document-navigation.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="send" />
		</liferay-util:include>
		<div class="text-center">
			<h1>Note List</h1>
		</div>
		<aui:container cssClass="border">
			<p>cgvgv</p>

		</aui:container>
	</div>
</div>


