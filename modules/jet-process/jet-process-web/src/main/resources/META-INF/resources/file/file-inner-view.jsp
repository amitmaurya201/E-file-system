<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../init.jsp"%>
<%@page import="io.jetprocess.model.DocFile"%>
<%
	DocFile docFile = (DocFile) request.getAttribute("docFileObj");

  String currURL = (String)request.getAttribute("CurrentURL");
  
  session.setAttribute("currentURL", currURL);

%>

<%=currURL %>


<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
		<liferay-util:include page="/file/file-view-nav.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="putinfile" />
		</liferay-util:include>
		<div class="container-fluid m-1" style="background-color: #E8E8E8;">
			<span><%=docFile.getNature().charAt(0)%> | <%=docFile.getFileNumber()%>
				| <%=docFile.getSubject()%></span><br />

		</div>
		<div class="container row">

			<c:set var="type" scope="session" value="${nature}" />
			<c:if test="${type=='Electronic'}">
				<div class="col-4">
					<%@include file="/file/add-note.jsp"%>
				</div>
				<div class="col-8">
					<%@include file="/file/correspondence-list.jsp"%>
				</div>
			</c:if>
			<c:if test="${type=='Physical'}">

				<div class="col-12">
					<%@include file="/file/correspondence-list.jsp"%>
				</div>

			</c:if>


		</div>
	</div>
</div>