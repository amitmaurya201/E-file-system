<%@ include file="../init.jsp"%>
<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">

		<h1 class="text-center">Inbox NoteDocument List</h1>
		<clay:management-toolbar disabled="${noteDocumentInboxCount eq 0}"
			displayContext="${NoteDocumentInboxManagementToolbarDisplayContext}"
			itemsTotal="${noteDocumentInboxCount}" searchContainerId="noteDocumentId" />

		<liferay-ui:search-container delta="${delta }"
			emptyResultsMessage="message-record-not-found" id="noteDocumentId"
			total="${noteDocumentInboxCount}"
			iteratorURL="${NoteDocumentInboxManagementToolbarDisplayContext._getCurrentURL()}">
			<liferay-ui:search-container-results results="${noteDocumentInboxList}" />
			<%
				DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			%>

			<liferay-ui:search-container-row
				className="io.jetprocess.list.model.NoteDocumentMovementDTO"
				keyProperty="noteDocumentNumber" modelVar="noteDocument"
				cssClass="colour">



			 <portlet:renderURL var="inboxInnerViewDetail">
					<portlet:param name="mvcRenderCommandName"
						value="<%=MVCCommandNames.NOTE_DOCUMENT_INBOX_INNER_VIEW_RENDER_COMMAND%>" />
					<%-- <portlet:param name="noteId"
						value="<%=String.valueOf(noteDocument.getNoteId())%>" />
					<portlet:param name="noteDocumentId"
						value="<%=String.valueOf(noteDocument.getNoteDocumentId())%>" />
					<portlet:param name="subjectCategoryValue"
						value="<%=noteDocument.getCategoryValue()%>" /> --%>
				</portlet:renderURL> 


				<liferay-ui:search-container-column-text href="<%=inboxInnerViewDetail %>"
					value="<%=noteDocument.getNoteDocumentNumber() != null ? noteDocument.getNoteDocumentNumber() : ""%>"
					name="label-notedocument-inbox-list-notedocumentnumber" cssClass="hyperlink-css" orderableProperty="noteDocumentNumber" orderable="true" />

				<liferay-ui:search-container-column-text cssClass="hover-tips"
					value="<%=noteDocument.getSubject() != null ? noteDocument.getSubject() : ""%>"
					name="label-notedocument-inbox-list-subject" orderableProperty="subject" />

				<liferay-ui:search-container-column-text cssClass="hover-tips"
					name="label-notedocument-inbox-list-sentby"
					value="<%=noteDocument.getSentBy() != null ? noteDocument.getSentBy() : ""%>" />

                 
               
				<liferay-ui:search-container-column-text orderable="true"
					name="label-notedocument-inbox-list-senton"
					orderableProperty="createDate">
					<fmt:formatDate type="both" pattern="dd/MM/yyyy hh:mm aa"
						timeZone="Asia/Calcutta" value="${noteDocument.getSentOn()}" />
				</liferay-ui:search-container-column-text>

          
					<liferay-ui:search-container-column-text
						name="label-notedocument-inbox-ramarks" cssClass="hover-tips bold" value="<%=noteDocument.getRemarks() != null ? noteDocument.getRemarks() : ""%>" />
					
			 	<liferay-ui:search-container-column-text
					name="label-notedocument-inbox-createdlist-actions" align="center">
					<a href="#">Send</a>
				</liferay-ui:search-container-column-text>
 
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="false" />
			<liferay-ui:search-paginator
				searchContainer="<%=new SearchContainer()%>" markupView="lexicon" />
		</liferay-ui:search-container>



	</div>
</div>
