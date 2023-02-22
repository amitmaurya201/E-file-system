<%@ include file="../init.jsp"%>
<%
HttpSession userPostId = themeDisplay.getRequest().getSession();
String userPostsValue = (String) userPostId.getAttribute("userPostId");
	long receiptId = (long) request.getAttribute("receiptId");
	long receiptMovementId = (long) renderRequest.getAttribute("receiptMovementId");
	String backPageURL = (String) request.getAttribute("backPageURL");
%>

<div class="p-3">
<portlet:resourceURL
	id="<%=MVCCommandNames.ATTACH_RECEIPT_IN_FILE_RESOURCE_COMMAND%>"
	var="closeReceiptResourceURL"> </portlet:resourceURL>
	<clay:management-toolbar disabled="${fileCount eq 0}"
		displayContext="${putInFileManagementToolbarDisplayContext}"
		itemsTotal="${fileCount}" searchContainerId="fileList"
		selectable="false" />
	<aui:form action="${attachfile}" method="post" name="attachfile">
		<liferay-ui:search-container delta="${delta}"
			emptyResultsMessage="message-record-not-found" id="fileList"
			total="${fileCount}"
			iteratorURL="${putInFileManagementToolbarDisplayContext._getCurrentURL()}">
			<liferay-ui:search-container-results results="${fileList }" />

			<liferay-ui:search-container-row
				className="io.jetprocess.list.model.FileListViewDto"
				modelVar="fileListViewDto">

			

				<liferay-ui:search-container-column-text>
					<aui:input type="radio" onchange="receiptDetail(${fileListViewDto.isRead()},${fileListViewDto.getDocFileId()}, ${fileListViewDto.getFilemovementId()},'${fileListViewDto.getNature()}')"
						name="docFileId" label="label-put-in-file"
						value="<%=fileListViewDto.getDocFileId()%>" />
					<aui:input name="fileMovementId" type="hidden"
						value="${fileListViewDto.getFilemovementId()}" />
					<aui:input name="receiptMovementId" type="hidden"
						value="<%=receiptMovementId%>" />
						<aui:input name="docFileId" type="hidden"
						value="<%=fileListViewDto.getDocFileId()%>" />
							<aui:input name="receiptId" type="hidden"
						value="<%=receiptId%>" />
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text
					name="label-put-in-file-type">
					<span title="${fileListViewDto.nature }"><%=fileListViewDto.getNature().charAt(0)%></span>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text property="fileNumber"
					name="label-put-in-file-number" />
				<liferay-ui:search-container-column-text property="subject"
					name="label-put-in-file-subject" cssClass="hover-tips" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator paginate="false" />
			<liferay-ui:search-paginator
				searchContainer="<%=new SearchContainer()%>" markupView="lexicon" />
		</liferay-ui:search-container>
		<c:if test="${fileCount!= 0}">
			<aui:input label="label-put-in-file-remark" name="remarks" type="textarea">
				<aui:validator name="required" />
			</aui:input>
			<aui:button cssClass="btn btn-primary" name="attachForm"
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

<portlet:resourceURL id="fileReceive" var="fileReceiveServe">
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
					<aui:input name="docfileId" type="hidden"></aui:input>
					<aui:input name="filemovementId" type="hidden"></aui:input>
					<div class="float-right">
						<aui:button type="button" cssClass="btn btn-primary"
							value="label-put-in-file-confirmation-button"
							onclick="fileReceive(true)"></aui:button>
						<aui:button type="button" cssClass="btn btn-primary"
							value="label-put-in-file-confirmation-cancel"
							data-dismiss="modal"></aui:button>
					</div>
				</aui:form>
			</div>

		</div>
	</div>
</div>
<script type="text/javascript">
var isRead;
var docFileId;
var fileMovementId;
var nature;

function receiptDetail(_isRead, _docFileId, _fileMovementId,_nature){
	alert(_docFileId)
	isRead=_isRead;
	docFileId=_docFileId;
	fileMovementId=_fileMovementId;
	nature=_nature;
}
function validateForm(attachfile) {
	
	var liferayForm = Liferay.Form.get(attachfile);
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
	
	if(fileMovementId != null  && validateForm('<portlet:namespace/>attachfile')){
		if(!isRead){
			if(nature==='Electronic'){
				let message="<liferay-ui:message key='message-put-in-file-confirmation-electronic'/>";
				$("#msg").text(message);
			}
			else{
				let message="<liferay-ui:message key='message-put-in-file-confirmation-physical'/>";
				$("#msg").text(message);
			}
			alert(docFileId)
			$("#<portlet:namespace />docfileId").val(docFileId);
			$("#<portlet:namespace />filemovementId").val(fileMovementId);
			$('#isReadAlert').trigger('click');
		}else{
			$("#<portlet:namespace />fileMovementId").val(fileMovementId);
			/ $("#<portlet:namespace />attachfile").submit(); /
			submitCloseReceiptPopUP();
		}
		
	}else{
		return false;
	}
});

 function fileReceive(accepted){
	if(accepted){
		submitAttach()
	}
}
  
 function submitAttach(){
	   	AUI().use('aui-io-request','aui-base','io', function(A){
		 var form = A.one("#<portlet:namespace/>receiveForm");
	        A.io.request('<%=fileReceiveServe.toString()%>', {
	        	 method: 'post',
	        	 form:{
	                 id:form
	             },
	               on: {
	                    success: function(data) {
	                    	$("#<portlet:namespace />fileMovementId").val(fileMovementId);
	                    	/ $("#<portlet:namespace />attachfile").submit(); /
	                    	 submitCloseReceiptPopUP(); 
	                    	
	                    } 
	             
	            }
	    });
	     });
}
	
 function submitCloseReceiptPopUP(){
			$("#<portlet:namespace />docFileId").val(docFileId);
		if(validateForm('<portlet:namespace/>attachfile')){
			AUI().use('aui-io-request','aui-base','io', function(A){
				var form = A.one("#<portlet:namespace/>attachfile");
				     A.io.request('<%=closeReceiptResourceURL.toString()%>', {
					method : 'post',
					form : {
						id : form
					},
					on : {
						success : function() {
							swal({
								text : this.get('responseData'),
							});
							setTimeout(parent.location.href = '<%=backPageURL%>', 1500);
							
							
						}
					}
				});
			});
		}
		else {
			return false;
		}
	}
	
 
 
</script>

