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

	<aui:form action="${attachReceipt}"  method="post"
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
					<aui:input type="radio" onchange="receiptDetail(${aReceiptListViewDto.isRead()},
					${aReceiptListViewDto.getReceiptId()},
					 ${aReceiptListViewDto.getReceiptMovementId()})" 
					name="receipt"
					value="<%=aReceiptListViewDto.getReceiptId()%>" />
					
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text  name="type"><%=aReceiptListViewDto.getNature().charAt(0)%>
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
					<aui:input name="receiptId"  type="text"></aui:input>
					<aui:input name="rmId" 
						type="text"></aui:input>
					<aui:button type="button" class="btn btn-secondary"
						data-dismiss="modal" value="No"></aui:button>
					<aui:button type="submit" class="btn btn-primary" value="Yes"></aui:button>
				</aui:form>
			</div>

		</div>
	</div>
</div>














<script>
var isRead;
var receiptId;
var receiptMovementId;

function receiptDetail(_isRead, _receiptId, _receiptMovementId){
	isRead=_isRead;
	receiptId=_receiptId;
	receiptMovementId=_receiptMovementId;
	console.log(isRead+" : "+receiptId+" : "+receiptMovementId)
}


$('#<portlet:namespace />attachForm').click(function(){
	alert(isRead)
	console.log(isRead+" -:- "+receiptId+" -:- "+receiptMovementId)
	if(isRead == false){
		alert("IF.....")
		$("#<portlet:namespace />receiptId").val(receiptId);
		$("#<portlet:namespace />rmId").val(receiptMovementId);
		
		$('#isReadAlert').trigger('click');
		
		/* $("#<portlet:namespace />attachReceipt").submit(); */
	}else{
		alert("else...")
		$("#<portlet:namespace />attachReceipt").submit();
	}
}) 

</script>

