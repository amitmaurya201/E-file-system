<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="io.jetprocess.masterdata.model.ReceiptMovementDTO"%>
<%@ include file="../init.jsp"%>
<%@ include file="/common/common.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<style>
.popup, .pull_back-popup {
	position: absolute;
	background: #bebec1;
	border: 3px solid #666666;
	margin-top: -30%;
	left: 30%;
	display: none;
}

.popup {
	width: 50%;
	height: 50%;
}

.pull_back-popup {
	width: 35%;
	height: 51%;
	left: 37%;
	background: #bcd0e7;
}

.popup.active, .pull_back-popup.active {
	text-align: center;
	display: block;
}

#bg_blur.active {
	pointer-events: none;
	opacity: 0.5;
}

.button {
	border: none;
}
</style>

<%-- <%
	String status = ParamUtil.getString(renderRequest, "status");

	String result = ParamUtil.getString(renderRequest, "result");
%> --%>

<div class="row" id="bg_blur">
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
		<clay:management-toolbar disabled="${receiptCount eq 0}"
			displayContext="${sendReceiptManagementToolbarDisplayContext}"
			itemsTotal="${receiptCount}" searchContainerId="receiptSendEntries"
			managementToolbarDisplayContext="${sendReceiptManagementToolbarDisplayContext}" />
		<liferay-ui:search-container delta="${delta }"
			emptyResultsMessage="no record found" id="receiptSendEntries"
			total="${receiptCount}"
			iteratorURL="${sendReceiptManagementToolbarDisplayContext._getCurrentURL()}">
			<liferay-ui:search-container-results results="${receiptList}" />

			<liferay-ui:search-container-row
				className="io.jetprocess.masterdata.model.ReceiptMovementDTO"
				modelVar="receiptSentMovement" keyProperty="receiptMovementId">


				<c:set var="firstLetterOfNature"
					value="${ receiptSentMovement.nature}" />
				<c:set var="nature"
					value="${fn:substring(firstLetterOfNature, 0, 1)}" />
				<liferay-ui:search-container-column-text
					name="label-receipt-sent-nature" value="${nature }" />
				<liferay-ui:search-container-column-text property="receiptNumber"
					name="label-receipt-list-receiptno" orderable="true"
					orderableProperty="receiptNumber" />
				<liferay-ui:search-container-column-text property="subject"
					name="label-receipt-list-subject" orderable="true"
					orderableProperty="subject" cssClass="hover-tips" />
				<liferay-ui:search-container-column-text property="sender"
					name="label-receipt-sent-sender" cssClass="hover-tips" />
				<liferay-ui:search-container-column-text property="sentTo"
					cssClass="hover-tips" name="label-receipt-sent-sent-to" />
				<liferay-ui:search-container-column-text
					name="label-receipt-sent-sent-on">
					<fmt:formatDate type="both" pattern="dd-MM-yy hh:mm aa"
						timeZone="Asia/Calcutta" value="${receiptSentMovement.sentOn}" />
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text property="dueDate"
					name="label-receipt-sent-due-date" />
				<liferay-ui:search-container-column-text
					value="<%=receiptSentMovement.getRemark() != null ? receiptSentMovement.getRemark() : ""%>"
					name="label-receipt-sent-remark" cssClass="hover-tips" />
				<liferay-ui:search-container-column-text
					name="label-receipt-sent-action">
					<c:if
						test="${(empty receiptSentMovement.readOn) and (empty receiptSentMovement.receivedOn)}">

						<button type="button" class="btn" id="myBtn"
							onclick="openModal(${ receiptSentMovement.receiptMovementId} , ${receiptSentMovement.receiptId})">
							<!-- <i class="icon-indent-left"></i> -->
							<img alt="pullback"
								src='<%=request.getContextPath() + "/image/pullback.png"%>'
								width="100%" height="35" />
						</button>
					</c:if>
				</liferay-ui:search-container-column-text>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator paginate="false" />
			<liferay-ui:search-paginator
				searchContainer="<%=new SearchContainer()%>" markupView="lexicon" />
		</liferay-ui:search-container>


		<%-- 
		<%
			if (status.equalsIgnoreCase("Warning")) {
		%>
		<div class="alert alert-warning alert-dismissible" id="error-alert"
			style="width: 28%;">
			<button type="button" class="close" data-dismiss="alert">&times;</button>
			<strong style="padding-left: 30px;"><%=result%></strong>
		</div>
		<%
			}
		%> --%>
	</div>
</div>

<portlet:actionURL var="receiptSentActionURL"
	name="<%=MVCCommandNames.RECEIPT_SENT_LIST%>" />

<!-- pull_back pop up -->
<div id="pull_back" class="pull_back-popup">
	<!--   Creates the popup content-->
	<div class="container mt-3">
		<div>
			<button type="button" class="close popup_close"
				style="float: right; font-size: 25px; margin-top: -4%; margin-right: -3%;">
				<span aria-hidden="true">&times;</span>
			</button>
			<h3>
				<liferay-ui:message key="label-receipt-sent-popup-heading" />
			</h3>
		</div>
		<hr style="margin: 1rem -14px;" />
		<aui:form action="<%=receiptSentActionURL%>" method="post" name="fm">
			<input type="text" name="<portlet:namespace />rmId" id="rmId" hidden>
			<input type="text" name="<portlet:namespace />receiptId"
				id="receiptId" hidden>
			<div style="text-align: left; height: 100px;">
				<aui:input label="label-receipt-remark" name="remarks" id="remarks"
					type="textarea">
					<aui:validator name="required"></aui:validator>
					<aui:validator name="maxLength">
						<liferay-ui:message key="receipt-sent-remarks-maxlength" />
					</aui:validator>
				</aui:input>
			</div>

			<hr style="margin: 1rem -14px;" />
			<div style="text-align: right;">
				<button type="submit" class="btn btn-primary" id="submit_pull_back">
					<liferay-ui:message key="label-receipt-sent-button-submit" />
				</button>
				<button type="button" class="btn btn-primary popup_close" id="close">
					<liferay-ui:message key="label-receipt-sent-button-cancel" />
				</button>
			</div>
		</aui:form>
	</div>
</div>
<liferay-ui:success key="pullback-available" message="pullback-success" />
<div class="ml-3" id="error-alert"
	style="box-shadow: 0 6px 11px 0 rgb(0 0 0/ 20%); margin-right: 74%; margin-top: -40px;">
	<liferay-ui:error key="pullback-not-available" message="pullback-error" />
</div>

<script type="text/javascript">

$("#error-alert").fadeTo(2000, 500).slideUp(500, function(){
    $("#error-alert").slideUp(500);
});	

function openModal(receiptMovementId , receiptId){
	document.getElementById("rmId").value=receiptMovementId;
	document.getElementById("receiptId").value=receiptId; 
	$("#<portlet:namespace />remarks").val("");
	$("#pull_back").addClass("active");
	$("#bg_blur").addClass("active");
	$(".popup_close").on("click", function() {
		  $("#pull_back").removeClass("active");
		  $("#bg_blur").removeClass("active");
		});
}
</script>
