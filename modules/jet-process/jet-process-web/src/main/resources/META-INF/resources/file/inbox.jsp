<%@page import="java.text.SimpleDateFormat"%>
<%@page import="io.jetprocess.model.DocFile"%>
<%@page import="java.util.TimeZone"%>
<%@page import="io.jetprocess.masterdata.model.FileMovementDTO"%>
<%@page
	import="io.jetprocess.masterdata.service.MasterdataLocalServiceUtil"%>
<%@ include file="../init.jsp"%>
<%@ include file="/common/common.jsp"%>

<style>
.table thead th {
	border-right: 1px solid white;
}
</style>


<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/file/inbox.jsp" />
</liferay-portlet:renderURL>
<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<%-- <portlet:renderURL var="sendFile"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>">
			<portlet:param name="mvcPath" value="/file/send.jsp" />
			<portlet:param name="docFile" value="801" />
		</portlet:renderURL> --%>

	<%
		List<FileMovementDTO> fileInboxList = MasterdataLocalServiceUtil
				.getFileInboxList(selectedUserPostId != null ? Integer.parseInt(selectedUserPostId) : 1);
		int count = fileInboxList.size();
	%>


	<div class="col-10">
		<h1 class=" text-center">File Inbox</h1>
		<liferay-ui:search-container total="<%=count%>" delta="1"
			iteratorURL="<%=iteratorURL%>">
			<liferay-ui:search-container-results results="<%=fileInboxList %>" />
			<liferay-ui:search-container-row
				className="io.jetprocess.masterdata.model.FileMovementDTO"
				keyProperty="fileMovementId" modelVar="fileinboxDtoList">

				<liferay-ui:search-container-column-text name="">
					<%=fileinboxDtoList.getNature().charAt(0)%>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text property="fileNumber"
					name="File No." />
				<liferay-ui:search-container-column-text property="subject"
					name="Subject" />
				<%-- <%
				String a=fileinboxDtoList.getSentBy();				
				String[] s=a.split(",");					
					
					
				%> --%>
				<liferay-ui:search-container-column-text name="Sent By"
					cssClass="hover-tips">
					<aui:button id="sentBy" value="<%=fileinboxDtoList.getSentBy()%>"></aui:button>>
				</liferay-ui:search-container-column-text>

				<%
					SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
							simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
				%>

				<liferay-ui:search-container-column-text
					value="<%=simpleformat.format(fileinboxDtoList.getSentOn())%>"
					name="Send On" />
				<liferay-ui:search-container-column-text property="dueDate"
					name="Due On" />
				<liferay-ui:search-container-column-text property="remark"
					name="Remark" />
				<liferay-ui:search-container-column-text name="Action"
					align="center">
					<span><a href="#">read</a></span>&nbsp;
						<span><a href="#">received</a></span>&nbsp;
						<span><a href="#">send</a></span>

				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator markupView="lexicon" />
		</liferay-ui:search-container>



	</div>

</div>
<div id="my-content-div">
	<div>
		DIVContent Is Rendered In The AUI Modal Popup.
		<%=fileInboxList.getClass().getName() %>
	</div>
</div>


 
<!-- AUI Script For Modal Dialog POPUP -->
<aui:script use="aui-modal,aui-overlay-manager">
A.one("#<portlet:namespace />sentBy").on('click',function(event){
	var dialog = new A.Modal({
		title: "AUI Modal Popup Title",
		bodyContent: A.one("#my-content-div").html(),
		headerContent: 'Sender Details',
		centered: true,
		modal: true,
		height: 200,
		width:600,
		render: '#my-content-div',
		close: true
	});
	dialog.render();
});
</aui:script>
