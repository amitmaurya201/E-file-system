<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../init.jsp" %>

<div class="row">

	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>

	<div class="col-10 border border-dark">
		<liferay-util:include page="/file/file-view-nav.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="putinfile" />
		</liferay-util:include>
		<div class="container">
			<div class="row ">	
				<c:set var="type" scope="session" value="${nature}"/>  
				<c:if test="${type=='Electronic'}">
				<div class="col-4">
				<%@include file="/file/add-note.jsp" %>
				</div>
				<div class="col-8">
				<%@include file="/file/correspondence-list.jsp" %>
				</div>
				</c:if>
				<c:if test="${type=='Physical'}">
				<div class="row ">
				<div class="col-12">
				<%@include file="/file/correspondence-list.jsp" %>
				</div>
			</div>
				</c:if>
				
		</div>
	</div>
</div>