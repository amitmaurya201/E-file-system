<%@page import="java.text.SimpleDateFormat"%>
<%@page import= "java.util.TimeZone"%>
<%@page import="io.jetprocess.masterdata.model.FileMovementDTO"%>
<%@page import="io.jetprocess.masterdata.service.MasterdataLocalServiceUtil"%>
<%@ include file="../init.jsp"%>
<%@ include file="/common/common.jsp"%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/file/inbox.jsp" />
</liferay-portlet:renderURL>
<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
<%
	List<FileMovementDTO> fileInboxList= MasterdataLocalServiceUtil.getFileInboxList(selectedUserPostId != null ? Integer.parseInt(selectedUserPostId) : 1);
	int count = fileInboxList.size();
	
%>


	<div class="col-10">
	<h1 class=" text-center">File Inbox</h1>
 <liferay-ui:search-container total="<%=count %>" delta="4" iteratorURL="<%=iteratorURL%>" >
	<liferay-ui:search-container-results results="<%=fileInboxList %>"/>
	<liferay-ui:search-container-row className="io.jetprocess.masterdata.model.FileMovementDTO" keyProperty="fileMovementId" modelVar="fileinboxDtoList" >
				<%
				char nature=fileinboxDtoList.getNature().charAt(0);
				
				%>				
				<liferay-ui:search-container-column-text name="">
				<%=fileinboxDtoList.getNature().charAt(0) %>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text property="fileNumber" name="File No."/>
				<liferay-ui:search-container-column-text property="subject" name="Subject"/>
				<liferay-ui:search-container-column-text property="sentBy" name="Sent By"/>
				<%
			SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
                simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
		%>
		
				<liferay-ui:search-container-column-text value="<%=simpleformat.format(fileinboxDtoList.getSentOn())%>" name="Send On"/>
					<liferay-ui:search-container-column-text property="dueDate" name="Due On"/>
					<liferay-ui:search-container-column-text property="remark"  name="Remark"/>
					<liferay-ui:search-container-column-text   name="Action" align="center">
						<span><a href="#">readon </a></span>
						<span><a href="">receivedon </a></span>
						<span><a href="#">send </a></span>
					
					</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator markupView="lexicon"/>
</liferay-ui:search-container> 
</div>

</div>



