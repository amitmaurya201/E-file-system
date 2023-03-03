<%@ include file="../init.jsp"%>


<style>
.btn{

    background-color: #007bff !important;
    color: white;
    border-color: #007bff !important;
}

html:not(#__):not(#___) .cadmin .modal-header, html:not(#__):not(#___) .cadmin.modal-header {

background-color: #007bff !important; 
}
html:not(#__):not(#___) .cadmin .modal-title {
color: white !important;
}
html:not(#__):not(#___) .cadmin .lexicon-icon {
color: white !important;
}

</style>
<%
   

long receiptId = (long) renderRequest.getAttribute("receiptId");
long rmId = (long) renderRequest.getAttribute("rmId");
String backPageURL = (String)renderRequest.getAttribute("backPageURL");
%>
 
 
<portlet:resourceURL
	id="<%=MVCCommandNames.CLOSE_RECEIPT_RESOURCE_COMMAND%>"
	var="closeReceiptResourceURL"> </portlet:resourceURL>
 
 
     <aui:form action="#" method="post" name="closeReceipt" >
			<div style="padding: 0px 20px;">
			
			<aui:input name="closeReceiptId" value="<%=receiptId %>" type="text"/>
			<aui:input name="closeReceiptMovementId" value="<%=rmId %>"  type="hidden"/>
			<aui:input name="userPostId" value="<%=userPostsVal%>" type="text"/>
		 	<aui:input label="label-closereceipt-remark" name="closingRemarks" id="closingRemarks"
					type="textarea" style="height:70px;">
					<aui:validator name="required"></aui:validator>
					<aui:validator name="maxLength">
						<liferay-ui:message key="close-receipt-remarks-maxlength" />
					</aui:validator>
				</aui:input>
			</div>
			<hr style="margin: 1rem 0rem 0rem 0rem;" />
		 	<div style="text-align: right; padding: 10px 20px;">
					<aui:button type="button" class="btn btn-primary" value="label-closereceipt-button-submit" onClick="submitCloseReceiptPopUP()" />
				<aui:button type="cancel" class="btn btn-primary" value="label-closereceipt-button-cancel">
					</aui:button>
			</div>		
    </aui:form>

		
		
	<!-- success message for close Receipt  -->
	<!-- ---------------------- succes message  ---------------------------  -->
<div class="portlet-msg-success" style="display:none;     
	bottom: 20px;
    left: 20px;
    position: fixed;
    z-index: 5000; 
    border:1px solid green;
    width:240px;
    height:50px
    " 
    id="successMsg">
  Receipt closed successfully
</div>
		
		

		<script type="text/javascript">
				function validateForm(closeReceipt){
					var liferayForm = Liferay.Form.get(closeReceipt);
						if(liferayForm){
							var validator = liferayForm.formValidator;
							 validator.validate();
							 var hasErrors = validator.hasErrors();
							 if(hasErrors){
								 validator.focusInvalidField();
								 return false;
								 }
							}
							return true;
						}

			function pageReload() {
				parent.location.href = '<%=backPageURL%>';
				}	
					
					/* send receipt pop up with validation  */
			function submitCloseReceiptPopUP(){
				if(validateForm('<portlet:namespace/>closeReceipt')){
					AUI().use('aui-io-request','aui-base','io', function(A){
						var form = A.one("#<portlet:namespace/>closeReceipt");
						     A.io.request('<%=closeReceiptResourceURL.toString()%>', {
							method : 'post',
							form : {
								id : form
							},
							on : {
								success :  function() { 
				            		   document.getElementById("successMsg").style.display="block";
					   	           		setTimeout(pageReload, 1500)  
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