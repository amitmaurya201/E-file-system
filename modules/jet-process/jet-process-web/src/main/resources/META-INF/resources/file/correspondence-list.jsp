
<%@page import="io.jetprocess.model.DocFile"%>
<%
	long corrFileId = (long) renderRequest.getAttribute("putInFileId");
	System.out.println("corrFileId------" + corrFileId);

	long docFileId = (long) renderRequest.getAttribute("docFileId");
	System.out.println("docFileId------" + docFileId);

	String redirectURL = themeDisplay.getURLCurrent();
%>
<style>
.conformation-icon {
	width: 5vw;
	height: 5vh;
	color: #007bff;
}

.btn {
	border: none !important;
	color: #FFFFFF !important;
}

.btn-secondary {
	border: 1px solid #007bff !important;
	border-radius: 0px;
	background-color: white !important;
	color: #007bff !important;
}

.btn-secondary:hover {
	border: 1px solid #007bff !important;
	background-color: #007bff !important;
	color: #FFFFFF !important;
}

.dropdown-item:hover {
	background-color: #e6f3fa;
	color: black;
	border: 1px solid #39aeed;
}

.three-dots {
	marging: 0px;
	padding-left: 40px;
	width: 20px;
	height: 21px;
	background-image: radial-gradient(circle, #343a40 2px, transparent 2px);
	background-size: 110% 34.33%;
}

.modal-box {
	display: none;
	position: fixed;
	top: 40% !important;
	left: 50% !important;
	transform: translate(-50%, -50%) !important;
	margin: 10px;
	padding-top: 0px;
	padding-bottom: 10px;
	z-index: 1000;
	width: 500px !important;
	height: 510px !important;
	background: white;
	border-bottom: 1px solid #aaa;
	border-radius: 4px;
	box-shadow: 0 3px 9px rgba(0, 0, 0, 0.5);
	border: 1px solid rgba(0, 0, 0, 0.1);
	background-clip: padding-box;
}

.modal-box header, .modal-box .modal-header {
	background-color: #007bff;
	padding: 1.25em 1.5em;
}

.modal-box header h3, .modal-box header h4, .modal-box .modal-header h3,
	.modal-box .modal-header h4 {
	color: #FFFFFF;
	margin: 0;
}

.modal-box .modal-body {
	/* padding: 2em 1.5em; */
	
}

.modal-box footer, .modal-box .modal-footer {
	padding: 1.25em 1.5em;
	padding-bottom: 1.5em;
	border-top: 1px solid #ddd;
	/* background: rgba(0, 0, 0, 0.06); */
	text-align: right;
}

.modal-overlay {
	opacity: 0;
	filter: alpha(opacity = 0);
	position: absolute;
	top: 0;
	left: 0;
	z-index: 900;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.3) !important;
}

a.close {
	line-height: 1;
	font-size: 1.5em;
	position: absolute;
	top: 5%;
	right: 2%;
	text-decoration: none;
	color: #FFFFFF;
}

a.close:hover {
	color: #FFFFFF;
	-webkit-transition: color 1s ease;
	-moz-transition: color 1s ease;
	transition: color 1s ease;
}

@media ( min-width : 32em) {
	.modal-box {
		width: 70%;
	}
}

.nav-item .dropdown-menu a {
	marging: 10px;
	display: block !important;
	cursor: pointer;
}

.lfr-search-container-wrapper
 
a
:not
 
(
.component-action
 
)
:not
 
(
.btn
 
)
{
color
:
 
#000000
;


}
.modal .close:last-child {
	margin-right: -0.3125rem;
	font-size: 1.5rem;
}

.crList th {
	display: inline-block;
	width: max-content;
}

.dropbtn {
	color: white;
	padding: 16px;
	font-size: 16px;
	border: none;
}

.dropdown {
	position: relative;
	display: inline-block;
	float: right;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.put-heading {
	background-color: #96b4d6;
	color: white;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #3e8e41;
}
</style>
<portlet:renderURL var="fileInnerViewPopup"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.CORRESPONCE_FILE_RENDER%>" />
	<portlet:param name="fileMovementId"
		value="<%=String.valueOf(fileMovementId)%>" />
	<portlet:param name="docFileId1" value="<%=String.valueOf(docFileId)%>" />

</portlet:renderURL>



<portlet:renderURL var="correspondencesinfoViewPopup"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.CORRESPONDENCES_INFO_RENDER_COMMAND%>" />
</portlet:renderURL>

<portlet:renderURL var="receiptDetailsPopup"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.RECEIPT_DETAIL_RENDER_COMMAND%>" />
</portlet:renderURL>

<portlet:actionURL var="detachReceipt"
	name="<%=MVCCommandNames.DETACH_RECEIPT%>">
</portlet:actionURL>

<div class="row">
	<div class="col-md-12" style="font-size: 18px">
		<text class="pr-4 float-left put-heading"
			style="border-radius:0px 100px 0px 0px; "> <liferay-ui:message
			key="corr-list-heading" /> </text>
		<div class="pl-2 pr-2 dropdown float-right put-heading"
			style="border-radius: 100px 0px 0px 100px;">
			<i class="fa fa-bars "><liferay-ui:message
					key="corr-list-toc-heading" /></i>
			<div class="dropdown-content">
				<a href="#">Link 1</a> <a href="#">Link 2</a> <a href="#">Link 3</a>
			</div>

		</div>
	</div>

	<div class="col-md-12">
		<liferay-ui:search-container total="${fileCorrespondenceCount }"
			delta="${delta }" deltaConfigurable="true"
			iteratorURL="${fileCorrespondenceManagementToolbarDisplayContext._getCurrentURL()}"
			emptyResultsMessage="message-record-not-found">
			<liferay-ui:search-container-results results="${fileCorrespondence}" />

			<liferay-ui:search-container-row
				className="io.jetprocess.list.model.FileCorrespondenceReceiptDTO"
				modelVar="fileCorrespondenceReceiptDTO">
				<liferay-ui:search-container-column-text>
					<a class="Info"
						onclick="infoPopup(${fileCorrespondenceReceiptDTO.receiptId }, ${fileCorrespondenceReceiptDTO.receiptMovementId })">
						<i class="fa fa-info-circle"
						style="color: blue; font-size: 16px; cursor: help"></i>
					</a>
				</liferay-ui:search-container-column-text>
				<liferay-ui:search-container-column-text><%=fileCorrespondenceReceiptDTO.getNature().charAt(0)%></liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text
					name="label-receipt-list-receiptno" cssClass="hyperlink-css"
					orderable="true" orderableProperty="receiptNo">
					<a class="Info"
						onclick="receiptDetailPopup(${fileCorrespondenceReceiptDTO.receiptId })"
						style="cursor: pointer">
						${fileCorrespondenceReceiptDTO.receiptNumber } </a>

				</liferay-ui:search-container-column-text>

				<liferay-ui:search-container-column-text property="subject"
					cssClass="hover-tips" name="label-receipt-list-subject" />

				<liferay-ui:search-container-column-text
					name="corr-info-detail-label-receipt-type"
					property="correspondenceType" />

				<liferay-ui:search-container-column-text
					name="corr-info-detail-label-receipt-attached-on"
					value="<%=simpleformat.format(fileCorrespondenceReceiptDTO.getCreateDate())%>"
					orderable="true" orderableProperty="attachOn" />

				<liferay-ui:search-container-column-text
					name="label-receipt-list-remark" property="remark"
					cssClass="hover-tips" />
					



				<liferay-ui:search-container-column-text name="Actions">
					<!-- <div class="three-dots"></div> -->

					<div class="dropdown">
						<a class="three-dots nav-link dropdown-toggle" id="dropdownMenu2"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">

						</a>
						<div class="dropdown-menu " aria-labelledby="dropdownMenu2">


							<c:choose>
								<c:when test="${fileCorrespondenceReceiptDTO.isClosed()}">
									<c:set var="isOpen" value=""></c:set>
									<c:set var="isClosed" value="disabled"></c:set>
								</c:when>
								<c:otherwise>
									<c:set var="isOpen" value="disabled"></c:set>
									<c:set var="isClosed" value=""></c:set>
								</c:otherwise>
							</c:choose>
							<button class="dropdown-item js-open-modal ${isOpen }"
								type="button"
								onclick="detachFun(${fileCorrespondenceReceiptDTO.receiptId }, ${fileCorrespondenceReceiptDTO.receiptMovementId }, ${fileCorrespondenceReceiptDTO.isDetachable()}, '${fileCorrespondenceReceiptDTO.receiptNumber }')">
								<liferay-ui:message key="label-corr-detach" />
							</button>
							<button class="dropdown-item js-open-modal ${isClosed }"
								type="button"
								onclick="reopenReceiptFun(${fileCorrespondenceReceiptDTO.receiptId }, ${fileCorrespondenceReceiptDTO.receiptMovementId }, '${fileCorrespondenceReceiptDTO.receiptNumber }')">
								<liferay-ui:message key="label-corr-reopen" />
							</button>
							<button class="dropdown-item js-open-modal ${isOpen }"
								type="button"
								onclick="closeFun(${fileCorrespondenceReceiptDTO.receiptId }, ${fileCorrespondenceReceiptDTO.receiptMovementId }, '${fileCorrespondenceReceiptDTO.receiptNumber }')">
								<liferay-ui:message key="label-corr-close" />
							</button>


						</div>
					</div>

				</liferay-ui:search-container-column-text>


			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator paginate="false" />
			<liferay-ui:search-paginator
				searchContainer="<%=new SearchContainer()%>" markupView="lexicon" />
		</liferay-ui:search-container>

		<div class="float-right mt-3">
			<aui:button cssClass="btn btn-primary" name="add_receipt"
				id="add_receipt" value="label-add-receipt-corr-list">
			</aui:button>
		</div>
	</div>

</div>






<portlet:resourceURL id="detachReceipt"
	var="detachReceiptResourceCommand">
</portlet:resourceURL>

<!--  --------------- Receipt Detach ----------------   -->

<div id="popup" class="modal-box">
	<header>
		<a href="#" class="js-modal-close close">&times;</a>
		<h4>
			<liferay-ui:message key="heading-corr-in-file-Confirmation" />
		</h4>
	</header>
	<aui:form action="#" method="post" name="detachReceiptForm">
		<div class="modal-body">
			<div class="text-center">
				<%-- <img alt="reopen-file" title="Reopen"
							id='<portlet:namespace/>reopen-file'
							src='<%=request.getContextPath() + "/image/detach.png"%>'
							width="50px" height="50px"  /> --%>
				<h5>
					<liferay-ui:message key="title-corr-detach" />
				</h5>
				<P>
					<liferay-ui:message key="message-corr-detach" />
					<span class="receiptNumber font-weight-bold"></span>
				</P>
			</div>
			<hr>
			<aui:input type="hidden" name="receiptId"></aui:input>
			<aui:input type="hidden" name="receiptMovId"></aui:input>
			<aui:input type="hidden" name="redirectURL" value="<%=redirectURL%>"></aui:input>
			<span><liferay-ui:message key="label-corr-remarks" /><span
				style="color: red;">*</span></span>
			<aui:input type="textarea" name="remarks" label="">
				<aui:validator name="required" />
				<aui:validator name="maxLength">
					<liferay-ui:message key="label-corr-remarks-maxlength" />
				</aui:validator>
			</aui:input>


		</div>
		<footer>

			<div class="float-right">
				<div class="float-right">
					<aui:button type="button" cssClass=""
						value="label-detach-confirmation-button"
						onclick="receiptDetach(true)"></aui:button>
					<aui:button type="button" id="close-btn"
						cssClass=" ml-2 js-modal-close"
						value="label-detach-confirmation-cancel" data-dismiss="modal"
						onclick="close"></aui:button>
				</div>

			</div>
		</footer>

	</aui:form>
</div>



<!--  --------------- Receipt Close ----------------   -->

<portlet:resourceURL
	id="<%=MVCCommandNames.CLOSE_RECEIPT_RESOURCE_COMMAND%>"
	var="closeReceiptResourceURL">
</portlet:resourceURL>


<div id="closePopup" class="modal-box">
	<header>
		<a href="#" class="js-modal-close close">&times; </a>
		<h4>
			<liferay-ui:message key="heading-corr-in-file-Confirmation" />
		</h4>
	</header>
	<aui:form action="#" method="post" name="closeReceiptForm">
		<div class="modal-body">
			<div class="text-center">
				<%-- <img alt="reopen-file" title="Reopen"
							id='<portlet:namespace/>reopen-file'
							src='<%=request.getContextPath() + "/image/close.png"%>'
							width="50px" height="50px"  /> --%>
				<h5>
					<liferay-ui:message key="title-corr-close" />
				</h5>
				<P>
					<liferay-ui:message key="message-corr-close" />
					<span class="receiptNumber font-weight-bold"></span>
				</P>
			</div>
			<hr>
			<aui:input type="hidden" name="closeReceiptId"></aui:input>
			<aui:input type="hidden" name="rmId"></aui:input>
			<aui:input type="hidden" name="userPostId" value="<%=userPostsVal%>"></aui:input>
			<span><liferay-ui:message key="label-corr-remarks" /><span
				style="color: red;">*</span></span>
			<aui:input type="textarea" name="closingRemarks" label="">
				<aui:validator name="required" />
				<aui:validator name="maxLength">
					<liferay-ui:message key="label-corr-remarks-maxlength" />
				</aui:validator>
			</aui:input>


		</div>
		<footer>
			<div class="float-right">
				<aui:button type="button" cssClass="btn"
					value="label-detach-confirmation-button" onclick="receiptClose()"></aui:button>
				<aui:button type="button" cssClass="ml-2 js-modal-close"
					value="label-detach-confirmation-cancel" data-dismiss="modal"
					onclick="close"></aui:button>

			</div>
		</footer>
	</aui:form>
</div>


<!--  --------------- Receipt Open ----------------   -->

<portlet:resourceURL
	id="<%=MVCCommandNames.CORR_RECEIPT_REOPEN_RESOURCE_COMMAND%>"
	var="reopenReceiptResourceURL">
</portlet:resourceURL>

<div id="reopenPopup" class="modal-box">
	<header>
		<a href="#" class="js-modal-close close">&times;</a>
		<h4>
			<liferay-ui:message key="heading-corr-in-file-Confirmation" />
		</h4>
	</header>
	<aui:form action="#" method="post" name="reopenReceipt">
		<div class="modal-body">
			<div class="text-center">
				<!-- style="border:2px solid #007bff; padding:5px; border-radius:50%;" -->
				<%-- <img alt="reopen-file" title="Reopen"
							id='<portlet:namespace/>reopen-file'
							src='<%=request.getContextPath() + "/image/reopen-image.png"%>'
							width="50px" height="50px"  /> --%>
				<h5>
					<liferay-ui:message key="title-corr-reopen" />
				</h5>
				<P>
					<liferay-ui:message key="message-corr-reopen" />
					<span class="receiptNumber font-weight-bold"></span>
				</P>
			</div>
			<hr>

			<aui:input type="hidden" name="reopenReceiptId" />
			<aui:input type="hidden" name="closedReceiptId" />
			<aui:input type="hidden" name="userPostId" value="<%=userPostsVal%>" />
			<span><liferay-ui:message key="label-corr-remarks" /> <span
				style="color: red;">*</span></span>
			<aui:input label="" name="reopenRemarks" id="reopenRemarks"
				type="textarea">
				<aui:validator name="required"></aui:validator>
				<aui:validator name="maxLength">
					<liferay-ui:message key="label-corr-remarks-maxlength" />
				</aui:validator>
			</aui:input>

		</div>
		<footer>
			<div class="float-right">
				<aui:button type="button" cssClass="btn "
					value="label-detach-confirmation-button" onclick="receiptReopen()"></aui:button>
				<aui:button type="button" cssClass="ml-2 js-modal-close"
					value="label-detach-confirmation-cancel" data-dismiss="modal"
					onclick="close"></aui:button>


			</div>
		</footer>
	</aui:form>
</div>

<div class="float-right"></div>


<!-- ************************* Jquery Popup button. these button are trigged by js  ****************************  -->
<a class="js-open-modal" id="detachId" hidden data-modal-id="popup"></a>
<a class="js-open-modal" id="reopenReceiptPopup" hidden
	data-modal-id="reopenPopup"> </a>
<a class="js-open-modal" id="closeReceiptPopup" hidden
	data-modal-id="closePopup"> </a>



<!-- ---------------------- succes message  ----------------------------->
<div class="portlet-msg-success"
	style="display: none; bottom: 20px; left: 20px; position: fixed; z-index: 5000; border: 1px solid green; width: 350px; height: 80px; font-size: 1rem;"
	id="successMsg">
	<liferay-ui:message key="label-detach-success-message"></liferay-ui:message>

</div>

<aui:script use="liferay-util-window">	

var viewMode = "${param.viewMode}";
if (viewMode == 'ViewModeFromSentFile') {
		$('#<portlet:namespace />add_receipt').addClass('disabled');
		$('.dropdown-content').css("display", "none");
		$('.detach-btn-disabled').addClass("disabled");
}

$("#<portlet:namespace />add_receipt").click(()=>{
var title="<liferay-ui:message key='title-corr-put-in-receipt' />";
	Liferay.Util.openWindow({ 
		dialog: { 														 
			height: 800,														 
			destroyOnClose: true,														 
			destroyOnHide: true, 														 
			modal: true, 														 
			width: 900,
			on: {
            	destroy: function() { 
                	parent.location.reload();                   
            	}
		 	}													 
		}, 														 
		id: '<portlet:namespace />dialog',														 
		title:title , 														 
		uri: '<%=fileInnerViewPopup%>&<portlet:namespace />corrFileId=<%=corrFileId%>',			
	});
});		
</aui:script>

<script>




function infoPopup(receiptId, receiptMovementId){
	var title="<liferay-ui:message key='title-corr-receiptDetailPopup'/>";
	Liferay.Util.openWindow({ 
		dialog: { 														 
			height: 550,														 
			destroyOnClose: true,														 
			destroyOnHide: true, 														 
			modal: true, 														 
			width: 1200,
			on: {
          		destroy: function() { 
               		parent.location.reload();   
               		}
			}
		},											
		id: '<portlet:namespace />dialog',														 
		title: title, 														 
		uri: '<%=correspondencesinfoViewPopup%>&<portlet:namespace />receiptId='+receiptId+'&<portlet:namespace />receiptMovementId='+receiptMovementId+'&<portlet:namespace/>corrFileId=<%=corrFileId%>',			
	});
}
	
function receiptDetailPopup(receiptId){
	var title="<liferay-ui:message key='title-corr-receiptDetailPopup'/>";
	Liferay.Util.openWindow({ 
		dialog: { 														 
			height: 550,														 
			destroyOnClose: true,														 
			destroyOnHide: true, 														 
			modal: true, 														 
			width: 1200,
			on: {
	        	destroy: function() { 
	           		parent.location.reload();                   
	       	 	}
	      	}													 
		}, 														 
		id: '<portlet:namespace />dialog',														 
		title: title, 														 
		uri: '<%=receiptDetailsPopup%>&<portlet:namespace />receiptId='+receiptId+'&<portlet:namespace/>corrFileId=<%=corrFileId%>',			
		});	  
	}
	
	
	
	function detachFun(receiptId, receiptMovementId, isDetachable,receiptNumber){
		alert(receiptNumber);
		console.table(receiptId,receiptMovementId, isDetachable )
		if(isDetachable){
			$("#<portlet:namespace />receiptId").val(receiptId);
			$("#<portlet:namespace />receiptMovId").val(receiptMovementId);
			$(".receiptNumber").text(" - "+receiptNumber);
			$('#detachId').trigger('click');
		}else{
					swal( {
                          title: "Not Detachable",
                          text: 'Receipt cannot be detached as it was put in previous movement',
                          icon: "warning",
                          button: "Ok"
                      })
		}
		
	}
	
	
	function receiptDetach(accepted){
			if(validateForm('<portlet:namespace/>detachReceiptForm')){
				AUI().use('aui-io-request','aui-base','io', function(A){
					 var form = A.one("#<portlet:namespace/>detachReceiptForm");
				        A.io.request('<%=detachReceiptResourceCommand.toString()%>', {
				        	 method: 'post',
				        	 form:{
				                 id:form
				             },
				               on: {
				            	   success: function() { 
				            		   document.getElementById("successMsg").style.display="block";
				   	           		setTimeout(function (){
				   	           			parent.location.reload(); 
				   	           		}, 1000)  
				   	       	 	}
				            	  
				               }
				            });
				    });
			}else{
				return false;
			}
		
		   
	}
	
	
	/* ******************* Close Rceipt  **********************  */
	
	function closeFun(receiptId, receiptMovementId,  receiptNumber){
		alert(receiptNumber);
			$("#<portlet:namespace />closeReceiptId").val(receiptId);
			$("#<portlet:namespace />rmId").val(receiptMovementId);
			$(".receiptNumber").text(" - "+receiptNumber);
			$('#closeReceiptPopup').trigger('click');
				
	}
	
	function receiptClose(){
	if(validateForm('<portlet:namespace/>closeReceiptForm')){
		AUI().use('aui-io-request','aui-base','io', function(A){
			 var form = A.one("#<portlet:namespace/>closeReceiptForm");
		        A.io.request('<%=closeReceiptResourceURL.toString()%>', {
		        	 method: 'post',
		        	 form:{
		                 id:form
		             },
		               on: {
		            	   success: function() { 
		            		   document.getElementById("successMsg").style.display="block";
		   	           		setTimeout(function (){
		   	           			parent.location.reload(); 
		   	           		}, 1000)  
		   	       	 	}
		            	  
		               }
		            });
		    });
	}else{
		return false;
	}
}
	
	
	
	/* *******************************  Receipt Reopen   ******************************  */
	
	function reopenReceiptFun(receiptId, receiptMovementId, receiptNumber){
		
		console.log(receiptId,receiptMovementId, receiptNumber);
		 	$("#<portlet:namespace />reopenReceiptId").val(receiptId);
			$("#<portlet:namespace />closedReceiptId").val(receiptMovementId); 
		 $(".receiptNumber").text(" - "+receiptNumber); 
			$('#reopenReceiptPopup').trigger('click');
		
	}
	
	function receiptReopen(){
	if(validateForm('<portlet:namespace/>reopenReceipt')){
		AUI().use('aui-io-request','aui-base','io', function(A){
			 var form = A.one("#<portlet:namespace/>reopenReceipt");
		        A.io.request('<%=reopenReceiptResourceURL.toString()%>', {
		        	 method: 'post',
		        	 form:{
		                 id:form
		             },
		               on: {
		            	   success: function() { 
		            		   document.getElementById("successMsg").style.display="block";
		   	           		setTimeout(function (){
		   	           			parent.location.reload(); 
		   	           		}, 1000)  
		   	       	 	}
		            	  
		               }
		            });
		    });
	}else{
		return false;
	}
}
	
	
	
	/*  **************** Liferay Form Validator  ******************* */
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
	
	$('#modal').on('hidden.bs.modal', function () {
	    $(this).find('form').trigger('reset');
	})
	
	
	
	
	
	/* ******************* Jquery Popup **************************  */
	
	$(function() {

	var appendthis = ("<div class='modal-overlay js-modal-close'></div>");

	$("a[data-modal-id]").click(function(e) {
		e.preventDefault();
		$('body').css('overflow', 'hidden');
		$("body").append(appendthis);
		$(".modal-overlay").fadeTo(500, 0.7);
		//$(".js-modalbox").fadeIn(500);
		var modalBox = $(this).attr('data-modal-id');
		$("#" + modalBox).fadeIn($(this).data());
	});

	$(".js-modal-close, .modal-overlay").click(function() {
		
		$(".modal-box, .modal-overlay").fadeOut(500, function() {
			$(".modal-overlay").remove();
			$('body').css('overflow', 'scroll');
			$(this).find('form').trigger('reset');
		});
	});

	$(window).resize(function() {
		$(".modal-box").css({
			top: ($(window).height() - $(".modal-box").outerHeight()) / 2,
			left: ($(window).width() - $(".modal-box").outerWidth()) / 2
		});
	});

	$(window).resize();

});
	
	
</script>
