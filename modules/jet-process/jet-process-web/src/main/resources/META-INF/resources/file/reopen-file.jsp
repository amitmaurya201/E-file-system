<%@ include file="../init.jsp"%>

<portlet:resourceURL
	id="<%=MVCCommandNames.REOPEN_FILE_RESOUCE_COMMAND%>"
	var="reopenFileResourceURL" />

<aui:form name="reopenFile" method="post">
	<aui:container>
		<aui:input type="hidden" name="fileId" value="${fileId}" />
		<aui:input type="hidden" name="closedFileId" value="${closedFileId}" />
		<aui:input type="hidden" name="reopenMovementId" value="${reopenMovementId}" />
		<aui:input type="hidden" name="userPostId"  value="<%=userPostsVal%>"  />
		<aui:input type="textarea" label="label-file-reopen-remarks"
			 name="reopenRemarks">
			<aui:validator name="required" />
			<aui:validator name="maxLength">
				<liferay-ui:message key="file-reopen-remark-maxlength"></liferay-ui:message>
			</aui:validator>
		</aui:input>
	</aui:container>
		<aui:button-row>
			<aui:button type="cancel" cssClass="btn btn-primary" value="label-reopen-cancel-button" />
			<aui:button type="button" cssClass="btn btn-primary" onClick="submitReopenFile()" value="label-reopen-submit-button" />
		</aui:button-row>
</aui:form>

<script>
function validateForm(reopenFile){
	var liferayForm = Liferay.Form.get(reopenFile);
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
function submitReopenFile(){
	if(validateForm('<portlet:namespace/>reopenFile')){
		AUI().use('aui-io-request','aui-base','io',function(A){
			var form = A.one("#<portlet:namespace/>reopenFile");
			A.io.request('<%=reopenFileResourceURL.toString() %>',{
				method : 'post',
				form : {
					id : form
				},
				on :{
					success : function(){
						parent.location.reload();
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