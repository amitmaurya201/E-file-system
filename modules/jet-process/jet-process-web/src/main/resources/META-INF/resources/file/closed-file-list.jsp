<%@ include file="../init.jsp"%>

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
			displayContext="${closedReceiptManagementToolbarDisplayContext}"
			selectable="false" />

		<liferay-ui:search-container id="closedFileEntries"
			emptyResultsMessage="message-record-not-found"
			total="${closedFileCount}" delta="${delta }"
			iteratorURL="${closedReceiptManagementToolbarDisplayContext._getCurrentURL() }">
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
					name="label-file-closed-receiptNumber" orderable="true"
					orderableProperty="fileNumber" cssClass="hyperlink-css">
					<a onclick="receiptDetailPopup(${closedFileDTO.fileId})"
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

			</liferay-ui:search-container-row>

			<%-- Iterator / Paging --%>
			<liferay-ui:search-iterator paginate="false" />
			<liferay-ui:search-paginator
				searchContainer="<%=new SearchContainer()%>" markupView="lexicon" />


		</liferay-ui:search-container>
	</div>
	</div>