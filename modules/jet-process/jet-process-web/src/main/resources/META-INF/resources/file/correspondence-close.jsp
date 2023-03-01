<%@ include file="../init.jsp"%>


<aui:form action="#" method="post" name="closeReceiptForm">
						<aui:input name="receiptId" type="text" value="${ receiptId}"></aui:input>
						<aui:input name="rmId" type="text" value="${rmId }"></aui:input>
						<aui:input name="userPostId" value="<%=userPostsVal%>"
							type="hidden" ></aui:input>
						<aui:input label="" name="closingRemarks" type="textarea">
							<aui:validator name="required" />
						</aui:input>
						<div class="float-right">
							<aui:button type="button" cssClass="btn btn-primary"
								value="label-detach-confirmation-button"
								onclick="receiptClose()"></aui:button>
							<aui:button type="button" id="close-btn"
								cssClass="btn btn-primary ml-2"
								value="label-detach-confirmation-cancel" ></aui:button>
						</div>
</aui:form>

			<!-- ---------------------- succes message  ----------------------------->
	<div class="portlet-msg-success" style="display:none;     
		bottom: 20px;
	    left: 20px;
	    position: fixed;
	    z-index: 5000; 
	    border:1px solid green;
	    width:350px;
	    height:80px;
	    font-size:1rem;
	    " 
	    id="successMsg">
	    <liferay-ui:message key="label-detach-success-message"></liferay-ui:message>
	  
	</div>
<portlet:resourceURL
	id="<%=MVCCommandNames.CLOSE_RECEIPT_RESOURCE_COMMAND%>"
	var="closeReceiptResourceURL">
</portlet:resourceURL>
	
<script>

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

function receiptClose(){
	alert("close receipt...")
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

</script>