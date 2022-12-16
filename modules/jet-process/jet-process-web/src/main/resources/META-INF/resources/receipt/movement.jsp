<%@page import="io.jetprocess.masterdata.model.ReceiptMovementDTO"%>
<%@include file="../init.jsp"%>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
		<liferay-util:include page="/receipt/receipt-view-nav.jsp" servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="movement" />
		</liferay-util:include>
		<div class="m-2 border boredr border-dark">
			<%
			 SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
			 simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
			%>
			<div class="m-2 border boredr border-dark">
				<liferay-ui:search-container delta="5" emptyResultsMessage="No Record Found" iteratorURL="${receiptMovementDisplayContext.getCurrentURL()}" >
					<liferay-ui:search-container-results>
						<%
							List<ReceiptMovementDTO> receiptMovementList = new ArrayList();
							receiptMovementList = (List<ReceiptMovementDTO>) request.getAttribute("receiptMovementList");
							searchContainer.setResultsAndTotal(receiptMovementList);
							searchContainer.setTotalVar("" + receiptMovementList.size() + "");
						%>
					</liferay-ui:search-container-results>
					<liferay-ui:search-container-row className="io.jetprocess.masterdata.model.ReceiptMovementDTO" modelVar="receiptMovementDTO" keyProperty="receiptMovementId">
						<liferay-ui:search-container-column-text value="<%=receiptMovementDTO.getSentOn() != null ? simpleformat.format(receiptMovementDTO.getSentOn()) : ""%>" name="label-sent-on"/>
						<liferay-ui:search-container-column-text value="<%=receiptMovementDTO.getSentBy() != null ? receiptMovementDTO.getSentBy() : ""%>"  name="label-sent-by"/>
						<liferay-ui:search-container-column-text value="<%=receiptMovementDTO.getSentTo() != null ? receiptMovementDTO.getSentTo() : ""%>"  name="label-sent-to"/>
						<liferay-ui:search-container-column-text value="<%=receiptMovementDTO.getRemark() != null ? receiptMovementDTO.getRemark() : ""%>"  name="label-remarks"/>
						<liferay-ui:search-container-column-text value="<%=receiptMovementDTO.getPullBackRemark() != null ? receiptMovementDTO.getPullBackRemark() : ""%>"  name="label-pullback-remark"/>
					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator markupView="lexicon" />
				</liferay-ui:search-container>
			</div>
		</div>
	</div>
</div>
