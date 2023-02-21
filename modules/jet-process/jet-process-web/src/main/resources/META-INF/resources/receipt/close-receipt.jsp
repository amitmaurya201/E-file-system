<%@ include file="../init.jsp"%>

<%
   

long receiptId = (long) renderRequest.getAttribute("receiptId");
long rmId = (long) renderRequest.getAttribute("rmId");
String backPageURL = (String)renderRequest.getAttribute("backPageURL");
System.out.println("backPageURL----"+backPageURL);
%>
<%--  
<portlet:actionURL var="closeReceiptURL" name="<%=MVCCommandNames.CLOSE_RECEIPT_ACTION_COMMAND%>">
 
</portlet:actionURL>
 --%>
 
 
<portlet:resourceURL
	id="<%=MVCCommandNames.CLOSE_RECEIPT_RESOURCE_COMMAND%>"
	var="closeReceiptResourceURL">
</portlet:resourceURL>
 
 
     <aui:form action="${closeReceiptURL}" method="post" name="closeReceipt" >
			<div style="text-align: left; height: 100px;">
			
			<aui:input name="receiptId" value="<%=receiptId %>" type="hidden"/>
			<aui:input name="rmId" value="<%=rmId %>" type="hidden"/>
			<aui:input name="userPostId" value="<%=userPostsVal%>" type="hidden"/>
		 	<aui:input label="label-closereceipt-remark" name="closingRemarks" id="closingRemarks"
					type="textarea" style="height:70px;">
					<aui:validator name="required"></aui:validator>
					<aui:validator name="maxLength">
						<liferay-ui:message key="receipt-sent-remarks-maxlength" />
					</aui:validator>
				</aui:input>
			</div>
			<hr style="margin: 2rem -1rem 1rem -1rem;" />
		<!-- 	<div style="text-align: right; padding-bottom: 10px;"></div>
		 -->	
		 <aui:button-row>
				<aui:button type="button" class="btn btn-primary" value="label-closereceipt-button-submit" onClick="submitCloseReceiptPopUP()" style=" margin: auto 40%;  background-color: #007bff; border-color: #007bff !important;" >
					<%-- <liferay-ui:message key="label-closereceipt-button-submit" /> --%>
				</aui:button>
				<aui:button type="button" class="btn btn-primary" value="label-closereceipt-button-cancel" id="close">
					<%-- <liferay-ui:message key="label-closereceipt-button-cancel" />
		 --%>		</aui:button>
			</aui:button-row>
		</aui:form>

		

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
				parent.location.reload();
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
								success : function() {
									swal({
										text : this.get('responseData'),
									})
									setTimeout(pageReload, 1500);
									
								}
							}
						});
					});

				} else {
					return false;
				}
			}
	
		</script>