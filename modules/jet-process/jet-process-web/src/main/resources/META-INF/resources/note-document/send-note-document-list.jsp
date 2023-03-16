<%@ include file="../init.jsp"%>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>

	<div class="col-md-10">
		<h1 class="text-center"><liferay-ui:message key="label-notedocument-sent-list-heading"></liferay-ui:message> </h1>

		<clay:management-toolbar disabled="${noteDocumentCount eq 0}"
			displayContext="${noteDocSentManagementToolbarDisplayContext}"
			itemsTotal="${noteDocumentCount}"
			searchContainerId="noteDocumentMovementDTOId" />

		<liferay-ui:search-container delta="${delta }"
			emptyResultsMessage="message-record-not-found"
			id="noteDocumentMovementDTOId" total="${noteDocumentCount}"
			iteratorURL="${noteDocSentManagementToolbarDisplayContext._getCurrentURL()}">
			<liferay-ui:search-container-results results="${noteDocumentList}" />

			<liferay-ui:search-container-row
				className="io.jetprocess.list.model.NoteDocumentMovementDTO"
				keyProperty="noteDocumentNumber" modelVar="noteDocumentMovementDTO"
				cssClass="colour">

				<portlet:renderURL var="noteList">
					<portlet:param name="mvcRenderCommandName"
						value="<%=MVCCommandNames.NOTE_LIST_RENDER_COMMAND%>" />
				</portlet:renderURL>
					<%-- <portlet:param name="noteDocumentId"
						value="<%=""%>" />
					<portlet:param name="movementId"
						value="<%=""%>" /> --%>

				<liferay-ui:search-container-column-text href="<%=noteList %>"
					name="label-notedocument-sent-list-notedocumentnumber" cssClass="hyperlink-css"
					value="${noteDocumentMovementDTO.noteDocumentNumber }"
					orderableProperty="noteDocumentNumber" orderable="true" />

				<liferay-ui:search-container-column-text cssClass="hover-tips"
					value="${noteDocumentMovementDTO.getNoteDocumentId() }" name="note Document Id"
					orderableProperty="noteDocumentId" />


				<liferay-ui:search-container-column-text cssClass="hover-tips"
					value="${noteDocumentMovementDTO.subject }" name="label-notedocument-sent-list-subject"
					orderableProperty="subject" />



				<liferay-ui:search-container-column-text orderable="true"
					name="label-notedocument-sent-list-sentTo" orderableProperty="sentOn">
					<fmt:formatDate type="both" pattern="dd/MM/yyyy hh:mm aa"
						timeZone="Asia/Calcutta" value="${noteDocumentMovementDTO.sentOn}" />
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text cssClass="hover-tips"
					value="${noteDocumentMovementDTO.sentTo }" name="label-notedocument-sent-list-createdon"
					orderableProperty="sentOn" />




			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="false" />
			<liferay-ui:search-paginator
				searchContainer="<%=new SearchContainer()%>" markupView="lexicon" />
		</liferay-ui:search-container>

	</div>
</div>


