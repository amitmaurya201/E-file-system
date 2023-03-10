<%@ include file="../init.jsp"%>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">

		<h1 class="text-center">Created NoteDocument List</h1>
		<clay:management-toolbar disabled="${noteDocumentCount eq 0}"
			displayContext="${NoteDocumentManagementToolbarDisplayContext}"
			itemsTotal="${noteDocumentCount}" searchContainerId="noteDocumentId" />

		<liferay-ui:search-container delta="${delta }"
			emptyResultsMessage="message-record-not-found" id="noteDocumentId"
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
			

				<liferay-ui:search-container-column-text  href="<%=innerViewDetail%>"
					value="<%=noteDocument.getNoteDocumentNumber() != null ? noteDocument.getNoteDocumentNumber() : ""%>"
					name="label-notedocument-list-notedocumentnumber" cssClass="hyperlink-css" 
					orderableProperty="noteDocumentNumber" orderable="true" />

				<liferay-ui:search-container-column-text cssClass="hover-tips"
					value="<%=noteDocument.getSubject() != null ? noteDocument.getSubject()  : ""%>"
					name="label-notedocument-list-subject" orderableProperty="subject"/>

				<liferay-ui:search-container-column-text cssClass="hover-tips" 
				name="label-notedocument-list-subjectcategory"
					value="<%=noteDocument.getCategoryValue() != null ? noteDocument.getCategoryValue() : ""%>" />
				
				
				<liferay-ui:search-container-column-text
					orderable="true" name="label-notedocument-list-createdon"
					orderableProperty="createDate" >
						<fmt:formatDate type="both" pattern="dd/MM/yyyy hh:mm aa"
						timeZone="Asia/Calcutta" value="${noteDocument.getCreatedOn()}" />
					</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text
								name="label-notedocument-createdlist-actions" align="center" >
								<a class="noteDocumentSend" id="sendnoteDocument" name="sendnoteDocument">Send</a>
							</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="false" />
				<liferay-ui:search-paginator
				searchContainer="<%=new SearchContainer()%>" markupView="lexicon" />
		</liferay-ui:search-container>

	
	
	</div>
</div>
