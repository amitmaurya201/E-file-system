<%@ include file="../init.jsp"%>

<div class="row">
	<div class="col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">

		<liferay-util:include page="/file/file-view-nav.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="convert" />
		</liferay-util:include>
		<%-- <%@ include file="file-view.jsp" %> --%>

		<div class="m-2 border boredr border-dark">
			<h1 class="text-warning">This is convert page Inside file.</h1>
		</div>

	</div>
</div>

