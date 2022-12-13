
<%@page import="io.jetprocess.masterdata.model.ReceiptMovementDTO"%>
<%@ include file="../init.jsp"%>

<%
List<ReceiptMovementDTO> receiptInboxList = MasterdataLocalServiceUtil.getReceiptInboxList(selectedUserPostId != null ? Integer.parseInt(selectedUserPostId) : 1);
int count = receiptInboxList.size();
%>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
		<h1 class=" text-center">Receipt InBox </h1>
		
	<liferay-ui:search-container total="<%= count %>">
		<liferay-ui:search-container-results results="<%=receiptInboxList %>"  />
		<liferay-ui:search-container-row className="io.jetprocess.masterdata.model.ReceiptMovementDTO" modelVar="aReceiptMovementDTO" >
			<liferay-ui:search-container-column-text property="receiptNumber" name="Receipt Number" />
			<liferay-ui:search-container-column-text property="subject" name="Subject" />
			<liferay-ui:search-container-column-text property="sentBy" name="Sent By"/>
			<liferay-ui:search-container-column-text property="sentOn" name="Sent On"/>
			<liferay-ui:search-container-column-text property="readOn" name="Read On"/>
			<liferay-ui:search-container-column-text property="dueDate" name="Due On"/>
			<liferay-ui:search-container-column-text property="remark" name="Remarks"/>
			<liferay-ui:search-container-column-text property="" name="Actions">
				<i class="fa fa-solid fa-eye"></i>
				<i class="fa fa-edit"></i>
				<i class="fa fa-file-pdf openPdf"  ></i>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
		
	</div>
</div>
