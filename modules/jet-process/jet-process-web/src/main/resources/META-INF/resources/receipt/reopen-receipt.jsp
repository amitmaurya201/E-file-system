<%@ include file="../init.jsp"%>


<%
   

long receiptId = (long) renderRequest.getAttribute("receiptId");
long reopenMovementId = (long) renderRequest.getAttribute("reopenMovementId");


%>

<portlet:resourceURL
	id="<%=MVCCommandNames.REOPEN_RECEIPT_RESOURCE_COMMAND%>"
	var="reopenReceiptResourceURL"> </portlet:resourceURL>
 
 
     <aui:form action="#" method="post" name="ReopenReceipt" >
			<div style="padding: 0px 20px;">
			
			<aui:input name="reopenReceiptId" value="<%=receiptId %>" type="hidden"/>
			<aui:input name="reopenReceiptMovementId" value="<%=reopenMovementId %>" type="hidden"/>
			<aui:input name="userPostId" value="<%=userPostsVal%>" type="hidden"/>
			
		 	<aui:input label="label-reopenreceipt-remark" name="reopenRemarks" id="reopenRemarks"
					type="textarea" style="height:70px;">
					<aui:validator name="required"></aui:validator>
					<aui:validator name="maxLength">
						<liferay-ui:message key="receipt-reopen-remarks-maxlength" />
					</aui:validator>
				</aui:input>
			</div>
			<hr style="margin: 1rem 0rem 0rem 0rem;" />
		 	<div style="text-align: right; padding: 10px 20px;">
					<aui:button type="button" class="btn btn-primary" value="label-reopen-receipt-button-submit" onClick="submitReopenReceiptPopUp()" />
				<aui:button type="cancel" class="btn btn-primary" value="label-reopen-receipt-button-cancel">
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
  Receipt reopen successfully
</div> 
		
		

		<script type="text/javascript">
				function validateForm(ReopenReceipt){
					var liferayForm = Liferay.Form.get(ReopenReceipt);
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
				parent.location.reload();
				}	
				
					/* send receipt pop up with validation  */
			function submitReopenReceiptPopUp(){
				if(validateForm('<portlet:namespace/>ReopenReceipt')){
					AUI().use('aui-io-request','aui-base','io', function(A){
						var form = A.one("#<portlet:namespace/>ReopenReceipt");
						     A.io.request('<%=reopenReceiptResourceURL.toString()%>', {
							method : 'post',
							form : {
								id : form
							},
							on : {
								success :  function() {
									
								//	parent.location.reload();
				            		  document.getElementById("successMsg").style.display="block";
					   	           	     setTimeout(pageReload, 1500);
				            		   
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