<%@page import="io.jetprocess.masterdata.model.ReceiptMovementDTO"%>
<%@ include file="../init.jsp"%>


<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
	
	
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/receipt/sent_list.jsp" />
</liferay-portlet:renderURL>
		
		<h1 class=" text-center">Receipt Sent List</h1>
		
		<div class="m-2 border boredr border-dark">
			<%
			 List<ReceiptMovementDTO> receiptMovementList = MasterdataLocalServiceUtil.getReceiptSentList(selectedUserPostId != null ? Integer.parseInt(selectedUserPostId) : 1);
			 int count = receiptMovementList.size();
			%>
			<div class="m-2 border boredr border-dark">
				<liferay-ui:search-container total="<%= count %>" delta="2" iteratorURL="<%=iteratorURL%>" >
					<liferay-ui:search-container-results results="<%= receiptMovementList%>" />
					<liferay-ui:search-container-row className="io.jetprocess.masterdata.model.ReceiptMovementDTO" modelVar="receiptMovementDTO" keyProperty="receiptMovementId">
						<liferay-ui:search-container-column-text property="receiptNumber" name="Receipt Number"/>
						<liferay-ui:search-container-column-text property="subject" name="Subject"/>
						<liferay-ui:search-container-column-text property="sender" name="Sender"/>
						<liferay-ui:search-container-column-text property="sentTo" name="Sent To"/>
						<liferay-ui:search-container-column-text property="sentOn" name="Sent On"/>
						<liferay-ui:search-container-column-text property="dueDate" name="Due Date"/>
						<liferay-ui:search-container-column-text property="remark" name="Remark"/>
						<liferay-ui:search-container-column-text name="Action"/>
					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator />
				</liferay-ui:search-container>
			</div>
		</div>
	</div>
</div>
