<%@ include file="../init.jsp"%>

<portlet:renderURL var="fileClosedDetailsURL"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	 <portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.FILE_CLOSE_DETAILS_RENDER_COMMAND%>" /> 
</portlet:renderURL>

<portlet:renderURL var="reopenFilePopup"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.REOPEN_FILE_POPUP_RENDER_COMMAND %>"/>
</portlet:renderURL>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
		<h1 class=" text-center">
			<liferay-ui:message key="label-file-closed-heading" />
		</h1>
		<clay:management-toolbar searchContainerId="closedFileEntries"
			disabled="${closedFileCount eq 0 }"
			itemsTotal="${closedFileCount}"
			displayContext="${closedFileManagementToolbarDisplayContext}"
			selectable="false" />

		<liferay-ui:search-container id="closedFileEntries"
			emptyResultsMessage="message-record-not-found"
			total="${closedFileCount}" delta="${delta }"
			iteratorURL="${closedFileManagementToolbarDisplayContext._getCurrentURL() }">
			<liferay-ui:search-container-results results="${closedFileList}" />

			<liferay-ui:search-container-row
				className="io.jetprocess.list.model.ClosedFileDTO"
				modelVar="closedFileDTO" keyProperty="closedFileId">

				<c:set var="firstLetterOfNature" value="${closedFileDTO.nature}" />
				<c:set var="nature"
					value="${fn:substring(firstLetterOfNature, 0, 1)}" />
				<liferay-ui:search-container-column-text
					name="label-file-closed-type">
					<span title="${closedFileDTO.nature }">${nature} </span>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text
					name="label-file-closed-fileNumber" orderable="true"
					orderableProperty="fileNumber" cssClass="hyperlink-css">
					<a onclick="fileDetailPopup(${closedFileDTO.fileId})"
						style="cursor: pointer">${closedFileDTO.fileNumber }</a>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text
					value="${closedFileDTO.subject }"
					name="label-file-closed-subject" cssClass="hover-tips" />
				<liferay-ui:search-container-column-text
					name="label-file-closed-closedOn" orderable="true"
					orderableProperty="closedOn">
					<fmt:formatDate type="both" pattern="dd/MM/yyyy hh:mm aa"
						timeZone="Asia/Calcutta" value="${closedFileDTO.closedOn}" />
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text
					name="label-file-closed-closingRemarks" cssClass="hover-tips"
					property="closingRemarks" />
				<liferay-ui:search-container-column-text 
					name="label-file-closed-action">
					<c:if test="${ currentUserSectionId == closedFileDTO.dealingHeadSectionId}">
						<img   alt="reopen-file" title="reopen"  onClick="reopenFilePopUp(<%=closedFileDTO.getFileId() %> , <%=closedFileDTO.getClosedFileId() %>)"
							id='<portlet:namespace/>reopen-file' 
							src='<%=request.getContextPath() + "/image/reopen-image.png"%>' width="35%" height="25" />
					</c:if>
				</liferay-ui:search-container-column-text> 
			</liferay-ui:search-container-row>
			<%-- Iterator / Paging --%>
			<liferay-ui:search-iterator paginate="false" />
			<liferay-ui:search-paginator
				searchContainer="<%=new SearchContainer()%>" markupView="lexicon" />
		</liferay-ui:search-container>
	</div>
</div>
	
<aui:script>
	function fileDetailPopup(fileId){
		var title="<liferay-ui:message key='title-closed-fileDetailPopup' />";
		Liferay.Util.openWindow({ 
			dialog: { 														 
				height: 550,														 
				destroyOnClose: true,														 
				destroyOnHide: true, 														 
				modal: true, 														 
				width: 1200,
																 
			}, 														 
			id: '<portlet:namespace />dialog',														 
			title: title, 														 
			uri: '<%=fileClosedDetailsURL%>&<portlet:namespace />fileId='+fileId,			
		});	  
	}
	
	function reopenFilePopUp(fileId,closedFileId){
		var title="<liferay-ui:message key='title-reopen-file-popup'/>";
		Liferay.Util.openWindow({
			dialog: {
				centered: true,
				height: 345,
				destroyOnClose: true,														 
				destroyOnHide: true, 
				modal: true,
				width: 500
			},
			id: '<portlet:namespace/>dialog',
			title: title,
			uri: '<%=reopenFilePopup%>&<portlet:namespace/>fileId='+fileId+'&<portlet:namespace/>closedFileId='+closedFileId
			
		});
	}
</aui:script>	
	
	