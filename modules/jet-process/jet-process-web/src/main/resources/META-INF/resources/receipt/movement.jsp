<%@page import="io.jetprocess.masterdata.model.ReceiptMovementDTO"%>
<%@include file="../init.jsp"%>
<%@ include file="/common/common.jsp"%>
<style>
<!--
.text-secondary{
    margin-top: -177px !important;
    /* color: #0c5460;
    background-color: #d1ecf1;
    border-color: #bee5eb;
    font-size: 25px;
    margin-right: 15px; */
}
-->
</style>
<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
		<liferay-util:include page="/receipt/receipt-view-nav.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="movement" />
		</liferay-util:include>
		<%
			SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MM/yyyy hh:mm aa");
			simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
		%>
		
			<h2 style="text-align: center; text-decoration: underline; margin-top: 20px;">
				<liferay-ui:message key="label-receipt-movement-heading" />
			</h2>

		
			<liferay-ui:search-container delta="${delta}"
				emptyResultsMessage="label-no-record-found" 
				iteratorURL="${receiptMovementDisplayContext.getCurrentURL()}">
				<liferay-ui:search-container-results>
					<%
						List<ReceiptMovementDTO> receiptMovementList = new ArrayList();
								receiptMovementList = (List<ReceiptMovementDTO>) request.getAttribute("receiptMovementList");
								searchContainer.setResultsAndTotal(receiptMovementList);
								searchContainer.setTotalVar("" + receiptMovementList.size() + "");
					%>
				</liferay-ui:search-container-results>
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
					<liferay-ui:search-container-column-text
						value="<%=receiptMovementDTO.getPullBackRemark() != null ? receiptMovementDTO.getPullBackRemark()
							: ""%>"
						name="label-pullback-remark" cssClass="hover-tips" />
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator markupView="lexicon" />
			</liferay-ui:search-container>
	</div>
</div>
