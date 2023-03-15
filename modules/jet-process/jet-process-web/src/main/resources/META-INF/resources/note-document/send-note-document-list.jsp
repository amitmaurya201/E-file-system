<%@ include file="../init.jsp"%>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
		</div>

	<div class="col-md-10">
		<h1 class="text-center">noteDocumentMovementDTO Send List</h1>

		<clay:management-toolbar disabled="${noteDocumentCount eq 0}"
			displayContext="${noteDocSentManagementToolbarDisplayContext}"
			itemsTotal="${noteDocumentCount}"
			searchContainerId="noteDocumentMovementDTOId" />

		<liferay-ui:search-container delta="${delta }"
			emptyResultsMessage="message-record-not-found"
			id="noteDocumentMovementDTOId" total="${noteDocumentCount}"
			iteratorURL="${noteDocSentManagementToolbarDisplayContext._getCurrentURL()}">
			<liferay-ui:search-container-results
				results="${noteDocumentList}" />

			<liferay-ui:search-container-row
				className="io.jetprocess.list.model.NoteDocumentMovementDTO"
				keyProperty="noteDocumentNumber" modelVar="noteDocumentMovementDTO" cssClass="colour">


				<liferay-ui:search-container-column-text 
					name="noteDocumentNumber"
					cssClass="hyperlink-css" value="${noteDocumentMovementDTO.noteDocumentNumber }"
					orderableProperty="noteDocumentNumber" orderable="true" />

				<liferay-ui:search-container-column-text cssClass="hover-tips"
					value="${noteDocumentMovementDTO.subject }" name="subject"
					orderableProperty="subject" />

				

				<liferay-ui:search-container-column-text orderable="true"
					name="sentTO"
					orderableProperty="sentTo">
					<fmt:formatDate type="both" pattern="dd/MM/yyyy hh:mm aa"
						timeZone="Asia/Calcutta" value="${noteDocumentMovementDTO.sentOn}" />
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text cssClass="hover-tips"
					value="${noteDocumentMovementDTO.sentTo }" name="sentOn"
					orderableProperty="sentOn" />




			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="false" />
			<liferay-ui:search-paginator
				searchContainer="<%=new SearchContainer()%>" markupView="lexicon" />
		</liferay-ui:search-container>

	</div>
</div>


