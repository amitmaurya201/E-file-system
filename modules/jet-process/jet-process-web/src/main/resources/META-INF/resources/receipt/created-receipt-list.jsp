<%@ include file="../init.jsp"%>

<%
	String backURL = themeDisplay.getURLCurrent();
%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/receipt/created-receipt-list.jsp" />
</liferay-portlet:renderURL>

<style>
.lfr-search-container-wrapper a:not(.component-action):not(.btn) {
  color: #000000;
}

.invisible {
	visibility: hidden !important;
}

.visible {
	visibility: visible !important;
}

.btn-close {
	position: absolute;
	top: 0px;
	right: 0px;
	padding: 1px;
}

.modal-body {
	position: relative;
}

#popup {
	pointer-events: none;
}
</style>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">

		<h1 class="text-center">Created Receipt List</h1>
		<clay:management-toolbar disabled="${receiptCount eq 0}"
			displayContext="${receiptManagementToolbarDisplayContext}"
			itemsTotal="${receiptCount}" searchContainerId="recieptId" />

		<liferay-ui:search-container delta="${delta}"
			emptyResultsMessage="message-record-not-found" id="recieptId"
			total="${receiptCount}"
			iteratorURL="${receiptManagementToolbarDisplayContext._getCurrentURL()}">
			<liferay-ui:search-container-results results="${receiptFileList}" />


			<liferay-ui:search-container-row
				className="io.jetprocess.list.model.ReceiptListViewDto"
				keyProperty="receiptNumber" modelVar="receipt" cssClass="colour">

				<portlet:renderURL var="receiptDetails">
					<portlet:param name="mvcRenderCommandName"
						value="<%=MVCCommandNames.RECEIPT_DETAILS_RENDER_COMMAND%>" />
					<portlet:param name="receiptId" value="${receipt.receiptId }" />
					<portlet:param name="rmId" value="<%=String.valueOf(receipt.getReceiptMovementId()) %>" />
					<portlet:param name="backPageURL" value="<%=backURL%>"></portlet:param>
				</portlet:renderURL>

				<c:set var="firstLetterOfNature" value="${ receipt.nature}" />
				<c:set var="nature"
					value="${fn:substring(firstLetterOfNature, 0, 1)}" />
				<liferay-ui:search-container-column-text name="label-receipt-list-nature" >
						<span title="${receipt.nature }">${nature} </span>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text href="<%=receiptDetails%>" cssClass="hyperlink-css"
					value="<%=receipt.getReceiptNumber() != null ? receipt.getReceiptNumber() : ""%>"
					name="label-receipt-list-receiptno"
					orderableProperty="receiptNumber" orderable="true" />

				<liferay-ui:search-container-column-text cssClass="hover-tips"
					value="<%=receipt.getSubject() != null ? receipt.getSubject() : ""%>"
					name="label-receipt-list-subject" orderableProperty="subject"
					orderable="true" />

				<liferay-ui:search-container-column-text
					value="<%=receipt.getCategory() != null ? receipt.getCategory() : ""%>"
					cssClass="hover-tips" name="label-receipt-list-category" />

				<liferay-ui:search-container-column-text
					orderable="true" name="label-receipt-list-create-date"
					orderableProperty="createDate" >
						<fmt:formatDate type="both" pattern="dd/MM/yyyy hh:mm aa"
						timeZone="Asia/Calcutta" value="${receipt.getCreateDate()}" />
					</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text
					value="<%=receipt.getRemark() != null ? receipt.getRemark() : ""%>"
					cssClass="hover-tips remark" name="label-receipt-list-remark" />

				<liferay-ui:search-container-column-text cssClass="text-center"
					name="label-receipt-list-pdf">
					<c:if test="${not empty receipt.viewPdfUrl}">
						<i style="cursor: pointer;" class="fa fa-file-pdf openPdf"
							data-url="${receipt.viewPdfUrl}"></i>
					</c:if>
				</liferay-ui:search-container-column-text>

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="false" />
			<liferay-ui:search-paginator searchContainer="${searchContainer}"
				markupView="lexicon" />
		</liferay-ui:search-container>

		<portlet:renderURL var="viewPdf"
			windowState="<%=LiferayWindowState.POP_UP.toString()%>">
			<portlet:param name="mvcPath" value="/receipt/pdf_view.jsp" />
			<portlet:param name="pdfUrl" value="${receipt.viewPdfUrl }" />
		</portlet:renderURL>

		<div id="popup" class="modal invisible" tabindex="-1">
			<div class="modal-dialog">
				<div class="modal-content" style="max-width: 70rem; margin: 0 auto;">
					<div class="modal-body" style="padding: 0">
						<button type="button" class="btn btn-white btn-close"
							data-bs-dismiss="modal" aria-label="Close"
							style="color: black; margin-right: 9px; margin-top: -3px;">&#10005;</button>
						<br>
						<div id="pdf"></div>
					</div>

				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(
			function() {
				$('.btn-close').on('click', function(e) {
					$('#popup').modal('hide');
				});

				$(".openPdf").on(
						'click',
						function(e) {
							let url = themeDisplay.getPortalURL()
									+ ($(this).attr('data-url')).trim();
							$('#popup').modal({
								keyboard : false
							});
							$('#popup').removeClass('invisible').addClass(
									'visible');
							$('#popup').find('div#pdf').empty();
							let embeded = $('<embed/>', {
								type : 'application/pdf',
								width : '100%',
								height : '500'
							}).appendTo($('#popup').find('div#pdf'));
							embeded.attr('src', url);
						});
			});
</script>