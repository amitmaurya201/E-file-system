<%@include file="../init.jsp"%>
<style>
<!--
.text-secondary {
	color: #0c5460;
	background-color: #d1ecf1;
	border-color: #bee5eb;
	font-size: 25px;
	margin-right: 15px;
}
.lfr-search-container-wrapper a:not(.component-action):not(.btn) {
  color: #000000;
}
-->
</style>

<%
	String backPageURL = (String) request.getAttribute("backPageURL");
	Receipt receipt = (Receipt) renderRequest.getAttribute("receipt");
	String type = (String) receipt.getNature();
	char firstChar = type.charAt(0);
%>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
		<liferay-util:include page="/receipt/receipt-view-nav.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="movement" />
		</liferay-util:include>
		<div class="container-fluid" style="background-color: #E8E8E8;">
			<div class="hover-tips"><%=firstChar%> | ${receipt.receiptNumber} | ${receipt.subject}
			</div>
		</div>
		<h2
			style="text-align: center; text-decoration: underline; margin-top: 20px;">
			<liferay-ui:message key="label-receipt-movement-heading" />
		</h2>

		<liferay-ui:search-container delta="${delta }"
			emptyResultsMessage="message-record-not-found"
			total="${ receiptMovementCount}"
			iteratorURL="${receiptMovementDisplayContext.getCurrentURL()}">

			<liferay-ui:search-container-results results="${receiptMovementList}" />

			<liferay-ui:search-container-row
				className="io.jetprocess.list.model.ReceiptMovementDTO"
				modelVar="receiptMovementDTO" keyProperty="receiptMovementId">
				<liferay-ui:search-container-column-text
					value="<%=receiptMovementDTO.getSentOn() != null ? simpleformat.format(receiptMovementDTO.getSentOn())
									: ""%>"
					name="label-sent-on" />
				<liferay-ui:search-container-column-text
					value="<%=receiptMovementDTO.getSentBy() != null ? receiptMovementDTO.getSentBy() : ""%>"
					name="label-sent-by" cssClass="hover-tips" />
				<liferay-ui:search-container-column-text
					value="<%=receiptMovementDTO.getSentTo() != null ? receiptMovementDTO.getSentTo() : ""%>"
					name="label-sent-to" cssClass="hover-tips" />
				<liferay-ui:search-container-column-text
					value="<%=receiptMovementDTO.getRemark() != null ? receiptMovementDTO.getRemark() : ""%>"
					name="label-remarks" cssClass="hover-tips" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator markupView="lexicon" />
		</liferay-ui:search-container>
	</div>
</div>