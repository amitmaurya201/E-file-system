<%@page import="io.jetprocess.masterdata.model.ReceiptMovementDTO"%>
<%@ include file="../init.jsp"%>
<%@ include file="/common/common.jsp"%>


<style>
.table thead th {
	border-right: 1px solid white;
}
</style>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/receipt/inbox.jsp" />
</liferay-portlet:renderURL>

<%
	List<ReceiptMovementDTO> receiptInboxList = MasterdataLocalServiceUtil
			.getReceiptInboxList(selectedUserPostId != null ? Integer.parseInt(selectedUserPostId) : 1);
	int count = receiptInboxList.size();
%>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
		<h1 class=" text-center">Receipt InBox</h1>

		<liferay-ui:search-container total="<%=count%>" delta="5"
			iteratorURL="<%=iteratorURL%>">
			<liferay-ui:search-container-results results="<%=receiptInboxList %>" />
			<liferay-ui:search-container-row
				className="io.jetprocess.masterdata.model.ReceiptMovementDTO"
				keyProperty="receiptMovementId" modelVar="receiptMovementDTO">
			
				
				<portlet:renderURL var="sendURL">
					<portlet:param name="mvcRenderCommandName" value="<%= MVCCommandNames.RECEIPT_SEND_RENDER_COMMAND %>" />
					<portlet:param name="receiptId" value="${receiptMovementDTO.getReceiptId()}" />
				</portlet:renderURL>

				<liferay-ui:search-container-column-text name="">
					<%=receiptMovementDTO.getNature().charAt(0)%>
				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text property="receiptNumber"
					name="Receipt No." />
					
				<liferay-ui:search-container-column-text property="subject"
					name="Subject" />
					
				<liferay-ui:search-container-column-text property="sentBy"
					name="Sent By" cssClass="hover-tips" />

				<%
					SimpleDateFormat simpleformat = new SimpleDateFormat("dd-MM-yy hh:mm aa");
							simpleformat.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
				%>

				<liferay-ui:search-container-column-text
					value="<%=simpleformat.format(receiptMovementDTO.getSentOn())%>"
					name="Sent On" />

				<%-- <liferay-ui:search-container-column-text property="readOn"
					value="<%=simpleformat.format(receiptMovementDTO.getSentOn())%>"
					name="Read On" /> --%>
					
				<liferay-ui:search-container-column-text property="dueDate"
					value="<%=simpleformat.format(receiptMovementDTO.getSentOn())%>"
					name="Due On" />
					
				<liferay-ui:search-container-column-text property="remark" name="Remarks">
					<c:if test="${not empty fileinboxDtoList.getRemark()}">
						<%=receiptMovementDTO.getRemark() %>
					</c:if>
				</liferay-ui:search-container-column-text>
				
				<c:choose>
					<c:when test="${receiptMovementDTO.getNature()=='Electronic'}">
						<liferay-ui:search-container-column-text name="Action"
							align="center">
							<span><a href="#">Read</a></span>&nbsp;						
							<span><a href="${sendURL}">Send</a></span>
						</liferay-ui:search-container-column-text>
					</c:when>
					<c:otherwise>
						<liferay-ui:search-container-column-text name="Action"
							align="center">
							<span><a href="#">Received</a></span>&nbsp;
							<span><a href="${sendURL}">Send</a></span>
						</liferay-ui:search-container-column-text>
					</c:otherwise>
				</c:choose>

			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator markupView="lexicon" />
		</liferay-ui:search-container>

	</div>
</div>
