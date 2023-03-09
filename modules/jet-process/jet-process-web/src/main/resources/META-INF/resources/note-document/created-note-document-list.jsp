<%@ include file="../init.jsp"%>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">

		<h1 class="text-center">Created NoteDocument List</h1>
		<clay:management-toolbar disabled="${noteDocumentCount eq 0}"
			displayContext="${NoteDocumentManagementToolbarDisplayContext}"
			itemsTotal="${noteDocumentCount}" searchContainerId="recieptId" />

		<liferay-ui:search-container delta="${delta }"
			emptyResultsMessage="message-record-not-found" id="recieptId"
			total="${noteDocumentCount}"
			iteratorURL="${NoteDocumentManagementToolbarDisplayContext._getCurrentURL()}">
			<liferay-ui:search-container-results results="${noteDocumentList}" />
<%
DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
%>

			<liferay-ui:search-container-row
				className="io.jetprocess.list.model.NoteDocumentDTO"
				keyProperty="noteDocumentNumber" modelVar="noteDocument" cssClass="colour">

                <portlet:renderURL var="innerViewDetail">
					<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.NOTE_DOCUMENT_INNER_VIEW_RENDER_COMMAND%>" />
					<portlet:param name="CategoryValue" value="<%=noteDocument.getCategoryValue()%>" />
					<portlet:param name="Content" value="<%=noteDocument.getContent()%>" />
					<portlet:param name="CreatedOn" value="<%=dateFormat.format(noteDocument.getCreatedOn())%>" />
					<portlet:param name="NoteDocumentNumber" value="<%=noteDocument.getNoteDocumentNumber()%>" />
					<portlet:param name="Subject" value="<%=noteDocument.getSubject()%>" />
				
				</portlet:renderURL>
				

				<liferay-ui:search-container-column-text cssClass="hyperlink-css"
					value="<%=noteDocument.getNoteDocumentNumber() != null ? noteDocument.getNoteDocumentNumber() : ""%>"
					name="label-receipt-list-receiptno"
					orderableProperty="noteDocumentNumber" href="<%=innerViewDetail %>" orderable="true" />

				<liferay-ui:search-container-column-text cssClass="hover-tips"
					value="<%=noteDocument.getSubject() != null ? noteDocument.getSubject()  : ""%>"
					name="label-receipt-list-subject" orderableProperty="subject"
					orderable="true" />

				
				<liferay-ui:search-container-column-text
					orderable="true" name="label-receipt-list-create-date"
					orderableProperty="createDate" >
						<fmt:formatDate type="both" pattern="dd/MM/yyyy hh:mm aa"
						timeZone="Asia/Calcutta" value="${noteDocument.getCreatedOn()}" />
					</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text
					value="<%=noteDocument.getSubject() != null ? noteDocument.getSubject() : ""%>"
					cssClass="hover-tips remark" name="label-receipt-list-remark" />
				
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="false" />
			<liferay-ui:search-paginator
				markupView="lexicon" searchContainer="<%=new SearchContainer()%>" />
		</liferay-ui:search-container>

	
	
	</div>
</div>
