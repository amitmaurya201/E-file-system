<%@ include file="../init.jsp"%>
<%
HttpSession session = themeDisplay.getRequest().getSession();
long userPostId = Long.parseLong((String) session.getAttribute("userPostId"));
List<ReceiptListViewDto> receiptList = MasterdataLocalServiceUtil.getReceiptList(userPostId);
 long docFileId = (Long)request.getAttribute("docFileId");
/* out.print("docFileId-------->"+docFileId); */
%>
<portlet:actionURL var = "attachReceipt" name="AttachFileCorrespondence">
<portlet:param name="redirect" value="/file/file-inner-view.jsp"/>
</portlet:actionURL>
<aui:form action ="${attachReceipt} " method="post" name="attachReceipt">
 <aui:input name="docFileId" value= "${docFileId }" type = "hidden"></aui:input> 
  <aui:input name="userPostId" value= "${userPostId} " type = "hidden"></aui:input> 
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
			<liferay-ui:search-container-column-text name="type" ><%=aReceiptListViewDto.getNature().charAt(0) %></liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text property="receiptNumber" />
		<%-- 	<liferay-ui:search-container-column-text property="remark" /> --%>
			<liferay-ui:search-container-column-text property="subject" />
			
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator markupView="lexicon" />
	</liferay-ui:search-container>
	
		<div class="textOnInput">
		<label>Remarks</label>
		<textarea name = "remarks" cols="100">${aReceiptListViewDto.getRemark()}</textarea>
	</div>

	<input  class="btn btn-primary" style="float: right; " type="submit" value="Attach" />
</aui:form>
