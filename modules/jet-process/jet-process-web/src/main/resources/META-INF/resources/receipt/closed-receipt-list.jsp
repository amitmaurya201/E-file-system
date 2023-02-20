<%@ include file="../init.jsp"%>
<%@page import="io.jetprocess.list.model.ClosedReceiptDTO"%>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/receipt/closed-receipt-list.jsp" />
</liferay-portlet:renderURL>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
		<h1 class=" text-center">
			<liferay-ui:message key="label-receipt-closed-heading" />
		</h1>
		<clay:management-toolbar searchContainerId="closedReceiptEntries"
			displayContext="${closedReceiptManagementToolbarDisplayContext}" />

		<liferay-ui:search-container id="closedReceiptEntries"
			emptyResultsMessage="message-record-not-found" 
			iteratorURL="${closedReceiptManagementToolbarDisplayContext._getCurrentURL() }">
			<liferay-ui:search-container-results results="${closedReceiptList}" />

			<liferay-ui:search-container-row
				className="io.jetprocess.list.model.ClosedReceiptDTO"
				modelVar="closedReceiptDTO" keyProperty="closedReceiptId">

				<liferay-ui:search-container-column-text
					name="label-receipt-closed-type" property="nature" />
				<liferay-ui:search-container-column-text
					value="${closedReceiptDTO.receiptNumber }"
					name="label-receipt-closed-receiptNumber" orderable="true"
					orderableProperty="receiptNumber" />
				<liferay-ui:search-container-column-text
					value="${closedReceiptDTO.subject }"
					name="label-receipt-closed-subject" orderable="true"
					orderableProperty="subject" cssClass="hover-tips" />
				<liferay-ui:search-container-column-text
					name="label-receipt-closed-closedOn" orderable="true"
					orderableProperty="closedOn">
					<fmt:formatDate type="both" pattern="dd/MM/yyyy"
						timeZone="Asia/Calcutta" value="${closedReceiptDTO.closedOn}" />
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text
					name="label-receipt-closed-closingRemarks" cssClass="hover-tips"
					property="closingRemarks" />

			</liferay-ui:search-container-row>

			<%-- Iterator / Paging --%>
			<liferay-ui:search-iterator paginate="false" />
			<liferay-ui:search-paginator
				searchContainer="<%=new SearchContainer()%>" markupView="lexicon" />


		</liferay-ui:search-container>






	</div>
</div>
