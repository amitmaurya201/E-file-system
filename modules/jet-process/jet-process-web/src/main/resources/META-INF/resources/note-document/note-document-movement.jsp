<%@ include file="../init.jsp"%>
 
 <% 
 long noteDocumentId = (long)renderRequest.getAttribute("noteDocumentId");
 %>
 
 
 <style>
.lfr-search-container-wrapper a:not (.component-action ):not (.btn ) {
	color: #000000;
}

<!--
.text-secondary {
	color: #0c5460;
	background-color: #d1ecf1;
	border-color: #bee5eb;
	font-size: 25px;
	margin-right: 15px;
}
-->
</style>
 
<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
	<liferay-util:include page="/note-document/note-document-navigation.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="movement" />
		</liferay-util:include>
		
		<h2
			style="text-align: center; text-decoration: underline; margin-top: 20px;">
			<liferay-ui:message key="label-notedocument-movement-heading" />
		</h2>
		<liferay-ui:search-container delta="${delta}"
			emptyResultsMessage="message-record-not-found" total="${noteDocumentMovementListCount}"
			iteratorURL="${noteDocumentMovementManagementToolbarDisplayContext.getCurrentURL()}">
			<liferay-ui:search-container-results results="${noteDocumentMovementList}" />


			<liferay-ui:search-container-row
				className="io.jetprocess.list.model.NoteDocumentMovementDTO"
				modelVar="noteDocumentMovementDTO" keyProperty="">
				<liferay-ui:search-container-column-text
					value="<%=noteDocumentMovementDTO.getSentOn() != null ? simpleformat.format(noteDocumentMovementDTO.getSentOn())
							: ""%>"
					name="label-sent-on" />
				<liferay-ui:search-container-column-text
					value="<%=noteDocumentMovementDTO.getSentBy() != null ? noteDocumentMovementDTO.getSentBy() : ""%>"
					name="label-sent-by" cssClass="hover-tips" />
				<liferay-ui:search-container-column-text
					value="<%=noteDocumentMovementDTO.getSentTo() != null ? noteDocumentMovementDTO.getSentTo() : ""%>"
					name="label-sent-to" cssClass="hover-tips" />
				<liferay-ui:search-container-column-text
					value="<%=noteDocumentMovementDTO.getRemarks() != null ? noteDocumentMovementDTO.getRemarks() : ""%>"
					name="label-remarks" cssClass="hover-tips" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator paginate="false" />
			<liferay-ui:search-paginator
				searchContainer="<%=new SearchContainer()%>" markupView="lexicon" />
		</liferay-ui:search-container>
		
	 </div>
	 
</div>



