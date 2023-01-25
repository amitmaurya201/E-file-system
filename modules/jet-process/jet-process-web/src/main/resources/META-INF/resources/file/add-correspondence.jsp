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
					 ${aReceiptListViewDto.getReceiptMovementId()},'${aReceiptListViewDto.getNature()}')" 
					name="receipt"
					value="<%=aReceiptListViewDto.getReceiptId()%>" />
					<aui:input name="receiptMovementId" type="hidden" value="${aReceiptListViewDto.getReceiptMovementId()}" />
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


<div class="ml-3" id="alert-read-remove"
	style="box-shadow: 0 6px 11px 0 rgb(0 0 0/ 20%); width: 300px; margin-right: 74%; margin-top: -200px;">
	<liferay-ui:error key="receipt-is-not-attachable"
		message="This Receipt is not attachable" />
</div>


	<portlet:resourceURL id="receiptReceive" var="receiptReceiveServe">
</portlet:resourceURL>

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
				<h6>Do you want to mark as <span id="msg"></span> continue</h6>
				<aui:form action="#"  method="post"
					name="receiveForm">
					<aui:input name="receiptId"  type="hidden"></aui:input>
					<aui:input name="rmId" type="hidden"></aui:input>
					<aui:button type="button" cssClass="btn btn-secondary"
					value="No" data-dismiss="modal" ></aui:button>
					<aui:button type="button" cssClass="btn btn-primary" value="Yes" onclick="receiptReceive(true)" ></aui:button>
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
	console.log(isRead+" : "+receiptId+" : "+receiptMovementId+", nature : "+nature)
}


$('#<portlet:namespace />attachForm').click(function(){
	console.log(isRead+" -:- "+receiptId+" -:- "+receiptMovementId)
	if(isRead == false){
		if(nature==='Electronic'){
			$("#msg").text('Read');
		}
		else{
			$("#msg").text('Receive');
		}
		$("#<portlet:namespace />receiptId").val(receiptId);
		$("#<portlet:namespace />rmId").val(receiptMovementId);
		$('#isReadAlert').trigger('click');
	}else{
		$("#<portlet:namespace />attachReceipt").submit();
	}
});


 function receiptReceive(accepted){
	

	if(accepted){
		submitAttach()
		/* 
		$("#<portlet:namespace />receiveForm").submit();
		alert("after receiveForm");
		$("#<portlet:namespace />attachReceipt").submit();
		alert("after attachReceipt"); */
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
	                    	$("#<portlet:namespace />attachReceipt").submit()
	                    }
	               }
	            });
	    });
		
		
		
	     } 
 
 
 
 
</script>

