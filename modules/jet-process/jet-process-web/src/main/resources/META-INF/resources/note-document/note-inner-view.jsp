<%@ include file="../init.jsp"%>
 
<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
	<liferay-util:include page="/note-document/note-document-navigation.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="navhome" />
		</liferay-util:include>
		Note Inner View
	 </div>
	 
</div>