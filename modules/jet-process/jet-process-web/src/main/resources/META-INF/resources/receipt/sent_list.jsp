<%@page import="java.util.TimeZone"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="io.jetprocess.masterdata.model.ReceiptMovementDTO"%>
<%@ include file="../init.jsp"%>
<%@ include file="/common/common.jsp"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
#myModal .modal-dialog .modal-content .modal-body .textOnInput {
	position: relative;
	background-color: #fff;
}

#myModal .modal-dialog .modal-content .modal-body .textOnInput label {
	position: absolute;
	background-color: #fff;
	top: -15px;
	left: 10px;
	padding: 2px;
	z-index: 1;
}

#myModal .modal-dialog .modal-content .modal-body .textOnInput label:after
	{
	content: " ";
	width: 100%;
	height: 13px;
	position: absolute;
	left: 0;
	bottom: 0;
	z-index: -1;
}

#myModal .modal-dialog .modal-content .modal-body label {
	font-size: 16px;
	font-weight: 500;
	display: inline-block;
	margin-bottom: .5rem;
}
</style>




<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">


		<liferay-portlet:renderURL varImpl="iteratorURL">
			<portlet:param name="mvcPath" value="/receipt/sent_list.jsp" />
		</liferay-portlet:renderURL>

		<h1 class=" text-center">
			<liferay-ui:message key="label-receipt-sent-heading" />
		</h1>

		<clay:management-toolbar
		        disabled="${receiptCount eq 0}"
		        displayContext="${sendReceiptManagementToolbarDisplayContext}"
		        itemsTotal="${receiptCount}"
		        searchContainerId="receiptSendEntries"
		        managementToolbarDisplayContext="${sendReceiptManagementToolbarDisplayContext}"
		    />

		<liferay-ui:search-container
		delta="${delta }"
        emptyResultsMessage="no record found"
        id="receiptSendEntries"
        total="${receiptCount}" iteratorURL="${sendReceiptManagementToolbarDisplayContext._getCurrentURL()}"
        >
        <liferay-ui:search-container-results results="${receiptList}" />

			<liferay-ui:search-container-row
				className="io.jetprocess.masterdata.model.ReceiptMovementDTO"
				modelVar="receiptSentMovement" keyProperty="receiptMovementId">

				
				<c:set var = "firstLetterOfNature" value = "${ receiptSentMovement.nature}" />
				<c:set var = "nature" value = "${fn:substring(firstLetterOfNature, 0, 1)}" />
				<liferay-ui:search-container-column-text name="label-receipt-sent-nature" value="${nature }" />
				<liferay-ui:search-container-column-text property="receiptNumber"
					name="label-receipt-list-receiptno" orderable="true" orderableProperty="receiptNumber"/>
				<liferay-ui:search-container-column-text property="subject"
					name="label-receipt-list-subject" orderable="true" orderableProperty="subject" />
				<liferay-ui:search-container-column-text property="sender"
					name="label-receipt-sent-sender" />
				<liferay-ui:search-container-column-text property="sentTo"
					cssClass="hover-tips" name="label-receipt-sent-sent-to" />
				<liferay-ui:search-container-column-text
					name="label-receipt-sent-sent-on" >
					<fmt:formatDate type = "both" pattern= "dd-MM-yy hh:mm aa" timeZone = "Asia/Calcutta" value = "${receiptSentMovement.sentOn}" />
					</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text property="dueDate"
					name="label-receipt-sent-due-date" />
				<liferay-ui:search-container-column-text property="remark"
					name="label-receipt-sent-remark" />
				<liferay-ui:search-container-column-text
					name="label-receipt-sent-action">
					<c:if
						test="${(empty receiptSentMovement.readOn) and (empty receiptSentMovement.receivedOn)}">

						<button type="button" class="btn" data-bs-toggle="modal"
							data-bs-target="#myModal"
							onclick="openModal(${ receiptSentMovement.receiptMovementId} , ${receiptSentMovement.receiptId})">
							<i class="icon-indent-left"></i>
						</button>
					</c:if>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator paginate="false" />
        <liferay-ui:search-paginator searchContainer="<%=new SearchContainer() %>" markupView="lexicon" />
		</liferay-ui:search-container>
	</div>
</div>

<portlet:actionURL var="receiptSentActionURL"
			name="<%=MVCCommandNames.RECEIPT_SENT_LIST%>"/>

<!-- The Modal -->
<div class="modal fade" id="myModal">
	<div class="modal-dialog">
		<div class="modal-content">

			<!-- Modal Header -->
			<div class="modal-header"
				style="background-color: #96b4d6 !important;">
				<h4 class="modal-title">
					<liferay-ui:message key="label-receipt-sent-popup-heading" />
				</h4>
				<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
			</div>

			<!-- Modal body -->
			<div class="modal-body">
				<aui:form action="${ receiptSentActionURL}">
					<input type="text" name="<portlet:namespace />rmId" id="rmId"
						hidden>
					<input type="text" name="<portlet:namespace />receiptId"
						id="receiptId" hidden>
					<div class="textOnInput">
						<label><liferay-ui:message key="label-receipt-remark" /><span
							class='text-danger'>*</span></label>
						<aui:input label="" name="remarks" id="remarks" type="textarea">
							<aui:validator name="required"></aui:validator>
							<aui:validator name="maxLength">
								<liferay-ui:message key="receipt-sent-remarks-maxlength" />
							</aui:validator>
						</aui:input>
					</div>

					<hr style="margin: 1rem -14px;" />
					<div style="text-align: right;">
						<button type="submit" class="btn btn-primary"
							id="submit_pull_back">
							<liferay-ui:message key="label-receipt-sent-button-submit" />
						</button>
						<button type="button" class="btn btn-primary"
							data-bs-dismiss="modal">
							<liferay-ui:message key="label-receipt-sent-button-cancel" />
						</button>
					</div>
				</aui:form>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
function openModal(receiptMovementId , receiptId){
	alert(receiptMovementId);
	document.getElementById("rmId").value=receiptMovementId;
	document.getElementById("receiptId").value=receiptId; 
	$("#submit_pull_back").click(function() {
		$("#myModal").modal("hide");
		var rem = $("#<portlet:namespace />remarks").val();
		
	});
}
</script>
