<%@ include file="../init.jsp"%>
<%
	HttpSession userPostId = themeDisplay.getRequest().getSession();
	String userPostsValue = (String) userPostId.getAttribute("userPostId");
	long docFileId = (Long) request.getAttribute("docFileId");
	String redirectURL = themeDisplay.getURLCurrent();
	String currentURL = (String) renderRequest.getAttribute("CurrentURL");
	session.setAttribute("currentURL", currentURL);
%>

<div class="p-3">



	<portlet:actionURL var="attachReceipt" name="AttachFileCorrespondence">
		<%-- <portlet:param name="redirect" value="/file/file-inner-view.jsp" />  --%>
	</portlet:actionURL>
	<clay:management-toolbar disabled="${receiptCount eq 0}"
		displayContext="${addCorrespondenceManagementToolbarDisplayContext}"
		itemsTotal="${receiptCount}" searchContainerId="receiptList" />

	<aui:form action="${attachReceipt}" id="formId" method="post"
		name="attachReceipt">
		<aui:input name="docFileId" value="${docFileId }" type="hidden"></aui:input>
		<aui:input name="userPostId" value="${userPostsValue }" type="hidden"></aui:input>
		<aui:input name="redirectURL" type="hidden" value="<%=redirectURL%>" />

		<liferay-ui:search-container delta="${delta}"
			emptyResultsMessage="No Results Found" id="receiptList"
			total="${receiptCount}"
			iteratorURL="${addCorrespondenceManagementToolbarDisplayContext._getCurrentURL()}">
			<liferay-ui:search-container-results results="${receiptFileList }" />

			<liferay-ui:search-container-row
				className="io.jetprocess.list.model.ReceiptListViewDto"
				modelVar="aReceiptListViewDto">
				
				<portlet:renderURL var="receiptDetails">
					<portlet:param name="mvcRenderCommandName"
						value="<%=MVCCommandNames.RECEIPT_DETAILS_RENDER_COMMAND%>" />
					<portlet:param name="receiptId" value="${receipt.receiptId }" />
					<portlet:param name="backPageURL" value=""></portlet:param>
				</portlet:renderURL>
				
				<liferay-ui:search-container-column-text >
					<aui:input type="radio" name="receipt"
						value="<%=aReceiptListViewDto.getReceiptId()%>" />
					<aui:input name="isRead" id="isRead"
						value="<%=aReceiptListViewDto.isRead()%>" type="hidden"></aui:input>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text name="type"><%=aReceiptListViewDto.getNature().charAt(0)%>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text property="receiptNumber"
					name="Receipt Number" />
				<liferay-ui:search-container-column-text property="subject"
					name="Subject" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator paginate="false" />
			<liferay-ui:search-paginator
				searchContainer="<%=new SearchContainer()%>" markupView="lexicon" />
		</liferay-ui:search-container>
		<aui:input label="Remark" name="remarks" type="textarea">
			<aui:validator name="required" />
		</aui:input>

		<aui:button cssClass="d-none" id="attachFormSubmit" type="submit"></aui:button>
		<aui:button cssClass="btn btn-primary" id="attachForm"
			style="float: right; margin-top: 10px;" type="button" value="Attach"></aui:button>

	</aui:form>

</div>



<div class="ml-3" id="alert-read-remove"
	style="box-shadow: 0 6px 11px 0 rgb(0 0 0/ 20%); width: 300px; margin-right: 74%; margin-top: -200px;">
	<liferay-ui:error key="receipt-is-not-attachable"
		message="This Receipt is not attachable" />
</div>



<portlet:actionURL var="receiptReceive" name="<%=MVCCommandNames.RECEIPT_INBOX_RECEIVE_ACTION_COMMAND %>">
						<portlet:param name="receiptId" value="${receipt.receiptId }" />
	
		<%-- <portlet:param name="redirect" value="/file/file-inner-view.jsp" />  --%>
	</portlet:actionURL>

<!-- Button trigger modal -->
<button type="button" id="isReadAlert" class="btn btn-primary" hidden
	data-toggle="modal" data-target="#exampleModal"></button>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Confirmation</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<h6>Do you wanna Read as received and continue</h6>
				<aui:form action="${receiptReceive}" id="receiveForm" method="post"
					name="receiveForm">
					<aui:input name="receiptId" value="3004" type="hidden"></aui:input>
					<aui:input name="rmId" value="1902"
						type="hidden"></aui:input>
					<aui:button type="button" class="btn btn-secondary"
						data-dismiss="modal" value="No"></aui:button>
					<aui:button type="submit" class="btn btn-primary" value="Yes"></aui:button>
				</aui:form>
			</div>

		</div>
	</div>
</div>














<aui:script>



$('#<portlet:namespace />attachForm').click(function(){
	var isRead=$('#<portlet:namespace />isRead').val();
	alert(isRead)
	if(isRead == 'false'){
		$('#isReadAlert').trigger('click');
	}else{
		alert("else...")
		<%-- var url = '${attachReceipt}';
	    document.forms["attachReceipt"].action=url;
	    document.forms["attachReceipt"].submit(); --%>
	    console.log($("#<portlet:namespace />formId"))
		<%-- $("#<portlet:namespace />formId").get(0).submit(); --%>
	<!-- $(this).submit(); -->
		$("#<portlet:namespace />attachFormSubmit").click();
	}
}) 

</aui:script>

