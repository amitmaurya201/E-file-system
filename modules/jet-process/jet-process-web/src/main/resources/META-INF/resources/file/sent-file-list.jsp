 <%@page import="io.jetprocess.masterdata.model.FileMovementDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="../init.jsp"%>
<%@ include file="/common/common.jsp"%>
<%@page import= "java.util.TimeZone"%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/file/sent-file-list.jsp" />
</liferay-portlet:renderURL>



<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>

<%
List<FileMovementDTO> sentFileList = MasterdataLocalServiceUtil.getFileSentListByUserPostId(selectedUserPostId != null ? Integer.parseInt(selectedUserPostId) : 1);
int count = sentFileList.size();
%>

<div class="col-10">
		<h1 class=" text-center">SentFileList</h1>
<liferay-ui:search-container iteratorURL="<%=iteratorURL%>" delta = "4" deltaConfigurable="true" total="<%= count %>">
<liferay-ui:search-container-results results="<%= sentFileList%>" />
	<liferay-ui:search-container-row className="io.jetprocess.masterdata.model.FileMovementDTO" modelVar="sentFileListDTO" keyProperty="fileMovementId">
		<liferay-ui:search-container-column-text name="File No." property="fileNumber" orderable="true" />
				<liferay-ui:search-container-column-text property="subject" cssClass="hover-tips" name="Subject" />
				<liferay-ui:search-container-column-text property="sentTo" name="Sent To" />
				<%
					SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
	                simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
				%>
				<liferay-ui:search-container-column-text value="<%=simpleformat.format(sentFileListDTO.getSentOn())%>" orderable="true" name="Sent On" orderableProperty="sentOn" />
				<liferay-ui:search-container-column-text property="sentTo" cssClass="hover-tips" name="Currently With" />
				<liferay-ui:search-container-column-text property="dueDate" cssClass="hover-tips" name="Due On" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>
</div>
</div>