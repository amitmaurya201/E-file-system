<%@ include file="../init.jsp"%>

<portlet:resourceURL
	id="<%=MVCCommandNames.REOPEN_FILE_RESOUCE_COMMAND%>"
	var="reopenFileResourceURL" />

<aui:form name="reopenFile" method="post">
	<aui:container>
		<aui:input type="hidden" name="fileId" value="${fileId}" />
		<aui:input type="hidden" name="closedFileId" value="${closedFileId}" />
		<aui:input name="userPostId" value="<%=userPostsVal%>" type="hidden" />
		<aui:input type="textarea" name="label-file-reopen-remarks"
			id="reopenRemarks">
			<aui:validator name="required" />
			<aui:validator name="maxLength">
				<liferay-ui:message key="file-reopen-remark-maxlength"></liferay-ui:message>
			</aui:validator>
		</aui:input>
	</aui:container>
		<aui:button-row>
			<aui:button type="cancel" cssClass="btn btn-primary" value="label-reopen-cancel-button" />
			<aui:button type="button" cssClass="btn btn-primary" value="label-reopen-submit-button" />
		</aui:button-row>
</aui:form>

<aui:script>
	AUI().use('aui-io-request','aui-base','io',function(reopen){
		var from = reopen.one("#<portlet:namespace/>reopenFile");
		reopen.io.request('<%=reopenFileResourceURL.toString() %>',{
			method : 'post',
			from : {
				id : from
			},
			on :{
				success : function(){
					console.log('saved');
				}
			}
		});
	});
</aui:script>