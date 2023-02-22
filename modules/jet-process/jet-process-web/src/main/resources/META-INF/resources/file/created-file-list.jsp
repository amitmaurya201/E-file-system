<%@ include file="../init.jsp"%>

<%
	String backURL = themeDisplay.getURLCurrent();
%>

<style>
.lfr-search-container-wrapper a:not(.component-action):not(.btn) {
  color: #000000;
}
</style>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">

		<h1 class="text-center">File Created List</h1>
		<clay:management-toolbar disabled="${fileCount eq 0}"
			displayContext="${fileManagementToolbarDisplayContext}"
			itemsTotal="${fileCount}" searchContainerId="createdFileEntries" />

		<liferay-ui:search-container delta="${delta}"
			emptyResultsMessage="message-record-not-found" id="createdFileEntries"
			total="${fileCount}"
			iteratorURL="${fileManagementToolbarDisplayContext._getCurrentURL()}">
			<liferay-ui:search-container-results results="${fileList}" />

			<liferay-ui:search-container-row
				className="io.jetprocess.list.model.FileListViewDto"
				keyProperty="fileNumber" modelVar="filedto">

				<portlet:renderURL var="fileInnerView">
					<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.FILEINNERVIEW_RENDER_COMMAND %>" />
					<portlet:param name="docFileId" value="${filedto.docFileId}" />
					<portlet:param name="fileMovementId" value="<%=String.valueOf(filedto.getFilemovementId()) %>" />					
					<portlet:param name="backPageURL" value="<%=backURL%>"></portlet:param>
				</portlet:renderURL>

				<c:set var="firstLetterOfNature" value="${ filedto.nature}" />
				<c:set var="nature"
					value="${fn:substring(firstLetterOfNature, 0, 1)}" />
				<liferay-ui:search-container-column-text name=" " value="${nature }">
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text href="<%=fileInnerView%>"
					name="label-file-list-fileno"  cssClass="hyperlink-css"
					value="<%=filedto.getFileNumber() != null ? filedto.getFileNumber() : ""%>"
					orderableProperty="filenumber" orderable="true" />

				<liferay-ui:search-container-column-text 
					value="<%=filedto.getSubject() != null ? filedto.getSubject() : ""%>"
					orderable="true" orderableProperty="subject" cssClass="hover-tips"
					name="label-file-list-subject" />

				<liferay-ui:search-container-column-text
					value="<%=filedto.getCategory() != null ? filedto.getCategory() : ""%>"
					name="category" cssClass="hover-tips" />

				<liferay-ui:search-container-column-text
					value="<%=filedto.getCreateDate() != null ? simpleformat.format(filedto.getCreateDate()) : ""%>"
					name="label-file-list-createon" orderable="true" orderableProperty="createdOn" />

				<liferay-ui:search-container-column-text
					value="<%=filedto.getRemark() != null ? filedto.getRemark() : ""%>"
					name="label-file-list-remark" cssClass="hover-tips" />
					
				<liferay-ui:search-container-column-text
					name="" cssClass="hover-tips" >
				<c:if test="${filedto.hasNote}">
					<img src='<%=request.getContextPath() + "/image/green-note.jpg"%>'
						width="30%" height="20" class="shadow m-1 bg-white rounded-circle" />
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