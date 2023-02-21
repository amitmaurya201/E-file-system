<%@ include file="../init.jsp"%>
<%@page import="io.jetprocess.list.model.ClosedReceiptDTO"%>

<portlet:renderURL var="receiptDetailsPopup"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.CORRESPONDENCES_RECEIPT_DETAIL_RENDER_COMMAND%>" />
</portlet:renderURL>

<style>
.lfr-search-container-wrapper a:not (.component-action ):not (.btn ) {
	color: #000000;
}
</style>
<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
		<h1 class=" text-center">
			<liferay-ui:message key="label-receipt-closed-heading" />
		</h1>
		<clay:management-toolbar searchContainerId="closedReceiptEntries"
			disabled="${closedReceiptCount eq 0 }"
			itemsTotal="${closedReceiptCount}"
			displayContext="${closedReceiptManagementToolbarDisplayContext}"
			selectable="false" />

		<liferay-ui:search-container id="closedReceiptEntries"
			emptyResultsMessage="message-record-not-found"
			total="${closedReceiptCount}" delta="${delta }"
			iteratorURL="${closedReceiptManagementToolbarDisplayContext._getCurrentURL() }">
			<liferay-ui:search-container-results results="${closedReceiptList}" />

			<liferay-ui:search-container-row
				className="io.jetprocess.list.model.ClosedReceiptDTO"
				modelVar="closedReceiptDTO" keyProperty="closedReceiptId">

				<liferay-ui:search-container-column-text
					name="label-receipt-closed-type" property="nature" />
				<liferay-ui:search-container-column-text
					name="label-receipt-closed-receiptNumber" orderable="true"
					orderableProperty="receiptNumber" cssClass="hyperlink-css">
					<a onclick="receiptDetailPopup(${closedReceiptDTO.receiptId})" style="cursor: pointer">${closedReceiptDTO.receiptNumber }</a>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text
					value="${closedReceiptDTO.subject }"
					name="label-receipt-closed-subject" orderable="true"
					orderableProperty="subject" cssClass="hover-tips" />
				<liferay-ui:search-container-column-text
					name="label-receipt-closed-closedOn" orderable="true"
					orderableProperty="closedOn">
					<fmt:formatDate type="both" pattern="dd/MM/yyyy hh:mm aa"
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
<aui:script>
function receiptDetailPopup(receiptId){
	var title="<liferay-ui:message key='title-closed-receiptDetailPopup' />";
	Liferay.Util.openWindow({ 
		dialog: { 														 
			height: 550,														 
			destroyOnClose: true,														 
			destroyOnHide: true, 														 
			modal: true, 														 
			width: 1200,
			on: {
	        	destroy: function() { 
	           		parent.location.reload();                   
	       	 	}
	      	}													 
		}, 														 
		id: '<portlet:namespace />dialog',														 
		title: title, 														 
		uri: '<%=receiptDetailsPopup%>&<portlet:namespace />receiptId='+receiptId,			
		});	  
	}
</aui:script>