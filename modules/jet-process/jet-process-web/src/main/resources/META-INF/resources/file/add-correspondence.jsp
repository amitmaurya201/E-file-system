<%@ include file="../init.jsp"%>
<%
List<ReceiptListViewDto> receiptList = MasterdataLocalServiceUtil.getReceiptList(1);
 long docFileId = (Long)request.getAttribute("docFileId");
/* out.print("docFileId-------->"+docFileId); */
%>
<portlet:actionURL var = "attachReceipt" name="AttachFileCorrespondence">
<portlet:param name="redirect" value="/file/file-inner-view.jsp"/>
</portlet:actionURL>
<aui:form action ="${attachReceipt} " method="post" name="attachReceipt">
 <aui:input name="docFileId" value= "${docFileId }" type = "hidden"></aui:input> 
  <aui:input name="userPostId" value= "1" type = "hidden"></aui:input> 
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
		<%-- 	<liferay-ui:search-container-column-text property="remark" /> --%>
			<liferay-ui:search-container-column-text property="subject" />
			<liferay-ui:search-container-column-text property="nature" />
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator markupView="lexicon" />
	</liferay-ui:search-container>
	<textarea name = "remarks" rows="4" cols="100">${aReceiptListViewDto.getRemark()}</textarea>
	<input  class="btn btn-primary" style="float: right; " type="submit" value="Attach" />
</aui:form>
