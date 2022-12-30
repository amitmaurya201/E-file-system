<%@ include file="../init.jsp"%>
<%@page import="io.jetprocess.web.display.context.AddCorrespondenceManagementToolbarDisplayContext"%>
<%
	long userPostId =1;
	int count = (int) request.getAttribute("receiptCount");
	List<ReceiptListViewDto> receiptList = MasterdataLocalServiceUtil.getCreatedReceiptAndInboxList(userPostId,
			userPostId);
	long docFileId = (Long) request.getAttribute("docFileId");
%>
<portlet:actionURL var="attachReceipt" name="AttachFileCorrespondence">
	<portlet:param name="redirect" value="/file/file-inner-view.jsp" />
</portlet:actionURL>
<clay:management-toolbar 
	disabled="${receiptCount eq 0}"
	displayContext="${addCorrespondenceManagementToolbarDisplayContext}"
	itemsTotal="${receiptCount}" 
	searchContainerId="receiptList" />
	
<aui:form action="${attachReceipt} " method="post" name="attachReceipt">
	<aui:input name="docFileId" value="${docFileId }" type="hidden"></aui:input>
	<aui:input name="userPostId" value="${userPostId }" type="hidden"></aui:input>

	<liferay-ui:search-container  
	delta= "7"
	 emptyResultsMessage="No Results Found" 
	 id="receiptList" 
	 total ="${receiptCount}"
	 iteratorURL="${addCorrespondenceManagementToolbarDisplayContext._getCurrentURL()}" >
		<liferay-ui:search-container-results results="${receiptFileList }" />

		<liferay-ui:search-container-row
			className="io.jetprocess.masterdata.model.ReceiptListViewDto"
			modelVar="aReceiptListViewDto">
			<liferay-ui:search-container-column-text>
				<aui:input type="radio" name="receipt"
					value="<%=aReceiptListViewDto.getReceiptId()%>" />
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="type"><%=aReceiptListViewDto.getNature().charAt(0)%>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text property="receiptNumber"
				name="Receipt Number" />
			<liferay-ui:search-container-column-text property="subject"
				name="Subject" />
		</liferay-ui:search-container-row>
 <liferay-ui:search-iterator paginate="false" />
        <liferay-ui:search-paginator searchContainer="<%=new SearchContainer() %>" markupView="lexicon" />
       	</liferay-ui:search-container>
	<aui:input label="Remark" name="remarks" type="textarea" >
	<aui:validator name = "required"/>
	</aui:input>
		
	<%-- <div>
		<label>Remarks<span class="text-danger">*</span>
		</label>
		<textarea class="form-control" name="<portlet:namespace/>remarks"
			rows="3" cols="100"></textarea>
	</div> --%>

	<input class="btn btn-primary" style="float: right; margin-top: 10px;"
		type="submit" value="Attach" />

</aui:form>
