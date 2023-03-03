
<%
	long corrFileId = (long) renderRequest.getAttribute("putInFileId");
	String redirectURL = themeDisplay.getURLCurrent();
%>
<style>
.three-dots {
marging:0px;
padding:0px;
	width: 20px;
	height: 25px;
	background-image: radial-gradient(circle, #616161 3px, transparent 3px);
	background-size: 110% 33.33%;
}

.modal-box {
	display: none;
	position: fixed;
	top: 50% !important;
	left: 50% !important;
	transform: translate(-50%, -50%) !important;
	margin:10px;
	padding:10px;
	z-index: 1000;
	width:500px !important ;
	background: white;
	border-bottom: 1px solid #aaa;
	border-radius: 4px;
	box-shadow: 0 3px 9px rgba(0, 0, 0, 0.5);
	border: 1px solid rgba(0, 0, 0, 0.1);
	background-clip: padding-box;
}

.modal-box header, .modal-box .modal-header {
	
	padding: .25em .5em;
	
}

.modal-box header h3, .modal-box header h4, .modal-box .modal-header h3,
	.modal-box .modal-header h4 {
	margin: 0;
	
}

.modal-box .modal-body {
	padding: 2em 1.5em;
}

.modal-box footer, .modal-box .modal-footer {
	padding: 1em;
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
	color: black;
}

a.close:hover {
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
	<portlet:param name="docFileId"
		value="<%=String.valueOf(docFile.getDocFileId())%>" />

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

				<liferay-ui:search-container-column-text
					name="detach-action-heading">
					<aui:button cssClass="btn btn-primary detach-btn-disabled"
						name="detach-btn"
						onclick="detachFun(${fileCorrespondenceReceiptDTO.receiptId }, ${fileCorrespondenceReceiptDTO.receiptMovementId }, ${fileCorrespondenceReceiptDTO.isDetachable() })"
						type="button" value="detach-button"></aui:button>
				</liferay-ui:search-container-column-text>


				<liferay-ui:search-container-column-text name="Actions">
					<!-- <div class="three-dots"></div> -->
					
					<div class="dropdown">
  <a class="three-dots nav-link dropdown-toggle"  id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    
  </a>
  <div class="dropdown-menu " aria-labelledby="dropdownMenu2">
    <button class="dropdown-item js-open-modal" type="button" onclick="detachFun(${fileCorrespondenceReceiptDTO.receiptId }, ${fileCorrespondenceReceiptDTO.receiptMovementId }, ${fileCorrespondenceReceiptDTO.isDetachable() })">Detach</button>
    <button class="dropdown-item js-open-modal" type="button" onclick="reopenReceiptFun(${fileCorrespondenceReceiptDTO.receiptId }, ${fileCorrespondenceReceiptDTO.receiptMovementId }, ${fileCorrespondenceReceiptDTO.isDetachable() })">Reopen</button>
    <button class="dropdown-item js-open-modal" type="button" onclick="closeFun(${fileCorrespondenceReceiptDTO.receiptId }, ${fileCorrespondenceReceiptDTO.receiptMovementId }, ${fileCorrespondenceReceiptDTO.isDetachable() })">Close</button>
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
		<h3>Detach Receipt</h3>
	</header>
	<aui:form action="#" method="post" name="detachReceiptForm">
	<div class="modal-body">
		
			<aui:input name="receiptId" type="hidden"></aui:input>
			<aui:input name="rmId" type="hidden"></aui:input>
			<aui:input name="redirectURL" type="hidden" value="<%=redirectURL%>"></aui:input>
			<span >Remarks<span style="color:red;">*</span></span>
			<aui:input label="" name="remarks" type="textarea">
				<aui:validator name="required" />
			</aui:input>
			
		
	</div>
	<footer>
		
		<div class="float-right">
				<div class="float-right">
				<aui:button type="button" cssClass="btn btn-primary"
					value="label-detach-confirmation-button"
					onclick="receiptDetach(true)"></aui:button>
				<aui:button type="button" id="close-btn"
					cssClass="btn btn-primary ml-2 js-modal-close"
					value="label-detach-confirmation-cancel" data-dismiss="modal"
					onclick="close"></aui:button>
			</div>
			
			</div>
	</footer>
	
	</aui:form>
</div>



<!--  --------------- Receipt Close ----------------   -->

<portlet:resourceURL
	id="<%=MVCCommandNames.CLOSE_RECEIPT_RESOURCE_COMMAND %>"
	var="closeReceiptResourceURL">
</portlet:resourceURL>
	

<div id="closePopup" class="modal-box">
	<header>
		<a href="#" class="js-modal-close close"  >&times;	</a>
		<h3>Close</h3>
	</header>
	<aui:form action="#" method="post" name="closeReceiptForm">
	<div class="modal-body">
		
			<aui:input name="closeReceiptId"  type="hidden" ></aui:input>
			<aui:input name="closeRmid"  type="hidden" ></aui:input>
			<aui:input name="userPostId" value="<%=userPostsVal%>" type="hidden"></aui:input>
			<span >Remarks<span style="color:red;">*</span></span>
			<aui:input label="" name="closingRemarks" type="textarea">
				<aui:validator name="required" />
			</aui:input>
			
		
	</div>
		<footer>
		<div class="float-right">
				<aui:button type="button" cssClass="btn btn-primary"
					value="label-detach-confirmation-button" onclick="receiptClose()"></aui:button>
				<aui:button type="button" 
					cssClass="btn btn-primary ml-2"
					value="label-detach-confirmation-cancel" data-dismiss="modal"
					onclick="close"></aui:button>
			</div>
	</footer>
	</aui:form>
</div>


<!--  --------------- Receipt Open ----------------   -->

<portlet:resourceURL
	id="<%=MVCCommandNames.REOPEN_RECEIPT_RESOURCE_COMMAND%>"
	var="reopenReceiptResourceURL"> </portlet:resourceURL>

<div id="reopenPopup" class="modal-box">
	<header>
		<a href="#" class="js-modal-close close">&times;</a>
		<h3>Reopen</h3>
	</header>
		<aui:form action="#" method="post" name="reopenReceipt">
	<div class="modal-body">
			
			<aui:input type="hidden" name="reopenReceiptId"  />
			<aui:input type="hidden" name="reopenReceiptMovementId"  />
			<aui:input  type="hidden" name="userPostId" value="<%=userPostsVal%>"/>
			
		 	<aui:input label="label-reopenreceipt-remark" name="reopenRemarks" id="reopenRemarks"
					type="textarea" style="height:70px;">
					<aui:validator name="required"></aui:validator>
					<aui:validator name="maxLength">
						<liferay-ui:message key="receipt-reopen-remarks-maxlength" />
					</aui:validator>
				</aui:input>
			
	</div>
	<footer>
		<div class="float-right">
				<aui:button type="button" cssClass="btn btn-primary"
					value="label-detach-confirmation-button"
					onclick="receiptReopen(true)"></aui:button>
				<aui:button type="button" id="close-btn"
					cssClass="btn btn-primary ml-2 js-modal-close"
					value="label-detach-confirmation-cancel" data-dismiss="modal"
					onclick="close"></aui:button>
			</div>
	</footer>
		</aui:form>
</div>
 


<a class="js-open-modal" id="detachId" hidden data-modal-id="popup">
	Detach</a>
<a class="js-open-modal" id="reopenReceiptPopup" hidden data-modal-id="reopenPopup"> Reopen</a>
<a class="js-open-modal"  id="closeReceiptPopup" hidden data-modal-id="closePopup"> Close</a>



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
	
	
	
	function detachFun(receiptId, receiptMovementId, isDetachable){
		console.table(receiptId,receiptMovementId, isDetachable )
		if(isDetachable){
			$("#<portlet:namespace />receiptId").val(receiptId);
			$("#<portlet:namespace />rmId").val(receiptMovementId);
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
	
	function closeFun(receiptId, receiptMovementId, isDetachable){
		console.table(receiptId,receiptMovementId, isDetachable )
		if(isDetachable){
			$("#<portlet:namespace />closeReceiptId").val(receiptId);
			$("#<portlet:namespace />closeRmid").val(receiptMovementId);
			$('#closeReceiptPopup').trigger('click');
		}else{
					swal( {
                          title: "Not Detachable",
                          text: 'Receipt cannot be detached as it was put in previous movement',
                          icon: "warning",
                          button: "Ok"
                      })
		}
		
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
		            		   alert("success");
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
	
	function reopenReceiptFun(receiptId, receiptMovementId, isDetachable){
		console.table(receiptId,receiptMovementId, isDetachable )
		if(isDetachable){
		 	$("#<portlet:namespace />reopenReceiptId").val(receiptId);
			$("#<portlet:namespace />reopenReceiptMovementId").val(receiptMovementId); 
			$('#reopenReceiptPopup').trigger('click');
		}else{
					swal( {
                          title: "Not Detachable",
                          text: 'Receipt cannot be detached as it was put in previous movement',
                          icon: "warning",
                          button: "Ok"
                      })
		}
		
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
		            		   alert("success");
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
		$("body").append(appendthis);
		$(".modal-overlay").fadeTo(500, 0.7);
		//$(".js-modalbox").fadeIn(500);
		var modalBox = $(this).attr('data-modal-id');
		$("#" + modalBox).fadeIn($(this).data());
	});

	$(".js-modal-close, .modal-overlay").click(function() {
		$(".modal-box, .modal-overlay").fadeOut(500, function() {
			$(".modal-overlay").remove();
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
