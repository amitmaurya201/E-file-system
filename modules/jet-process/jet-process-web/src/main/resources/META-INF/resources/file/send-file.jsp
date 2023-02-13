<%@ include file="../init.jsp"%>
<%
	long fileMovementId = (long) renderRequest.getAttribute("fileMovementId");
	long fileId = (long) renderRequest.getAttribute("fileId");
%>
<portlet:resourceURL id="<%=MVCCommandNames.FILE_SEND_RESOURCE_COMMAND %>" var="sendFileResourceURL">
</portlet:resourceURL>

<aui:form action="#"  name="sendFileForm"  method="post" style="padding: 4% !important">
	<input type="hidden" name="<portlet:namespace/>senderId"
		value="<%=selectedUserPostId%>">
	<input type="hidden" name="<portlet:namespace/>fileId"
		value="<%=fileId%>">
	
	<input type="hidden" name="<portlet:namespace/>fileMovementId"
		value="<%=fileMovementId%>">
	<aui:col cssClass="mt-3">
		<div class="textOnInput">
			<label><liferay-ui:message key="label-send-to" /><span
				class="text-danger">*</span></label>
			<aui:select label="" name="receiverId" id="receiverId">
				<aui:option value=''>
					<liferay-ui:message key="label-send-default-option" />
				</aui:option>
				<%
					List<UserPost> userPostList = UserPostLocalServiceUtil.getUserPosts(-1, -1);
								List<UserPost> newUserPostList = new ArrayList<>(userPostList);
								out.println("inside scriptlet");
								UserPost selectedUserPost = UserPostLocalServiceUtil
										.getUserPost(Long.parseLong(selectedUserPostId));
								boolean isUserPostAvailable = newUserPostList.contains(selectedUserPost);
								if (isUserPostAvailable) {
									newUserPostList.remove(selectedUserPost);
								}
								if (newUserPostList != null) {
									for (UserPost userPost : newUserPostList) {
				%>
				<aui:option value="<%=userPost.getUserPostId()%>"><%=userPost.getUserName() %>(<%=userPost.getPostMarking()%>)<%=userPost.getSectionName()%></aui:option>
				<%
					}
								}
				%>
				<aui:validator name="required" />
			</aui:select>
		</div>
	</aui:col>
	<aui:col cssClass="mt-3">
		<div class="textOnInput">
			<label><liferay-ui:message key="label-send-due-date" /><span
				class="text-danger">*</span></label>
			<aui:input type="text" name="dueDate" id="dueDate" label=""
				placeholder="dd/mm/yyyy">
				<aui:validator name="required" />
				<aui:validator name="custom" errorMessage="error-send-due-date">
					function(val){
						let d = val.split("/");
    					let date = new Date(d[2] + '/' + d[1] + '/' + d[0]);		
						var today = new Date();
						const yesterday = new Date(today)
						yesterday.setDate(yesterday.getDate() - 1)
						return (yesterday < date);
					}
				</aui:validator>
			</aui:input>
		</div>
	</aui:col>
	<aui:col cssClass="mt-3">
		<div class="textOnInput">
			<label><liferay-ui:message key="label-send-priorty" /></label>
			<aui:select label="" name="priorty" id="priorty">
				<aui:option value=''>
					<liferay-ui:message key="label-send-default-option" />
				</aui:option>
				<aui:option value='Highest'>
					<liferay-ui:message key="label-send-option-highest" />
				</aui:option>
				<aui:option value='High'>
					<liferay-ui:message key="label-send-option-high" />
				</aui:option>
				<aui:option value='Medium'>
					<liferay-ui:message key="label-send-option-medium" />
				</aui:option>
				<aui:option value='Low'>
					<liferay-ui:message key="label-send-option-low" />
				</aui:option>
			</aui:select>
		</div>
	</aui:col>
	<aui:col cssClass="mt-3">
		<div class="textOnInput">
			<label><liferay-ui:message key="label-sent-remark" /></label>
			<aui:input type="textarea" label="" name="remark" id="remark"
				style="height:70px;">
				<aui:validator name="maxLength">
					<liferay-ui:message key="sent-remark-maxlength" />
				</aui:validator>
			</aui:input>
		</div>
	</aui:col>
	<aui:button-row>
		<aui:button type="button" class="btn btn-primary"  id="click" onClick="submitSendFileForm()"
			style=" margin: auto 40%;  background-color: #007bff; border-color: #007bff !important;" value="label-send-submit-button" />
	</aui:button-row>
</aui:form>

<script type="text/javascript">
function validateForm(sendFileForm){
	var liferayForm = Liferay.Form.get(sendFileForm);
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

	function submitSendFileForm(){
		if(validateForm('<portlet:namespace/>sendFileForm')){
		   	AUI().use('aui-io-request','aui-base','io', function(A){
			 var form = A.one("#<portlet:namespace/>sendFileForm");
			 
		        A.io.request('<%=sendFileResourceURL.toString()%>', {
		        	 method: 'post',
		        	 form:{
		                 id:form
		             },
		               on: {
		                    success: function() {
		                    	 swal({
		         		             text: this.get('responseData'),        
		        					})
		        					setTimeout(pageReload, 1500);
		                    }
		               }
		            });
		    });
			
		}else{
	    	return false; 
	     }
	}


	$(document).ready(function() {
		$("#<portlet:namespace/>dueDate").datepicker({
			format : 'dd/mm/yyyy'
		});
	});
</script>