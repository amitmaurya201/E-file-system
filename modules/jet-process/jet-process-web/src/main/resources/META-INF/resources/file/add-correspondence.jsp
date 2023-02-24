<%@ include file="../init.jsp"%>
<%
	long userPostsValue = (long) renderRequest.getAttribute("userPostId");
	long docFileId = (Long) request.getAttribute("docFileId");
	String redirectURL = themeDisplay.getURLCurrent();	
	long fileMovementId = (long) renderRequest.getAttribute("fileMovementId");
%>

<div class="p-3">
	<portlet:actionURL var="attachReceipt" name="AttachFileCorrespondence">
	</portlet:actionURL>
	<clay:management-toolbar disabled="${receiptCount eq 0}"
		displayContext="${addCorrespondenceManagementToolbarDisplayContext}"
		itemsTotal="${receiptCount}" searchContainerId="receiptList"
		selectable="false" />
	<aui:form action="${attachReceipt}" method="post" name="attachReceipt">
		<aui:input name="docFileId" value="${docFileId }" type="hidden"></aui:input>
		<aui:input name="userPostId" value="${userPostsValue }" type="hidden"></aui:input>
		<aui:input name="redirectURL" type="hidden" value="<%=redirectURL%>" />
		<aui:input name="fileMovementId" type="hidden"
						value="<%=fileMovementId%>" />
		<liferay-ui:search-container delta="${delta}"
			emptyResultsMessage="message-record-not-found" id="receiptList"
			total="${receiptCount}"
			iteratorURL="${addCorrespondenceManagementToolbarDisplayContext._getCurrentURL()}">
			<liferay-ui:search-container-results results="${receiptFileList }" />

			<liferay-ui:search-container-row
				className="io.jetprocess.list.model.ReceiptListViewDto"
				modelVar="receiptListViewDto">

				<portlet:renderURL var="receiptDetails">
					<portlet:param name="mvcRenderCommandName"
						value="<%=MVCCommandNames.RECEIPT_DETAILS_RENDER_COMMAND%>" />
					<portlet:param name="receiptId" value="${receipt.receiptId }" />
					<portlet:param name="backPageURL" value=""></portlet:param>
				</portlet:renderURL>

				<liferay-ui:search-container-column-text>
					<aui:input type="radio"
						onchange="receiptDetail(${receiptListViewDto.isRead()},
					${receiptListViewDto.getReceiptId()},
					 ${receiptListViewDto.getReceiptMovementId()},'${receiptListViewDto.getNature()}')"
						name="receiptId" label="label-put-in-receipt"
						value="<%=receiptListViewDto.getReceiptId()%>" />
					<aui:input name="receiptMovementId" type="hidden"
						value="${receiptListViewDto.getReceiptMovementId()}" />
					
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text
					name="label-put-in-receipt-type">
					<span title="${receiptListViewDto.nature }"><%=receiptListViewDto.getNature().charAt(0)%></span>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text property="receiptNumber"
					name="label-put-in-receipt-number" />
				<liferay-ui:search-container-column-text property="subject"
					name="label-put-in-receipt-subject" cssClass="hover-tips" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator paginate="false" />
			<liferay-ui:search-paginator
				searchContainer="<%=new SearchContainer()%>" markupView="lexicon" />
		</liferay-ui:search-container>
		<c:if test="${receiptCount!= 0}">
			<aui:input label="label-put-in-receipt-remark" name="remarks" type="textarea">
				<aui:validator name="required" />
			</aui:input>
			<aui:button cssClass="btn btn-primary" id="attachForm"
				style="float: right; margin-top: 10px;" type="button" value="label-put-in-receipt-attach"></aui:button>
		</c:if>
	</aui:form>
</div>

<div class="ml-3" id="alert-read-remove"
	style="box-shadow: 0 6px 11px 0 rgb(0 0 0/ 20%); width: 300px; margin-right: 74%; margin-top: -200px;">
	<liferay-ui:error key="receipt-is-not-attachable"
		message="receipt-attach-error" />
</div>

<!-- This commented code is for future purpose. For Custom success message  -->

<%-- <div class="ml-3" id="alert-read-remove"
	style="box-shadow: 0 6px 11px 0 rgb(0 0 0/ 20%); width: 300px; margin-right: 74%; margin-top: -200px;">
	<liferay-ui:success key="pullback-available"
		message="Your Receipt is Attached successfully !" />
</div> --%>

<portlet:resourceURL id="receiptReceive" var="receiptReceiveServe">
</portlet:resourceURL>

<button type="button" id="isReadAlert" class="btn btn-primary" hidden
	data-toggle="modal" data-target="#exampleModal"></button>

<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">
					<liferay-ui:message key="label-put-in-receipt-Confirmation-heading" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<h6>
					<liferay-ui:message
						key="message-put-in-receipt-Confirmation-accept1" />
					<span id="msg"></span>
					<liferay-ui:message
						key="message-put-in-receipt-Confirmation-accept2" />
				</h6>
				<aui:form action="#" method="post" name="receiveForm">
					<aui:input name="receiptId" type="hidden"></aui:input>
					<aui:input name="rmId" type="hidden"></aui:input>
					
					<div class="float-right">
						<aui:button type="button" cssClass="btn btn-primary"
							value="label-put-in-receipt-confirmation-button"
							onclick="receiptReceive(true)"></aui:button>
						<aui:button type="button" cssClass="btn btn-primary"
							value="label-put-in-receipt-confirmation-cancel"
							data-dismiss="modal"></aui:button>
					</div>
				</aui:form>
			</div>

		</div>
	</div>
</div>
<script>
var isRead;
var receiptId;
var receiptMovementId;
var nature;

function receiptDetail(_isRead, _receiptId, _receiptMovementId,_nature){
	isRead=_isRead;
	receiptId=_receiptId;
	receiptMovementId=_receiptMovementId;
	nature=_nature;
	console.log("isRead : ",isRead,", receiptId : ",receiptId,", receiptMovementId : ",receiptMovementId,", nature : ",nature,", docFileId : ",<%=docFileId%>,", file movement id : ",<%=fileMovementId %>);
}
function validateForm(attachReceipt) {
	
	var liferayForm = Liferay.Form.get(attachReceipt);
    if (liferayForm) {
        var validator = liferayForm.formValidator;
        validator.validate();
        var hasErrors = validator.hasErrors();
        if (hasErrors) {
        	validator.focusInvalidField();
            return false;
        }
   	}
    return true;
};

$('#<portlet:namespace />attachForm').click(function(){
	
	if(receiptMovementId != null  && validateForm('<portlet:namespace/>attachReceipt')){
		if(isRead == false){
			if(nature==='Electronic'){
				let message="<liferay-ui:message key='message-put-in-receipt-confirmation-electronic'/>";
				$("#msg").text(message);
			}
			else{
				let message="<liferay-ui:message key='message-put-in-receipt-confirmation-physical'/>";
				$("#msg").text(message);
			}
			$("#<portlet:namespace />receiptId").val(receiptId);
			$("#<portlet:namespace />rmId").val(receiptMovementId);
			$('#isReadAlert').trigger('click');
		}else{
			$("#<portlet:namespace />receiptMovementId").val(receiptMovementId);
			$("#<portlet:namespace />attachReceipt").submit();
		}
	}else{
		return false;
	}
});

 function receiptReceive(accepted){
	if(accepted){
		submitAttach()
	}
}
 
 function submitAttach(){
	   	AUI().use('aui-io-request','aui-base','io', function(A){
		 var form = A.one("#<portlet:namespace/>receiveForm");
	        A.io.request('<%=receiptReceiveServe.toString()%>', {
	        	 method: 'post',
	        	 form:{
	                 id:form
	             },
	               on: {
	                    success: function() {
	                    	$("#<portlet:namespace />receiptMovementId").val(receiptMovementId);
	                    	$("#<portlet:namespace />attachReceipt").submit()
	                    }
	               }
	            });
	    });
	     } 
 
</script>

