<%@ include file="../init.jsp"%>
<%
List<ReceiptListViewDto> receiptList = MasterdataLocalServiceUtil.getReceiptList(selectedUserPostId != null ? Long.parseLong(selectedUserPostId) : 1);
%>
<portlet:actionURL var = "attachReceipt" name="AttachFileCorrespondence">
<portlet:param name="redirect" value="/file/correspondence-list.jsp"/>
</portlet:actionURL>
<aui:form action ="${attachReceipt} " method="post" name="attachReceipt">

	<liferay-ui:search-container total="<%=receiptList.size()%>"
		delta="5" deltaConfigurable="true"
		emptyResultsMessage="No Results Found">
		<liferay-ui:search-container-results
			results="<%=ListUtil.subList(receiptList, searchContainer.getStart(), searchContainer.getEnd())%>" />

		<liferay-ui:search-container-row
			className="io.jetprocess.masterdata.model.ReceiptListViewDto"
			modelVar="aReceiptListViewDto">
			<liferay-ui:search-container-column-text>
			<aui:input type="radio" name="receipt" value="<%=aReceiptListViewDto.getReceiptId() %>" />
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text property="receiptNumber" />
			<liferay-ui:search-container-column-text property="remark" />
			<liferay-ui:search-container-column-text property="subject" />
			<liferay-ui:search-container-column-text property="nature" />
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator markupView="lexicon" />
	</liferay-ui:search-container>
	<input type="submit" value="Attach" />
</aui:form>